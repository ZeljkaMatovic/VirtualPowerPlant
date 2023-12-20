package com.powerplant.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Battery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false)
	private String name;
	
	@NotBlank
	@Column(nullable = false)
	private String postcode;
	
	@Column(nullable = false)
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
	
	public Battery() {
		
	}
	
	public Battery(String name, String postcode, int wattCapacity) {
		this.name = name;
		this.postcode = postcode;
		this.wattCapacity = wattCapacity;
	}
}
