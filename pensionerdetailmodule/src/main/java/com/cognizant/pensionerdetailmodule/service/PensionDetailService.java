package com.cognizant.pensionerdetailmodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pensionerdetailmodule.dao.PensionDetailDaoImpl;
import com.cognizant.pensionerdetailmodule.models.PensionerDetail;

@Service
public class PensionDetailService {
	
	@Autowired
	private PensionDetailDaoImpl pensionDetailDaoImpl;
	
	public PensionerDetail getPensionerDetail(Long aadharNumber) {
		// TODO Auto-generated method stub
		return pensionDetailDaoImpl.getPensionserDetail(aadharNumber);
	}

}
