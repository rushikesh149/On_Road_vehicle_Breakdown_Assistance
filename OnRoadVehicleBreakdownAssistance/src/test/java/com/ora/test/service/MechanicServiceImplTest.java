package com.ora.test.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ora.dao.FeedbackDAO;
import com.ora.dao.FeedbackDAOImpl;
import com.ora.dao.MechanicDAO;
import com.ora.dao.MechanicDAOImpl;
import com.ora.dao.ServiceDAO;
import com.ora.dao.ServiceDAOImpl;
import com.ora.dao.UserDAO;
import com.ora.dao.UserDAOImpl;
import com.ora.entity.Service;
import com.ora.service.AdminService;
import com.ora.service.AdminServiceImpl;
import com.ora.service.MechanicService;
import com.ora.service.MechanicServiceImpl;
import com.ora.service.UserService;
import com.ora.service.UserServiceImpl;
import com.ora.validate.Validator;

public class MechanicServiceImplTest {
	MechanicDAO mda;
	ServiceDAO sd;
	FeedbackDAO fd;
	AdminService ads = new AdminServiceImpl();
	MechanicService mcn = new MechanicServiceImpl();
	UserService ucn = new UserServiceImpl();
	Validator v = new Validator();
	
	
	@Before
	public void setUp()
	{
		mda=new MechanicDAOImpl();
	 sd=new ServiceDAOImpl();
		 fd=new FeedbackDAOImpl();
	}
	
	@After
	public void tearDown()
	{
		mda=null;
		sd=null;
		fd=null;
	}
	

	@Test
	public void testViewRequest() {
		int mecId=7;
		assertNotNull(mcn.viewRequest(mecId));
	}

	@Test
	public void testViewFeedback() {
		assertNotNull(fd.viewFeedback());
	}

}