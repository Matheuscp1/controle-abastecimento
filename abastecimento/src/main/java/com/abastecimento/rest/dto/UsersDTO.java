package com.abastecimento.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsersDTO {
	public Long id;
	public String userName;
	@JsonProperty(access = Access.WRITE_ONLY)
	public String password;
}
