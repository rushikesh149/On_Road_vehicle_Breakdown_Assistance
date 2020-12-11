package com.ora.dao;

import java.util.List;
import com.ora.entity.Mechanic;
import com.ora.entity.User;
import com.ora.util.JPAUtil;

import jdk.internal.org.jline.utils.Log;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;


//import com.o.util.DBUtil;

public class MechanicDAOImpl implements  MechanicDAO {
	EntityManager manager;
	final static Logger logger = Logger.getLogger(MechanicDAOImpl.class);
	public boolean addMechanic(Mechanic mechanic) {
		logger.info("Mechanic added");
		EntityManager entityManager =JPAUtil.getFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(mechanic);
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}
	
	public List<Mechanic> viewMechanicDetails() {
		logger.info("Mechanic viewed");
		EntityManager entityManager =JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query q = entityManager.createQuery("FROM Mechanic");
		List<Mechanic> list=q.getResultList();
		return list;
		
	}
	
	public List<Mechanic> searchMechanic(String location){
		logger.info("Mechanic searched");
		EntityManager entityManager =JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query q = entityManager.createQuery("FROM Mechanic m WHERE m.location=?");
		q.setParameter(1,location);
		List<Mechanic> list=q.getResultList();
		
		return list;
	}

	

	

	
	
	

}