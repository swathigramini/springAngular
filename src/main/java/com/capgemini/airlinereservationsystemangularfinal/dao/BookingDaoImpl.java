package com.capgemini.airlinereservationsystemangularfinal.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.airlinereservationsystemangularfinal.beans.BookingBean;
import com.capgemini.airlinereservationsystemangularfinal.beans.TicketBean;
import com.capgemini.airlinereservationsystemangularfinal.beans.UserInfoBean;

import lombok.extern.java.Log;

@Log
@Repository
public class BookingDaoImpl implements BookingDao {

	@PersistenceUnit
	private EntityManagerFactory entityManager;
	@Override
	public boolean booking(BookingBean booking) {
		EntityManager manager = entityManager.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();

		BookingBean bBean = new BookingBean();
		bBean.setUserId(bBean.getUserId());
		bBean.setF_id(bBean.getF_id());
		bBean.setSource(bBean.getSource());
		bBean.setDestination(bBean.getDestination());
		bBean.setJourneyDate(bBean.getJourneyDate());
		bBean.setNumOfSeats(bBean.getNumOfSeats());
		bBean.setBookingDateTime(bBean.getBookingDateTime());
		System.err.println(booking.getSource());
		try {
			manager.persist(booking);
			transaction.commit();
			return true;
		} catch (Exception e) {
			
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
		}
		return false;
	}
	
	@Override
	public List<BookingBean> getticket() {
		EntityManager manager = entityManager.createEntityManager();
		String jpql = "select a from BookingBean a";
		try {
			TypedQuery<BookingBean> query = manager.createQuery(jpql, BookingBean.class);
			List<BookingBean> list = query.getResultList();
			return list;
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
		}
		return null;
	}
	}


