package com.capgemini.airlinereservationsystemangularfinal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.capgemini.airlinereservationsystemangularfinal.beans.UserInfoBean;

import lombok.extern.java.Log;

@Log
@Repository
public class UserDaoImpl implements UserDao{
	@PersistenceUnit
	private EntityManagerFactory entityManager;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public boolean register(UserInfoBean userInfoBean) {
		EntityManager manager = entityManager.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		UserInfoBean userInfo = new UserInfoBean();
		userInfo.setUsername(userInfoBean.getUsername());
		userInfo.setPassword(userInfoBean.getPassword());
		userInfo.setEmailId(userInfoBean.getEmailId());
		userInfo.setMobile(userInfoBean.getMobile());
		userInfo.setUserRole(userInfoBean.getUserRole());
		
		try {
			userInfo.setPassword(encoder.encode(userInfo.getPassword()));
			manager.persist(userInfo);
			transaction.commit();
			return true;
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
			return false;
		}
	}

	@Override
	public List<UserInfoBean> getuser(String username) {
		EntityManager manager = entityManager.createEntityManager();
		String jpql= "select e from UserInfoBean e where e.username=:username";
		TypedQuery<UserInfoBean> query = manager.createQuery(jpql, UserInfoBean.class);
		query.setParameter("username", username);
		return query.getResultList();
	}// end of getuser
	
	@Override
	public List<UserInfoBean> getAllUsers() {
		EntityManager manager = entityManager.createEntityManager();
		String jpql = "select a from UserInfoBean a";
		TypedQuery<UserInfoBean> query = manager.createQuery(jpql, UserInfoBean.class);
		return query.getResultList();
	}
	

	@Override
	public boolean updateUser(UserInfoBean bean) {
		EntityManager manager = entityManager.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		UserInfoBean infoBean = manager.find(UserInfoBean.class, bean.getUserId());
		infoBean.setMobile(bean.getMobile());
		infoBean.setPassword(bean.getPassword());
		infoBean.setEmailId(bean.getEmailId());
		infoBean.setUsername(bean.getUsername());
		infoBean.setUserRole(bean.getUserRole());
		try {
			manager.persist(infoBean);
			transaction.commit();
			return true;
		}catch(Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
			return false;
		}
		
	}
}
