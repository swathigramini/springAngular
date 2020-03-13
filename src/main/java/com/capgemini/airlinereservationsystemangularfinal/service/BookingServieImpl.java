package com.capgemini.airlinereservationsystemangularfinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.airlinereservationsystemangularfinal.beans.BookingBean;
import com.capgemini.airlinereservationsystemangularfinal.dao.BookingDaoImpl;

@Service
public class BookingServieImpl implements BookingService {

	@Autowired
	private BookingDaoImpl dao;


	@Override
	public List<BookingBean> getticket() {
		return dao.getticket();
	}

	@Override
	public boolean booking(BookingBean booking) {
		return dao.booking(booking);
	}

}
