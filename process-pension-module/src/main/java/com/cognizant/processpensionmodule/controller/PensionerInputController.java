package com.cognizant.processpensionmodule.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.processpensionmodule.exception.PensionerInputNotFoundException;
import com.cognizant.processpensionmodule.exception.PensionerNotFoundException;
import com.cognizant.processpensionmodule.model.PensionDetail;
import com.cognizant.processpensionmodule.model.PensionerInput;
import com.cognizant.processpensionmodule.model.ProcessPensionInput;
import com.cognizant.processpensionmodule.modeldto.PensionerDetail;
import com.cognizant.processpensionmodule.restclients.PensionerDetailClient;
import com.cognizant.processpensionmodule.service.PensionerInputService;

@RestController
public class PensionerInputController {
	@Autowired
	PensionerInputService pensionerInputService;
	private static final Logger log = LoggerFactory.getLogger(PensionerInputController.class);
	
	@GetMapping("/pensiondetail")
	public List<PensionDetail> showPensionerDetails() {
		log.info("Start Get end Point of PensionerInput....");
		//make ArrayList<PensionDetail> mlist=pensionDetailSrvice.getpnsionListCustomer()--->modeldao-->dao;
		log.info("End Get end Point of PensionerInput....");
		return null;
	}
	
	//For Feign Client PensionerDetail
	@Autowired
	private PensionerDetailClient pensionerDetailClient;
	@GetMapping("/gg")
	public double getDetails()  {
		PensionerDetail pensionerDetail;
		try {
			pensionerDetail = pensionerDetailClient.getPensionerDetails(865397248653L);//MVC.getAadharNumber());
		} catch (PensionerNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}	
		
		//return pensionerInputService.calculatePensionAmount(pensionerDetail.getSalaryEarned(),pensionerDetail.getAllowances(),pin);
		log.debug("Detail : {} ",pensionerDetail);
		return pensionerDetail.getSalaryEarned();
		
		
	}
}
