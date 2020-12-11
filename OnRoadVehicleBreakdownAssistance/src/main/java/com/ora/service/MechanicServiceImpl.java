package com.ora.service;
import com.ora.dao.*;
import java.util.List;

import org.apache.log4j.Logger;

import com.ora.entity.Feedback;
import com.ora.entity.Mechanic;
import com.ora.entity.Service;
public class MechanicServiceImpl implements MechanicService {
	final static Logger logger = Logger.getLogger(MechanicServiceImpl.class);
	MechanicDAO dao=new MechanicDAOImpl();
	ServiceDAO sd=new ServiceDAOImpl();
	FeedbackDAO fd=new FeedbackDAOImpl();
	
	public List<Service> viewRequest(int mecId) {
		logger.info("Request viewed");
		return sd.viewService(mecId);
		
	}
	public List<Feedback> viewFeedback(int mecId) {
		logger.info("Feedback viewed");
		return fd.viewFeedback(mecId);
		
	}
	public boolean addMechanic(Mechanic mcn){
		logger.info("Mechanic added");
		dao.addMechanic(mcn);
		return true;
}

	
	

	
	
	

}