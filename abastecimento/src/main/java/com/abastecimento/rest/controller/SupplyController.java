package com.abastecimento.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abastecimento.domain.entity.SupplyEntity;
import com.abastecimento.domain.entity.UsersEntity;
import com.abastecimento.domain.repository.SupplyRepository;
import com.abastecimento.rest.dto.SupplyDTO;
import com.abastecimento.service.impl.SupplyServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/supply")
public class SupplyController {
	
	@Autowired
	SupplyServiceImpl service;
	
	
	@Autowired
	SupplyRepository rep;
	
	@PostMapping
	public SupplyEntity saveSuply(@Valid @RequestBody SupplyDTO supply ) {
		return service.save(supply);
		
	}
	
	@GetMapping
	public List<SupplyDTO> getAll() {
		return service.getAll();
		
	}
	
	@GetMapping(value = "{id}")
	public SupplyDTO getByID(@PathVariable Long id) {
		return service.getById(id);
		
	}
	
	@PutMapping()
	public SupplyEntity update(@Valid @RequestBody SupplyDTO supply) {
		return service.update(supply);
	}
	


	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
		
	}
}
