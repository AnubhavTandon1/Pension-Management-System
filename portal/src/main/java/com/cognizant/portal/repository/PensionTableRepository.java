package com.cognizant.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.portal.model.ProcessPensionInput;

public interface PensionTableRepository extends JpaRepository<ProcessPensionInput, Integer>{

}
