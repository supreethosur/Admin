package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.FlightModel;
import com.example.Service.AdminService;

@RestController
public class AdminController {


	@Autowired
	AdminService flightService;

	@GetMapping("/{Id}")
	public  String  getFlightsById(@PathVariable Integer Id) throws Exception {
		return "hello" ;
	}
	
	@GetMapping("/getAlFlights")
	public  List<FlightModel>  getAlFlights() throws Exception {
		return flightService.getAllFlights();
	}

	@PostMapping("/addFlights")
	public FlightModel addFlights(@RequestBody FlightModel ipflight) throws Exception {

		return flightService.addFlight(ipflight);
	}


	@DeleteMapping("/deleteFlight/{Id}")
	public void deleteFlight(@PathVariable Integer Id) throws Exception {
		flightService.deleteById(Id);
	}

	@PutMapping("/updateFlight")
	public FlightModel updateFlight(@RequestBody FlightModel flight) throws Exception {
		FlightModel flight1=flightService.updateFlight(flight);
		return flight1;
	}


}
