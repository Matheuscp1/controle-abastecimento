package com.abastecimento.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abastecimento.domain.entity.SupplyEntity;

public interface SupplyRepository extends JpaRepository<SupplyEntity, Long> {

}
