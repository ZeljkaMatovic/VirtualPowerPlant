package com.powerplant.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.powerplant.demo.controller.BatteryController;
import com.powerplant.demo.model.BatteryStatistic;
import com.powerplant.demo.service.BatteryService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;

@WebMvcTest(BatteryController.class)
public class BatteryControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BatteryService batteryService;

	@Test
	void testAddBatteries() throws Exception {
		doNothing().when(batteryService).addBattery(any());

		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/api/batteries/add").contentType("application/json")
						.content("[{\"name\":\"Dalian VFB\", \"postcode\":\"110015\", \"wattCapacity\":400}]"))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	void testGetBatteriesInPostcodeRange() throws Exception {
	    when(batteryService.getBatteryNamesInPostcodeRange("100000", "900000"))
	            .thenReturn(Arrays.asList("A27", "N"));

	    when(batteryService.getBatteryStatistics("100000", "900000")).thenReturn(new BatteryStatistic(2000, 1000));

	    mockMvc.perform(MockMvcRequestBuilders.get("/api/batteries/getNamesInRange").param("startPostcode", "100000")
	            .param("endPostcode", "900000"))
	            .andExpect(MockMvcResultMatchers.status().isOk())
	            .andExpect(MockMvcResultMatchers.jsonPath("$.batteryNames").isArray())
	            .andExpect(MockMvcResultMatchers.jsonPath("$.batteryNames[0]").value("A27"))
	            .andExpect(MockMvcResultMatchers.jsonPath("$.batteryNames[1]").value("N"))
	            .andExpect(MockMvcResultMatchers.jsonPath("$.batteryStatistic.totalWattCapacity").value(2000))
	            .andExpect(MockMvcResultMatchers.jsonPath("$.batteryStatistic.averageWattCapacity").value(1000));
	}

}
