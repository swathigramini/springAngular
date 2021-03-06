package com.capgemini.airlinereservationsystemangularfinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.airlinereservationsystemangularfinal.beans.BookingBean;
import com.capgemini.airlinereservationsystemangularfinal.beans.UserInfoBean;
import com.capgemini.airlinereservationsystemangularfinal.dao.BookingDaoImpl;

@Service
public class BookingServieImpl implements BookingService {

	@Autowired
	private BookingDaoImpl dao;

	@Override
	public boolean bookingFlights(BookingBean booking) {
		return dao.bookingFlights(booking);
	}

	@Override
	public List<BookingBean> getTicket(int bookingId) {
		return dao.getTicket(bookingId);
	}

	@Override
	public boolean deleteTicket(int bookingId) {
		return dao.deleteTicket(bookingId);
	}



}
