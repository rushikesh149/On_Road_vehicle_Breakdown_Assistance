package com.ora.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.ora.dao.FeedbackDAO;
import com.ora.dao.FeedbackDAOImpl;
import com.ora.dao.MechanicDAO;
import com.ora.dao.MechanicDAOImpl;
import com.ora.dao.ServiceDAO;
import com.ora.dao.ServiceDAOImpl;
import com.ora.dao.UserDAO;
import com.ora.dao.UserDAOImpl;
import com.ora.entity.Feedback;
import com.ora.entity.Mechanic;
import com.ora.entity.Service;
//import com.ora.entity.Service;
import com.ora.entity.User;
import com.ora.util.JPAUtil;

public class UserServiceImpl implements UserService{
	final static Logger logger = Logger.getLogger(UserServiceImpl.class);
	UserDAO obj=new UserDAOImpl();
	MechanicDAO mda=new MechanicDAOImpl();
	FeedbackDAO fda=new FeedbackDAOImpl();
	public boolean addUser(User user) {
		logger.info("User added");
		return obj.addUser(user);
		
	}

	public boolean updateUser(User user) {
		
		logger.info("User updated");
			obj.updateUser(user);
	        return true;
	}

	public List<Mechanic> searchMechanic(String location){
		logger.info("Mechanic searched");
		return mda.searchMechanic(location);
	}

	public boolean addRequest(Service service) {
		logger.info("Request added");
	ServiceDAO sd=new ServiceDAOImpl();
	sd.addService(service);
		return true;
	}

	public boolean giveFeedback(Feedback feedback) {
		logger.info("Feedback given");
		fda.addFeedback(feedback);
		return true;
	}

	
}
