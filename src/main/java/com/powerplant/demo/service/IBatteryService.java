package com.powerplant.demo.service;

import java.util.List;

import com.powerplant.demo.model.Battery;
import com.powerplant.demo.model.BatteryStatistic;

public interface IBatteryService {
	void addBattery(List<Battery> batteries);
	List<String> getBatteryNamesInPostcodeRange(String startPostcode, String endPostcode);
	BatteryStatistic getBatteryStatistics(String startPostcode, String endPostcode);
}
