package com.powerplant.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.powerplant.demo.model.Battery;
import com.powerplant.demo.model.BatteryStatistic;
import com.powerplant.demo.model.BatteryTotalInfo;
import com.powerplant.demo.service.BatteryService;

@RestController
@RequestMapping("/api/batteries")
public class BatteryController {
	@Autowired
	private BatteryService batteryService;
	

	@PostMapping("/add")
	public void AddBatteries(@RequestBody List<Battery> batteries) {
		this.batteryService.addBattery(batteries);
	}
	
	@GetMapping("/getNamesInRange")
    public BatteryTotalInfo getBatteriesInPostcodeRange(@RequestParam String startPostcode,
            @RequestParam String endPostcode) {

        List<String> batteryNames = batteryService.getBatteryNamesInPostcodeRange(startPostcode, endPostcode);
        
        BatteryStatistic batteryStatistic = batteryService.getBatteryStatistics(startPostcode, endPostcode);

        return new BatteryTotalInfo(batteryNames, batteryStatistic);
    }

}
