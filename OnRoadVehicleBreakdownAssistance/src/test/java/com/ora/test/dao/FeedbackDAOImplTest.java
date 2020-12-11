package com.ora.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Test;

import com.ora.dao.UserDAOImpl;
import com.ora.entity.Feedback;
import com.ora.entity.User;
import com.ora.util.JPAUtil;

public class FeedbackDAOImplTest {


	@Test
	public void testAddFeedback() {
		EntityManager entityManager =JPAUtil.getFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Feedback feedback=new Feedback(18, 3, 7, "good", 4);
		entityManager.persist(feedback);
		entityManager.getTransaction().commit();
		assertNotNull(feedback);
		entityManager.close();
		
	}
	

	@Test
	public void testViewFeedback() {
		EntityManager entityManager =JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query q = entityManager.createQuery("FROM Feedback");
		List<Feedback> list=q.getResultList();
		System.out.println(list.toString());
		assertNotNull( list);
	}

}