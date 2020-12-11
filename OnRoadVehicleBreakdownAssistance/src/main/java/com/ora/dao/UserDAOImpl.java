package com.ora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.ora.entity.User;
import com.ora.util.JPAUtil;

public class UserDAOImpl implements UserDAO{
	final static Logger logger = Logger.getLogger(ServiceDAOImpl.class);
	public boolean addUser(User user) {
		logger.info("User added");
		EntityManager entityManager =JPAUtil.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
			entityManager.close();
			return true;
		
		}
	
	public List<User> viewUserDetails() {
		logger.info("User viewed");
		EntityManager entityManager =JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query q = entityManager.createQuery("FROM User");
		List<User> list=q.getResultList();
		return list;
		
	}
	
	public boolean updateUser(User user) {
		logger.info("User updated");
		EntityManager entityManager= JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
		entityManager.close();
		return true;
	}

}
