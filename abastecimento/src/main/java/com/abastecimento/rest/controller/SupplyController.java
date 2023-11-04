package com.abastecimento.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abastecimento.domain.entity.SupplyEntity;
import com.abastecimento.domain.entity.UsersEntity;
import com.abastecimento.rest.dto.SupplyDTO;
import com.abastecimento.service.impl.SupplyServiceImpl;

@RestController
@RequestMapping(value = "/supply")
public class SupplyController {
	
	@Autowired
	SupplyServiceImpl service;
	
	@PostMapping
	public SupplyEntity saveSuply(@RequestBody SupplyDTO supply ) {
		return service.save(supply);
		
	}
	
	@GetMapping
	public List<SupplyEntity> getAll() {
		return service.getAll();
		
	}
}
