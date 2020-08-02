package com.pensiondisbursement.model;

import lombok.*;

//This model is input model for REQ3
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PensionDetails {
	private Long aadhar;
	private Double pensionAmount;

}
