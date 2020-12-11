package com.ora.test.dao;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ora.entity.Feedback;
import com.ora.entity.Mechanic;
import com.ora.util.JPAUtil;

public class MechanicDAOImplTest {


	@Test
	public void testAddMechanic() {
			EntityManager entityManager =JPAUtil.getFactory().createEntityManager();
			entityManager.getTransaction().begin();
			BigInteger f = new BigInteger("1234587690");
			Mechanic mcnentity = new Mechanic(20,"rahul","rahul123","rahul@gmail.com",f,"repairing","mumbai" );
			entityManager.persist(mcnentity);
			entityManager.getTransaction().commit();
			assertNotNull(mcnentity);
			entityManager.close();
			
	
	}

	@Test
	public void testViewMechanicDetails() {
		EntityManager entityManager =JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();		
		Query q = entityManager.createQuery("FROM Mechanic");
		List<Mechanic> list=q.getResultList();
		entityManager.close();
		assertNotNull(list);
	}

}