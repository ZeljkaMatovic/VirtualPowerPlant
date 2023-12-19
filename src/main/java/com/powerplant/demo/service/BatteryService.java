package com.powerplant.demo.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.powerplant.demo.model.Battery;
import com.powerplant.demo.model.BatteryStatistic;
import com.powerplant.demo.repository.BatteryRepository;

@Service
public class BatteryService implements IBatteryService {
	@Autowired
	BatteryRepository batteryRepository;
	
	@Value("${sorting.order:asc}")
    private String sortingOrder;

	@Override
	public void addBattery(List<Battery> batteries) {
		// TODO Auto-generated method stub
		this.batteryRepository.saveAll(batteries);
		
	}

	@Override
	public List<String> getBatteryNamesInPostcodeRange(String startPostcode, String endPostcode) {
		// TODO Auto-generated method stub
		return this.batteryRepository.findByPostcodeBetweenOrderByPostcodeAsc(startPostcode, endPostcode)
				.stream()
				.map(Battery::getName)
				.sorted(this.getSortingOrder())
				.collect(Collectors.toList());
	}
	
	private Comparator<String> getSortingOrder() {
		return this.sortingOrder.equals("asc") ? Comparator.naturalOrder() : Comparator.reverseOrder();
	}

	@Override
	public BatteryStatistic getBatteryStatistics(String startPostcode, String endPostcode) {
		// TODO Auto-generated method stub
		List<Battery> rangeBatteries = batteryRepository.findByPostcodeBetweenOrderByPostcodeAsc(startPostcode, endPostcode)
				.stream()
				.collect(Collectors.toList());;

        int totalWattCapacity = rangeBatteries.stream().mapToInt(Battery::getWattCapacity).sum();
        double averageWattCapacity = rangeBatteries.stream().mapToInt(Battery::getWattCapacity).average().orElse(0);

        return new BatteryStatistic(totalWattCapacity, averageWattCapacity);
	}
	

}
