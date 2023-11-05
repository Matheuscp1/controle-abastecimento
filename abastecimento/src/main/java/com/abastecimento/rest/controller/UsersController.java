package com.abastecimento.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abastecimento.domain.entity.UsersEntity;
import com.abastecimento.rest.dto.UsersDTO;
import com.abastecimento.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	public UserServiceImpl userService;
	
	@PostMapping UsersEntity login(@RequestBody UsersDTO user) {
		System.out.println(user);
		return userService.login(user);
	}
}
