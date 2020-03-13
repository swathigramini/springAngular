package com.capgemini.airlinereservationsystemangularfinal.service;

import java.util.List;

import com.capgemini.airlinereservationsystemangularfinal.beans.FlightBean;


public interface FlightService {
	public boolean flightregister(FlightBean flightbean);

	public List<FlightBean> searchFlight(String flightName);

	public List<FlightBean> getallflights();

	public boolean deleteflight(int f_id);

	public boolean updateflight(FlightBean bean);
}
