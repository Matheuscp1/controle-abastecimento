package com.abastecimento.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abastecimento.domain.entity.Users;



@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	public Optional<Users> findByUserNameAndPassword(String userName, String password);
}
