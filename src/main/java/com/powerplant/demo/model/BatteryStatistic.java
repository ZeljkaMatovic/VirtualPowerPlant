package com.powerplant.demo.model;

import java.text.DecimalFormat;

public class BatteryStatistic {
	private int totalWattCapacity;
	private Double averageWattCapacity;
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public int getTotalWattCapacity() {
        return totalWattCapacity;
    }

    public Double getAverageWattCapacity() {
        return averageWattCapacity;
    }
    
    public BatteryStatistic() {
    	
    }
    
    public BatteryStatistic(int totalWattCapacity, double averageWattCapacity) {
        this.totalWattCapacity = totalWattCapacity;
        this.averageWattCapacity = Double.valueOf(df.format(averageWattCapacity));
    }

}
