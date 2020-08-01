package com.cognizant.processpensionmodule.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessPensionInput {
	private String aadharNumber;
	private double pensionAmt;
}
