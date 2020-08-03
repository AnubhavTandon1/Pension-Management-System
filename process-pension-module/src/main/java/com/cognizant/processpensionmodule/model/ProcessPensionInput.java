package com.cognizant.processpensionmodule.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessPensionInput {
	private Long aadharNumber;
	private double pensionAmount;
	private double bankCharge;
}
