package com.abastecimento.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abastecimento.domain.entity.Users;
import com.abastecimento.domain.repository.UserRepository;
import com.abastecimento.expection.NotFoundException;
import com.abastecimento.rest.dto.UsersDTO;
import com.abastecimento.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	
	public Users login(UsersDTO user) {
		Users findUser =  userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword())
				.orElseThrow(() ->  new NotFoundException("Usuário não encontrado"));
		return findUser;
	}

}
