/**
 * 
 */
package com.pensiondisbursement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pensiondisbursement.dto.PensionerBankDetails;
import com.pensiondisbursement.feignproxy.PensionerDetailsProxy;
import com.pensiondisbursement.model.PensionDetails;

import lombok.extern.slf4j.Slf4j;

/**
 * PensionDisbursementService, It uses REQ2 service to get pensionerbankdetails
 * and applies business logic to disburse pension
 * 
 * @author Kunal_Mayur_Raj
 *
 */
@Slf4j
@Service
public class PensionDisbursementService {
	@Autowired
	private PensionerDetailsProxy pensionerDetails;

	public Optional<String> getPensionDisbursement(PensionDetails pensionDetails) {
		log.info("Getting bank details for pension details:{}", pensionDetails);
		Long aadhar = pensionDetails.getAadhar();
		PensionerBankDetails pensionerBankDetails = pensionerDetails.getPensionerBankDetails(aadhar);
		log.info("Found pensioner bank details:{} for aadhar:{} from PensionerDetails(REQ2) Service",
				pensionerBankDetails, aadhar);
		// It is a business logic to check pension disbursement
		if (pensionerBankDetails.getAmount() >= pensionDetails.getPensionAmount()) {
			log.info("Pension is disbursed for aadhar:{} and bank account no.:{}", aadhar,
					pensionerBankDetails.getAccountNumber());
			return Optional.of("SUCCESS");
		}
		log.error("Pension is not disbursed for aadhar:{} and bank account no.:{}", aadhar,
				pensionerBankDetails.getAccountNumber());
		return Optional.empty();

	}
}
