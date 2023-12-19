package com.powerplant.demo.model;

import java.util.List;

public class BatteryTotalInfo {
	private List<String> batteryNames;
    private BatteryStatistic batteryStatistic;
    

    public List<String> getBatteryNames() {
        return batteryNames;
    }

    public BatteryStatistic getBatteryStatistic() {
        return batteryStatistic;
    }
    
    public BatteryTotalInfo(List<String> batteryNames, BatteryStatistic batteryStatistic) {
        this.batteryNames = batteryNames;
        this.batteryStatistic = batteryStatistic;
    }
    
}
