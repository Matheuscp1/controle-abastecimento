package com.abastecimento.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abastecimento.domain.entity.SupplyEntity;
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
	public SupplyEntity saveSupply(@Valid @RequestBody SupplyEntity supply) {
		service.validateSupply(supply.toDTO());
		return service.save(supply.toDTO());
	}

	@GetMapping
	public Page<SupplyDTO> getAll(Pageable pageable) {
		return service.getAll(pageable);

	}

	@GetMapping(value = "{id}")
	public SupplyDTO getByID(@PathVariable Long id) {
		return service.getById(id);

	}

	@PutMapping()
	public SupplyEntity update(@Valid @RequestBody SupplyEntity supply) {
		return service.update(supply.toDTO());
	}

	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);

	}
}
