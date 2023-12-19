package com.powerplant.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.powerplant.demo")
public class VirtualPowerPlantApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirtualPowerPlantApplication.class, args);
		
		System.out.println("Hello");
	
	}

}
