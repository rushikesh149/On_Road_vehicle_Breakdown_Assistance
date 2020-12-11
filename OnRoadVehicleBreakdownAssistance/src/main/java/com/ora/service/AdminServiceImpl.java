package com.ora.service;


import java.util.List;

import org.apache.log4j.Logger;

import com.ora.dao.FeedbackDAO;
import com.ora.dao.FeedbackDAOImpl;
import com.ora.dao.MechanicDAO;
import com.ora.dao.MechanicDAOImpl;
import com.ora.dao.UserDAO;
import com.ora.dao.UserDAOImpl;
import com.ora.entity.Feedback;
import com.ora.entity.Mechanic;
import com.ora.entity.User;
import com.ora.exception.UserNotFoundException;

public class AdminServiceImpl implements AdminService {
	final static Logger logger = Logger.getLogger(AdminServiceImpl.class);
	MechanicDAO mda=new MechanicDAOImpl();
	UserDAO uda=new UserDAOImpl();
	FeedbackDAO fd=new FeedbackDAOImpl();


public List<Mechanic> viewMechanicDetails()
{
	logger.info("View mechanic");
     	return  mda.viewMechanicDetails();
	
}

public List<User> viewUserDetails()
{
	logger.info("View user details");
     	return uda.viewUserDetails();
	
}


public List<Feedback> viewFeedback() {
	logger.info("View feedback");
	return fd.viewFeedback();
	
}
public boolean allowOrBlockMechanic(int mecId)
{
	logger.info("Allow or Block Mechanic");
	return fd.ratings(mecId);
	
}


}














































