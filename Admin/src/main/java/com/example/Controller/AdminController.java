package com.example.Controller;
 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

	@GetMapping("/{Id}")
	public  String  getFlightsById(@PathVariable Integer Id) throws Exception {
		return "hello" ;
	}


}
