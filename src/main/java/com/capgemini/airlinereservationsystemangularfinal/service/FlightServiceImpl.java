package com.capgemini.airlinereservationsystemangularfinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.airlinereservationsystemangularfinal.beans.FlightBean;
import com.capgemini.airlinereservationsystemangularfinal.dao.FlightDaoImpl;


@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightDaoImpl dao;

	@Override
	public boolean flightregister(FlightBean flightbean) {
		return dao.flightregister(flightbean);
	}

	@Override
	public List<FlightBean> searchFlight(String flightName) {
		return dao.searchFlight(flightName);
	}

	@Override
	public List<FlightBean> getallflights() {
		return dao.getallflights();
	}

	@Override
	public boolean deleteflight(int f_id) {
		return dao.deleteflight(f_id);
	}

	@Override
	public boolean updateflight(FlightBean bean) {
		return false;
	}
}
