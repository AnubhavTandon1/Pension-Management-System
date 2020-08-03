package com.cognizant.processpensionmodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.processpensionmodule.exception.PensionerNotFoundException;
import com.cognizant.processpensionmodule.model.PensionDetail;
import com.cognizant.processpensionmodule.model.PensionerInput;
import com.cognizant.processpensionmodule.model.ProcessPensionInput;
import com.cognizant.processpensionmodule.service.PensionDetailService;
import com.cognizant.processpensionmodule.service.PensionDisbursementService;

@RestController
public class ProcessPensionController {
//	@Autowired
//	PensionerInputService pensionerInputService;
//	
//	
//	private static final Logger log = LoggerFactory.getLogger(PensionerInputController.class);
	
//	@GetMapping("/pensiondetail")
//	public List<PensionDetail> showPensionerDetails() {
//		log.info("Start Get end Point of PensionerInput....");
//		//set amounts
//		//make ArrayList<PensionDetail> mlist=pensionDetailSrvice.getpnsionListCustomer()--->modeldao-->dao;
//		log.info("End Get end Point of PensionerInput....");
//		return null;
//	}
	
	//For Feign Client PensionerDetail
//	@Autowired
//	private PensionerDetailClient pensionerDetailClient;
//	@GetMapping("/gg")
//	public double getDetails()  {
//		PensionerDetail pensionerDetail;
//		try {
//			pensionerDetail = pensionerDetailClient.getPensionerDetails(865397248653L);//MVC.getAadharNumber());
//		} catch (PensionerNotFoundException e) {
//			// TODO Auto-generated catch block
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
//		}	
//		
//		//return pensionerInputService.calculatePensionAmount(pensionerDetail.getSalaryEarned(),pensionerDetail.getAllowances(),pin);
//		log.debug("Detail : {} ",pensionerDetail);
//		return pensionerDetail.getSalaryEarned();
//		
//		
//	}
	@Autowired
	private PensionDetailService pensionDetailService;
	@Autowired 
	private PensionDisbursementService pensionDisbursementService;
	
	@GetMapping("/pensiondetail")
	public PensionDetail getPensionDetail(@RequestBody PensionerInput pensionerInput) throws PensionerNotFoundException
	{
		return pensionDetailService.getPensionDetail(pensionerInput);
	}
	
	@PostMapping("/processpension")//on confirmation by Admin he will use this method with bankservicecharge;
	public Integer getDisbursementCode(@RequestBody ProcessPensionInput processPensionInput)throws PensionerNotFoundException {
		
		return pensionDisbursementService.getDisbursementCode(processPensionInput);
	}
}
