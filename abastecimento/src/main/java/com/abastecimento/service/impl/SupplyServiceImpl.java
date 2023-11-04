package com.abastecimento.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abastecimento.domain.entity.SupplyEntity;
import com.abastecimento.domain.repository.SupplyRepository;
import com.abastecimento.rest.dto.SupplyDTO;
import com.abastecimento.service.SupplyService;

@Service
public class SupplyServiceImpl implements SupplyService {
	
	@Autowired
	private SupplyRepository repository;

	@Override
	public SupplyEntity save(SupplyDTO supply) {
		return repository.save(supply.dtoToEntity());
	}

	@Override
	public List<SupplyEntity> getAll() {
		return repository.findAll();
	}

	@Override
	public SupplyDTO getById(BigDecimal id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(SupplyDTO supply) {
		// TODO Auto-generated method stub
		
	}

}
