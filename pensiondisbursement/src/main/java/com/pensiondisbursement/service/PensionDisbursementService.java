package com.pensiondisbursement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pensiondisbursement.model.PensionerDetail;
import com.pensiondisbursement.model.ProcessPensionInput;
import com.pensiondisbursement.restclients.PensionerDetailClient;

@Service
public class PensionDisbursementService {

	@Autowired
	private PensionerDetailClient pensionerDetailClient;

	private final static int SUCCESS = 10;
	private final static int PAYCREDIT = 20;
	private final static int UNKNOWN = 21;
	private final static int WRONGAADHAR = 0;
	private final static String PUBLIC = "Public";
	private final static String PRIVATE = "Private";

	public Integer getPensionDisbursement(String token, ProcessPensionInput processPensionInput) {
		PensionerDetail pensionDetail = null;
		pensionDetail = getPensionDetail(token, processPensionInput.getAadharNumber());
		if (pensionDetail == null)
			return WRONGAADHAR;
		String bankType = pensionDetail.getBankType();
		Double bankCharge = processPensionInput.getBankCharge();

		switch (bankType) {
		case PRIVATE:
			if (bankCharge == 550)
				return SUCCESS;// Pension disbursement Success
			else if (bankCharge == 0)
				return PAYCREDIT;// Bank service charge not paid now it should pe paid
			break;
		case PUBLIC:
			if (bankCharge == 500)
				return SUCCESS;// Pension disbursement Success
			else if (bankCharge == 0)
				return PAYCREDIT;// Bank service charge not paid
			break;
		default:
			return UNKNOWN;// Bank service charge less or greater than required
		}
		return UNKNOWN;
	}

	public PensionerDetail getPensionDetail(String token, Long aadharNumber) {
		return pensionerDetailClient.getPensionerDetails(token, aadharNumber);
	}
}
