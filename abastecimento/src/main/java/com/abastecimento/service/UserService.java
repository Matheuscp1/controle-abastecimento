package com.abastecimento.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.abastecimento.domain.entity.UsersEntity;
import com.abastecimento.rest.dto.UsersDTO;


@Service
public interface UserService {
	public UsersEntity login(UsersDTO user);

}
