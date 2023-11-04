package com.abastecimento.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abastecimento.domain.entity.UsersEntity;



@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long> {

	public Optional<UsersEntity> findByUserNameAndPassword(String userName, String password);
}
