package com.capgemini.airlinereservationsystemangularfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.airlinereservationsystemangularfinal.beans.FlightBean;
import com.capgemini.airlinereservationsystemangularfinal.beans.UserInfoBean;
import com.capgemini.airlinereservationsystemangularfinal.dataresponse.FlightResponse;
import com.capgemini.airlinereservationsystemangularfinal.dataresponse.UserResponse;
import com.capgemini.airlinereservationsystemangularfinal.service.FlightServiceImpl;
import com.capgemini.airlinereservationsystemangularfinal.service.UserServiceImpl;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class AdminController {

	@Autowired
	private UserServiceImpl service;

	@Autowired
	private FlightServiceImpl flightservice;

	@PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse registerUser(@RequestBody UserInfoBean userInfoBean) {
		UserResponse response = new UserResponse();

		if (service.register(userInfoBean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("user registered succesfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("user registration failed");
		}
		return response;
	}

	@GetMapping(path = "/getuser/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse getuser(@PathVariable("username") String username) {
		List<UserInfoBean> userInfoBean = service.getuser(username);
		UserResponse response = new UserResponse();
		
		if (userInfoBean != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("user record found");
			response.setUserList(userInfoBean);
		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("user record not found");
			response.setUserList(null);
		}
		return response;
	}

	@DeleteMapping(path = "/delete/{f_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public FlightResponse deleteFlight(@PathVariable("f_id") int f_id) {
		FlightResponse response = new FlightResponse();
		if (flightservice.deleteflight(f_id)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Data deleted in DB");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data Deleted in DB");
		}
		return response;
	}

	@GetMapping(path = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse getAllUsers() {
		List<UserInfoBean> userList = service.getAllUsers();
		UserResponse response = new UserResponse();
		
		if (userList != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("user record found");
			response.setUserList(userList);
			
		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("user record not found");
		}
		return response;
	}

	@PostMapping(path = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse updateUser(@RequestBody UserInfoBean userInfoBean) {
		UserResponse response = new UserResponse();

		if (service.updateUser(userInfoBean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Data Updated in DB");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data not Updated in  db");
		}
		return response;
	}

	@PostMapping(path = "/updateFlight", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public FlightResponse updateFlight(@RequestBody FlightBean flightBean) {
		FlightResponse response = new FlightResponse();

		if (flightservice.updateflight(flightBean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Data Updated in DB");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data not Updated in  db");
		}
		return response;
	}

	@PostMapping(path = "/flightregister", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public FlightResponse flightregistration(@RequestBody FlightBean flightbean) {
		FlightResponse response = new FlightResponse();
		if (flightservice.flightregister(flightbean)) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescription("Flight Registered SuccessFully!!");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Flight Registered Failed");
		}
		return response;
	}
}