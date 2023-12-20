package com.powerplant.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class VirtualPowerPlantApplicationTests {
	@Autowired
    private VirtualPowerPlantApplication virtualPowerPlantApplication;

	@Test
	void contextLoads() {
		assertNotNull(virtualPowerPlantApplication);
	}

}
