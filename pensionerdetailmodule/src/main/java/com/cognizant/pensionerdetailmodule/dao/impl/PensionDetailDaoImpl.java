package com.cognizant.pensionerdetailmodule.dao.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.pensionerdetailmodule.dao.PensionDetailDao;
import com.cognizant.pensionerdetailmodule.models.PensionerDetail;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PensionDetailDaoImpl implements PensionDetailDao {

	private static List<String> pensionerList;// each element refers to the details of each pensioner as consolidated
												// String
	private static Map<Long, PensionerDetail> mapAadharToPensionerDetail;
	static {
		try {
			pensionerList = Files.lines(Paths.get("pensionerdetail.csv")).collect(Collectors.toList());
			log.debug("Pensioner List : {}", pensionerList);
			mapAadharToPensionerDetail = new HashMap<>();
			for (String line : pensionerList) {
				String[] value = line.split(",");
				PensionerDetail pensionerDetail = new PensionerDetail(value[1], value[2], value[3],
						Double.valueOf(value[4]), Double.valueOf(value[5]), Boolean.valueOf(value[6]),
						Boolean.valueOf(value[7]), value[8], value[9], value[10]);
				mapAadharToPensionerDetail.put(Long.valueOf(value[0]), pensionerDetail);
			}
			log.debug("Pensioner Detail List : {}", mapAadharToPensionerDetail);

		} catch (IOException | ResponseStatusException e) {
			mapAadharToPensionerDetail.clear();
		}
	}

	@Override
	public PensionerDetail getPensionserDetail(Long aadharNumber) {
		if (mapAadharToPensionerDetail.containsKey(aadharNumber))
			return mapAadharToPensionerDetail.get(aadharNumber);// return either details , null if not found

		return null;// Pensioner not found
	}

}
