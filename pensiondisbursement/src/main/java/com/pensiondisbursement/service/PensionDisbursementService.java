package com.pensiondisbursement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pensiondisbursement.model.ProcessPensionInput;
import com.pensiondisbursement.modeldto.PensionerBankDetails;
import com.pensiondisbursement.restclients.PensionerDetailsClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PensionDisbursementService {
	@Autowired
	private PensionerDetailsClient pensionerDetailsClient;

	public Optional<String> getPensionDisbursement(ProcessPensionInput processPensionInput) {
		log.info("Getting bank details for pension details:{}", processPensionInput);
		Long aadhar = processPensionInput.getAadhar();
		PensionerBankDetails pensionerBankDetails = pensionerDetailsClient.getPensionerBankDetails(aadhar);
		log.info("Found pensioner bank details:{} for aadhar:{} from PensionerDetails(REQ2) Service",
				pensionerBankDetails, aadhar);
		// It is a business logic to check pension disbursement
		if (pensionerBankDetails.getAmount() >= processPensionInput.getPensionAmount()) {
			log.info("Pension is disbursed for aadhar:{} and bank account no.:{}", aadhar,
					pensionerBankDetails.getAccountNumber());
			return Optional.of("SUCCESS");
		}
		log.error("Pension is not disbursed for aadhar:{} and bank account no.:{}", aadhar,
				pensionerBankDetails.getAccountNumber());
		return Optional.empty();

	}
}
