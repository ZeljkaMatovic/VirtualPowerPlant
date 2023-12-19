package com.powerplant.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerplant.demo.model.Battery;


@Repository
public interface BatteryRepository extends JpaRepository<Battery, Long> {
	List<Battery> findByPostcodeBetweenOrderByPostcodeAsc(String startPostcode, String endPostcode);
}
