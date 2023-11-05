package com.abastecimento.domain.repository;


import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.abastecimento.domain.entity.SupplyEntity;

@Repository
public interface SupplyRepository extends JpaRepository<SupplyEntity, Long> {

		public SupplyEntity findByPlateAndDateAndHourAndMileageGreaterThanEqual(String plate, LocalDate date,String hour, String mileage);
}
