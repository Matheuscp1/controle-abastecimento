package com.abastecimento;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.abastecimento.domain.entity.SupplyEntity;
import com.abastecimento.domain.entity.UsersEntity;
import com.abastecimento.domain.repository.SupplyRepository;
import com.abastecimento.domain.repository.UserRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configureApplicationContex = 
		SpringApplication.run(DemoApplication.class, args);
		UserRepository userRepository = configureApplicationContex.getBean(UserRepository.class);
		SupplyRepository supplyRepository = configureApplicationContex.getBean(SupplyRepository.class);
		
		UsersEntity user = new UsersEntity( "admin", "123");
		userRepository.save(user);
		SupplyEntity supplyEntity = new SupplyEntity(1L, "ABCDEFG-102", 510L, LocalDate.now(), "10:30",  new BigDecimal("500.50"));
		supplyRepository.save(supplyEntity);
	}

}
