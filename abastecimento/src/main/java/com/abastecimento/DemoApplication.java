package com.abastecimento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.abastecimento.domain.entity.UsersEntity;
import com.abastecimento.domain.repository.UserRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configureApplicationContex = 
		SpringApplication.run(DemoApplication.class, args);
		UserRepository userRepository = configureApplicationContex.getBean(UserRepository.class);
		UsersEntity user = new UsersEntity( "admin", "123");
		userRepository.save(user);
	}

}
