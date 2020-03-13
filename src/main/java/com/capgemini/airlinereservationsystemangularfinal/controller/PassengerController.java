package com.capgemini.airlinereservationsystemangularfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.airlinereservationsystemangularfinal.beans.BookingBean;
import com.capgemini.airlinereservationsystemangularfinal.dataresponse.BookingResponse;
import com.capgemini.airlinereservationsystemangularfinal.service.BookingServieImpl;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class PassengerController {

	@Autowired
	private BookingServieImpl service;
	
	@PostMapping(path = "/Booking",produces = MediaType.APPLICATION_JSON_VALUE,
			     consumes = MediaType.APPLICATION_JSON_VALUE)
	 public BookingResponse booking(@RequestBody BookingBean booking) {
		BookingResponse response = new BookingResponse();
		
		if(service.booking(booking)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Booking succesfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("user registration failed");
		}
		return response;
	}
	@GetMapping(path = "/getticket", produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse getAllUsers() {
		List<BookingBean> bookingList = service.getticket();
		BookingResponse response = new BookingResponse();
		if (bookingList != null && bookingList.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("user record found");
			
		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("user record not found");
		}
		return response;
	}
}
