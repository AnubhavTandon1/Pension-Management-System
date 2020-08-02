package com.cognizant.pensionerdetailmodule.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.pensionerdetailmodule.exception.PensionerNotFoundException;
import com.cognizant.pensionerdetailmodule.models.PensionerDetail;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PensionDetailDaoImpl implements PensionDetailDao{
	
	private static List<String> pensionerList;//each element refers to the details of each pensioner as consolidated String
	//private static List<PensionerDetail> pensionerDetailList;//each element refers to the PensionerDetail Object
	private static Map<Long,PensionerDetail> mapAadharToPensionerDetail;
	static {
		try {
			pensionerList=Files.lines(Paths.get("pensionerdetail.csv")).collect(Collectors.toList());
			log.debug("Pensioner List : {}",pensionerList);
			if(pensionerList.isEmpty())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"List is not present");
			else
			{
				mapAadharToPensionerDetail=new HashMap<>();
				//pensionerDetailList=new ArrayList<>();
				for(String line:pensionerList)
				{
					String []value=line.split(",");
					PensionerDetail pensionerDetail=new PensionerDetail(value[1],value[2],value[3],Double.valueOf(value[4]),Double.valueOf(value[5]),Boolean.valueOf(value[6]),Boolean.valueOf(value[7]),value[8],value[9],value[10]);
					mapAadharToPensionerDetail.put(Long.valueOf(value[0]), pensionerDetail);
					//pensionerDetailList.add(pensionerDetail);
				}
				log.debug("Pensioner Detail List : {}",mapAadharToPensionerDetail);
			}
			
		} catch (IOException | ResponseStatusException e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public PensionerDetail getPensionserDetail(Long aadharNumber) throws PensionerNotFoundException {
		if(mapAadharToPensionerDetail.containsKey(aadharNumber))
		return mapAadharToPensionerDetail.get(aadharNumber);//return either details , null if not found
		else
			throw new PensionerNotFoundException("Pensioner Not Found with aadhar Number :"+ aadharNumber);
	
	}

}
