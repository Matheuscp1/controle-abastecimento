package com.abastecimento.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
	@Column(name = "plate",nullable = false)
	@NotEmpty(message = "Placa é obrigatório")
	private String plate;
	
	@Column(name = "mileage",nullable = false)
	@NotEmpty(message = "Quilometragem é obrigatório")
	private String mileage;
	
	@Column(name = "date",nullable = false)
	@NotNull(message = "Data é obrigatório")
	private LocalDate date;
	
	@Column(name = "hours", nullable = false)
	@NotEmpty(message = "Horas é obrigatório")
	private String hour;
	
	
	@Column(name = "total", nullable = false)
	@DecimalMin(value = "1", message = "Total deve ser maior que 0")
	private BigDecimal  total;

}
