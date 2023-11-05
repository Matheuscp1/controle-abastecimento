package com.abastecimento.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.abastecimento.domain.entity.SupplyEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SupplyDTO {
	public Long id;
	public String plate;
	
	public Long mileage;
	
	public LocalDate date;
	
	public String hour;
	
	public BigDecimal  total;
	
	public SupplyEntity dtoToEntity() {
		SupplyEntity supply = new SupplyEntity();
		supply.setDate(this.date);
		supply.setPlate(this.plate);
		supply.setId(this.id);
		supply.setHour(this.hour);
		supply.setMileage(this.mileage);
		supply.setTotal(this.total);
		return supply;
	}
}