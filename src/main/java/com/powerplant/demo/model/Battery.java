package com.powerplant.demo.model;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Battery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String postcode;
	private int wattCapacity;
	
	public String getName() {
		return name;
	}
	
	public String getPostcode() {
		return postcode;
	}
	
	public int getWattCapacity() {
		return wattCapacity;
	}
}
