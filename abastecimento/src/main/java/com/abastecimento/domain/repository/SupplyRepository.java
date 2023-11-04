package com.abastecimento.domain.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abastecimento.domain.entity.SupplyEntity;

@Repository
public interface SupplyRepository extends CrudRepository<SupplyEntity, Long> {

}
