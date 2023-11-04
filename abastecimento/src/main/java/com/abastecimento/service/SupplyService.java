package com.abastecimento.service;

import java.math.BigDecimal;
import java.util.List;

import com.abastecimento.domain.entity.SupplyEntity;
import com.abastecimento.rest.dto.SupplyDTO;

public interface SupplyService {

	public SupplyEntity save(SupplyDTO supply);
	public List<SupplyEntity> getAll();
	public SupplyDTO getById(BigDecimal id);
	public void delete(SupplyDTO supply);
}
