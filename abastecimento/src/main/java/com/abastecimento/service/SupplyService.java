package com.abastecimento.service;

import java.math.BigDecimal;
import java.util.List;

import com.abastecimento.domain.entity.SupplyEntity;
import com.abastecimento.rest.dto.SupplyDTO;

public interface SupplyService {

	public SupplyEntity save(SupplyDTO supply);
	public SupplyEntity update(SupplyDTO supply);
	public List<SupplyDTO> getAll();
	public SupplyDTO getById(Long id);
	public void delete(Long id);
}
