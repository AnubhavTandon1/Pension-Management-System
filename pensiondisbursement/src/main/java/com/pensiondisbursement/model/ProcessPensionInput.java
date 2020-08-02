package com.pensiondisbursement.model;

import java.util.HashMap;

import lombok.*;
//This model is input model for REQ3
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessPensionInput {
	private Long aadhar;
	private Double pensionAmount;
	private int bankServiceCharge;

}
