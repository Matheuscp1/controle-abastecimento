package com.abastecimento.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {

	public Users(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@Column(name = "user_name")
	private String userName;
	@Column
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

}
