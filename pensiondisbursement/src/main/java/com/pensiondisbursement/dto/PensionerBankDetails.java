package com.pensiondisbursement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

//This model represents REQ2 response entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class PensionerBankDetails {
	private Long accountNumber;
	private String name;
	private String panId;
	private Double amount;
	private String bankName;
	private BankType bankType;

}
