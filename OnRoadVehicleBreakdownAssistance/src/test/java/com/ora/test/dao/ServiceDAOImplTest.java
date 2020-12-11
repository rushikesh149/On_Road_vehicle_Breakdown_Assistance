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

import com.ora.entity.Mechanic;
import com.ora.entity.Service;
import com.ora.util.JPAUtil;

public class ServiceDAOImplTest {


	@Test
	public void testAddService() {
				EntityManager entityManager =JPAUtil.getFactory().createEntityManager();
				entityManager.getTransaction().begin();
				Service service = new Service(9, "repairing",5, "pune");
				entityManager.persist(service);
				entityManager.getTransaction().commit();
				assertNotNull(service);
				entityManager.close();
				
		
	}

	@Test
	public void testViewService() {
		EntityManager entityManager =JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query q = entityManager.createQuery("FROM Service");
		List<Service> list=q.getResultList();
		for(Service m:list) {
			System.out.println(m.toString());
		}
		entityManager.close();
		assertNotNull(list);
	}

}