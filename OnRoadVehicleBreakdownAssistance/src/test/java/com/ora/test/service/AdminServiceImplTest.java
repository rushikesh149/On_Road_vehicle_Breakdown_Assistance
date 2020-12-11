package com.ora.test.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ora.dao.MechanicDAO;
import com.ora.dao.MechanicDAOImpl;
import com.ora.dao.UserDAO;
import com.ora.dao.UserDAOImpl;
import com.ora.entity.Mechanic;

public class AdminServiceImplTest {

	MechanicDAO mda;
	UserDAO uda;
	@Before
	public void setUp()
	{
		mda=new MechanicDAOImpl();
		uda=new UserDAOImpl();
	}
	
	@After
	public void tearDown()
	{
		mda=null;
		uda=null;
	}
	
	@Test
	public void testViewMechanicDetails() {
		mda.viewMechanicDetails();
		assert(true);
	}

	@Test
	public void testViewUserDetails() {
		assertNotNull(uda.viewUserDetails());
	}

}