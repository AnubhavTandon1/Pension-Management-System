package com.cognizant.processpensionmodule.modeldto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PensionerDetail {
	private String name;
	private String dateOfBirth;
	private String pan;
	private double salaryEarned;
	private double allowances;
	private boolean isSelfPension;
	private boolean isFamilyPension;
	private String bankName;
	private String accNo;
	private String bankType;
}
