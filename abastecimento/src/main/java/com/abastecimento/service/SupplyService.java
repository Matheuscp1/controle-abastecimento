package com.abastecimento.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.abastecimento.domain.entity.SupplyEntity;
import com.abastecimento.rest.dto.SupplyDTO;

public interface SupplyService {

	public SupplyEntity save(SupplyDTO supply);
	public SupplyEntity update(SupplyDTO supply);
	public Page<SupplyDTO> getAll(Pageable pageable);
	public SupplyDTO getById(Long id);
	public void delete(Long id);
	public void validateSupply(SupplyDTO supply);
}
