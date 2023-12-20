package com.powerplant.demo;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.powerplant.demo.model.Battery;
import com.powerplant.demo.model.BatteryStatistic;
import com.powerplant.demo.repository.BatteryRepository;
import com.powerplant.demo.service.BatteryService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class BatteryServiceTest {

	@Mock
    private BatteryRepository batteryRepository;

    @InjectMocks
    private BatteryService batteryService;
    
    
    @Test
    void testAddBatteries() {    	
    	List<Battery> batteries = Arrays.asList(
                new Battery("N", "510032", 1200),
                new Battery("A27", "225478", 1000),
                new Battery("Duplex", "187020", 1500)
        );

        when(batteryRepository.saveAll(any())).thenReturn(batteries);

        batteryService.addBattery(batteries);
    }
    
    @Test
    void testGetBatteryStatistics() {
        String startPostcode = "100000";
        String endPostcode = "600000";

        List<Battery> mockBatteries = Arrays.asList(
                new Battery("N", "510032", 1200),
                new Battery("A27", "225478", 1000),
                new Battery("Duplex", "187020", 1500)
        );

        when(batteryRepository.findByPostcodeBetweenOrderByPostcodeAsc(startPostcode, endPostcode))
                .thenReturn(mockBatteries);

        BatteryStatistic batteryStatistic = batteryService.getBatteryStatistics(startPostcode, endPostcode);

        assertEquals(3700, batteryStatistic.getTotalWattCapacity());
        assertEquals(1233.33, batteryStatistic.getAverageWattCapacity(), 0.01);
    }
}
