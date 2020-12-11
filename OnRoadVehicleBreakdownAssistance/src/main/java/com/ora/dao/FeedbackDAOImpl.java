package com.ora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.ora.entity.Feedback;
import com.ora.entity.Mechanic;
import com.ora.entity.User;
import com.ora.util.JPAUtil;

public class FeedbackDAOImpl implements FeedbackDAO{
	final static Logger logger = Logger.getLogger(FeedbackDAOImpl.class);
	public boolean addFeedback(Feedback feedback) {
		logger.info("Adding feedback");
		EntityManager entityManager =JPAUtil.getFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Mechanic mechanic = entityManager.find(Mechanic.class, feedback.getMechanicId());
		boolean flag=false;
		if(mechanic.getMechanicId()!=0) {
			entityManager.persist(feedback);
			entityManager.getTransaction().commit();
			entityManager.close();
			flag=true;
		}
		
		return flag;
		
	}
	
	public List<Feedback> viewFeedback(int mecId)
	{
		logger.info("Viewing Feedbacks");
		EntityManager entityManager =JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query q = entityManager.createQuery("FROM Feedback where mechanicid=?");
		q.setParameter(1,mecId);
		List<Feedback> list=q.getResultList();
		
		return list;
	}

		
	public List<Feedback> viewFeedback()
	{
		logger.info("Admin viewing the Feedbacks");
		EntityManager entityManager =JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query q = entityManager.createQuery("FROM Feedback");
		List<Feedback> list=q.getResultList();
		
		return list;
	}
	
	
	public boolean ratings(int mecId)
	{
		logger.info("Ratings returned");
		EntityManager entityManager =JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query q = entityManager.createQuery("SELECT SUM(ratings) FROM Feedback where mechanicId=?");
		q.setParameter(1, mecId);
		Double rating=(Double) q.getSingleResult();
		System.out.println(rating);
		Query q1 = entityManager.createQuery("SELECT COUNT(ratings) FROM Feedback where mechanicId=?");
		q1.setParameter(1, mecId);
		Long noOfRatings=(Long)q1.getSingleResult();
		Float avg=(float) (rating/noOfRatings);
		System.out.println(noOfRatings);
		boolean flag=false;
		if(avg>=3)
		{
			flag=true;
		}
		else
		{
			Query q2 = entityManager.createQuery("delete FROM Mechanic where mechanicId=?");
			q2.setParameter(1, mecId);
			q2.executeUpdate();
			flag=false;
		}
		return flag;
		
	}
}
