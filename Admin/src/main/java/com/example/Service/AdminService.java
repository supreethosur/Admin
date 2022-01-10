package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Model.FlightModel;

@Service
public class AdminService {
	

	@Autowired
	RestTemplate restTemplate;

	public FlightModel addFlight(FlightModel ipflight) {
		String url="http://localhost:8085/Flight/addFlights";
		ParameterizedTypeReference<FlightModel> responseType= new ParameterizedTypeReference<FlightModel>() {
		};
		
		HttpEntity<FlightModel> httpEntity=new HttpEntity<>(ipflight,null);
		ResponseEntity<FlightModel> res1=restTemplate.exchange(url, HttpMethod.POST, httpEntity, responseType);
		return res1.getBody();
	}

	public void deleteById(Integer id) {
		String url="http://localhost:8085/Flight/deleteFlight/{"+id+"}";
//		ParameterizedTypeReference<> responseType= new ParameterizedTypeReference<>() {
//		};
		
		HttpEntity<?> httpEntity=new HttpEntity<>(null,null);
		ResponseEntity<Void> res1=restTemplate.exchange(url, HttpMethod.DELETE, httpEntity,Void.class);
		
	}

	public FlightModel updateFlight(FlightModel flight) {
		String url="http://localhost:8085/Flight/updateFlight";
		ParameterizedTypeReference<FlightModel> responseType= new ParameterizedTypeReference<FlightModel>() {
		};
		
		HttpEntity<FlightModel> httpEntity=new HttpEntity<>(flight,null);
		ResponseEntity<FlightModel> res1=restTemplate.exchange(url, HttpMethod.PUT, httpEntity, responseType);
		return res1.getBody();
	}

	public List<FlightModel> getAllFlights() {
		
		String url="http://localhost:8085/Flight/GetAllFlights";
		ParameterizedTypeReference<List<FlightModel>> responseType= new ParameterizedTypeReference<List<FlightModel>>() {
		};
		HttpEntity<?> httpEntity=new HttpEntity(null,null);
		ResponseEntity<List<FlightModel>> res=restTemplate.exchange(url, HttpMethod.GET, httpEntity, responseType);
		return res.getBody();
	}
	
	
	

}
