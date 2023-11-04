package com.abastecimento.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "supply")
public class SupplyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@Column(name = "plate")
	@NotNull
	private String plate;
	
	@Column(name = "mileage")
	@NotNull
	private String mileage;
	
	@Column(name = "date")
	@NotNull
	private LocalDate date;
	
	@Column(name = "hours")
	@NotNull
	private String hour;
	
	
	@Column(name = "total")
	@NotNull
	private BigDecimal  total;

}
