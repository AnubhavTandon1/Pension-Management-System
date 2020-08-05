package com.cognizant.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.cognizant.portal.clients.AuthServiceClient;
import com.cognizant.portal.clients.ProcessPensionClient;
import com.cognizant.portal.exception.TokenInvalidException;
import com.cognizant.portal.model.JwtResponse;
import com.cognizant.portal.model.Login;
import com.cognizant.portal.model.PensionDetail;
import com.cognizant.portal.model.PensionerInput;
import com.cognizant.portal.model.ProcessPensionInput;
import com.cognizant.portal.repository.PensionTableRepository;

import feign.FeignException;
import feign.FeignException.FeignClientException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PortalService {

	@Autowired
	private AuthServiceClient authServiceClient;

	@Autowired
	private ProcessPensionClient processPensionClient;

	@Autowired
	private PensionTableRepository pensionTableRepository;

	private static int countHit = 0;
	private static String token;

	public String getPensionerPage(PensionerInput pensionerInput, Login login) {
		ResponseEntity<JwtResponse> response = null;
		try {
			response = authServiceClient.authenticateUserAndGetDetails(login);
			if (response.getStatusCode().equals(HttpStatus.OK) && response.getBody() != null) {
				token = getToken(response);
				if (authServiceClient.validateToken(token)) {
					log.debug("Login successfull");
					return "pensionerdetails";
				}
				
			}
		} catch (FeignException | TokenInvalidException e) {
			log.debug("token invalid page");
			return "tokeninvalid";
		}
		return "login";
	}

	public String getToken(ResponseEntity<JwtResponse> response) {
		return response.getBody().getToken();
	}

	public String submitPensionInput(PensionerInput pensionerInput, Model model) {
		try {
			PensionDetail pensionDetail = null;

			if (authServiceClient.validateToken(token)) {
				log.debug("token validated");
				pensionDetail = processPensionClient.getPensionDetail(token, pensionerInput);
				if (pensionDetail == null)
					return "notverified";
				else {
					if (pensionDetail.isSelfPension())
						model.addAttribute("pensionType", "Family");
					else
						model.addAttribute("pensionType", "Self");
					model.addAttribute("name", pensionDetail.getName());
					model.addAttribute("pan", pensionDetail.getPan());
					model.addAttribute("dob", pensionDetail.getDateOfBirth());
					model.addAttribute("pensionAmount", pensionDetail.getPensionAmount());
					return "verified";
				}
			}

		} catch (FeignClientException | TokenInvalidException e) {
			return "tokeninvalid";
		}
		return "notverified";

	}

	public String disburseProcess(ProcessPensionInput processPensionInput) {
		try {
			if (authServiceClient.validateToken(token)) {
				Integer code = processPensionClient.getDisbursementCode(token, processPensionInput);
				if (code == 10) {
					pensionTableRepository.save(processPensionInput);
					return "success";
				}

				else if (code == 20) {
					if (countHit == 3) {
						countHit = 0;
						return "limitexceeded";
					}
					countHit++;
					return "paycredit";

				} else {
					if (countHit == 3) {
						countHit = 0;
						return "limitexceeded";
					}
					countHit++;
					return "unknown";

				}

			}
		} catch (FeignClientException | TokenInvalidException e) {
			return "tokeninvalid";
		}
		return "unknown";
	}

}
