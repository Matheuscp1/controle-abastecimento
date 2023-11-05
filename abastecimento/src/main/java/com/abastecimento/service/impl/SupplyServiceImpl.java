package com.abastecimento.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abastecimento.domain.entity.SupplyEntity;
import com.abastecimento.domain.repository.SupplyRepository;
import com.abastecimento.expection.NotFoundException;
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
	public List<SupplyDTO> getAll() {
		List<SupplyEntity> supplys = repository.findAll();
		List<SupplyDTO> supplyDTO = supplys.stream().map(
				s -> new SupplyDTO(s.getId(), s.getPlate(), s.getMileage(), s.getDate(), s.getHour(), s.getTotal()))
				.collect(Collectors.toList());
		return supplyDTO;
	}

	@Override
	public SupplyDTO getById(Long id) {
		SupplyEntity supplyFind = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Abastecimento não encontrado"));
		return supplyFind.toDTO();
	}

	@Override
	public void delete(Long id) {
		SupplyEntity supplyFind = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Abastecimento não encontrado"));
		repository.delete(supplyFind);
	}

	@Override
	public SupplyEntity update(SupplyDTO supply) {
		SupplyEntity supplyFind = repository.findById(supply.getId())
				.orElseThrow(() -> new NotFoundException("Abastecimento não encontrado"));
		supplyFind = supply.dtoToEntity();
		return repository.save(supplyFind);
	}

}
