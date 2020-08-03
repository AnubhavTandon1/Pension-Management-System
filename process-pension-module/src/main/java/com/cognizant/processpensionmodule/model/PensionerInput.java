package com.cognizant.processpensionmodule.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PensionerInput {
	private String name;
	private String dateOfBirth;
	private String pan;
	private Long aadharNumber;
	private boolean isSelfPension;
	private boolean isFamilyPension;

}
