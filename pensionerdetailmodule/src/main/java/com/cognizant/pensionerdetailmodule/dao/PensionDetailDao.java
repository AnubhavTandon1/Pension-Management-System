package com.cognizant.pensionerdetailmodule.dao;

import com.cognizant.pensionerdetailmodule.exception.PensionerNotFoundException;
import com.cognizant.pensionerdetailmodule.models.PensionerDetail;

public interface PensionDetailDao {
	PensionerDetail getPensionserDetail(Long aadharNumber) throws PensionerNotFoundException; 
}
