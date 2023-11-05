package com.abastecimento.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.abastecimento.domain.entity.SupplyEntity;
import com.abastecimento.domain.repository.SupplyRepository;
import com.abastecimento.expection.NotFoundException;
import com.abastecimento.expection.ValidateSupplyMileageExpection;
import com.abastecimento.rest.dto.SupplyDTO;
import com.abastecimento.service.SupplyService;

import jakarta.transaction.Transactional;

@Service
public class SupplyServiceImpl implements SupplyService {

	@Autowired
	private SupplyRepository repository;

	@Override
	@Transactional
	public SupplyEntity save(SupplyDTO supply) {
		return repository.save(supply.dtoToEntity());
	}

	@Override
	public Page<SupplyDTO> getAll(Pageable pageable) {
		Page<SupplyEntity> supplys = repository.findAll(pageable);
		System.out.println(supplys);
		Page<SupplyDTO> supplyDTO = supplys.map(
				s -> new SupplyDTO(s.getId(), s.getPlate(), s.getMileage(), s.getDate(), s.getHour(), s.getTotal())
				);
		return supplyDTO;
	}

	@Override
	public SupplyDTO getById(Long id) {
		SupplyEntity supplyFind = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Abastecimento não encontrado"));
		return supplyFind.toDTO();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		SupplyEntity supplyFind = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Abastecimento não encontrado"));
		repository.delete(supplyFind);
	}

	@Override
	@Transactional
	public SupplyEntity update(SupplyDTO supply) {
		SupplyEntity supplyFind = repository.findById(supply.getId())
				.orElseThrow(() -> new NotFoundException("Abastecimento não encontrado"));
		supplyFind = supply.dtoToEntity();
		return repository.save(supplyFind);
	}

	@Override
	public void validateSupply(SupplyDTO supply) {
		SupplyEntity supplyFind = repository.findFirstByPlateAndDateAndHourAndMileageGreaterThanEqual(supply.getPlate(),
				supply.getDate(), supply.getHour(), supply.getMileage());
		System.out.println(supplyFind);
		if (supplyFind != null) {
			throw new ValidateSupplyMileageExpection("Quilometragem deve ser maior para está data, placa e hora");
		}
	}

}
