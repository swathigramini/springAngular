package com.capgemini.airlinereservationsystemangularfinal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.airlinereservationsystemangularfinal.beans.FlightBean;

import lombok.extern.java.Log;

@Log
@Repository
public class FlightDaoImpl implements FlightDao {
	@PersistenceUnit
	private EntityManagerFactory entityManager;

	@Override
	public boolean flightregister(FlightBean flightbean) {
		EntityManager manager = entityManager.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		FlightBean fbean = new FlightBean();
		fbean.setFlightName(fbean.getFlightName());
		fbean.setSource(fbean.getSource());
		fbean.setDestination(fbean.getDestination());
		fbean.setTicketPrice(fbean.getTicketPrice());
		fbean.setTotalSeats(fbean.getTotalSeats());
		fbean.setActive(fbean.isActive());
		System.err.println(flightbean.getFlightName());
		try {
			manager.persist(flightbean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
		}
		return false;
	}

	@Override
	public List<FlightBean> searchFlight(String flightName) {
		String jpql = "select e from FlightBean e where e.flightName=:flightName";
		EntityManager manager = entityManager.createEntityManager();
		TypedQuery<FlightBean> query = manager.createQuery(jpql, FlightBean.class);
		query.setParameter("flightName", flightName);
		return query.getResultList();
	}

	@Override
	public List<FlightBean> getallflights() {
		return null;
	}

	@Override
	public boolean deleteflight(int f_id) {
		EntityManager manager = entityManager.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		FlightBean beans = manager.find(FlightBean.class, f_id );
		manager.remove(beans);
		transaction.commit();
		return true;
	}

	@Override
	public boolean updateflight(FlightBean bean) {
		EntityManager manager = entityManager.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		FlightBean flightbean = manager.find(FlightBean.class,bean.getF_id());
		flightbean.setFlightName(flightbean.getFlightName());
		flightbean.setSource(flightbean.getSource());
		flightbean.setDestination(flightbean.getDestination());
		flightbean.setClassType(flightbean.getClassType());
		flightbean.setTicketPrice(flightbean.getTicketPrice());
		try {
			manager.persist(flightbean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());		}
		return false;
	}
}
}