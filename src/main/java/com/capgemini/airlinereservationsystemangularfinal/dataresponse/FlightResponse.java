package com.capgemini.airlinereservationsystemangularfinal.dataresponse;

import java.util.List;

import com.capgemini.airlinereservationsystemangularfinal.dao.FlightDao;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlightResponse {

	private int statusCode;
	private String message;
	private String description;
	
	private FlightDao flightbean;
	private List<FlightDao> flightList;
}
