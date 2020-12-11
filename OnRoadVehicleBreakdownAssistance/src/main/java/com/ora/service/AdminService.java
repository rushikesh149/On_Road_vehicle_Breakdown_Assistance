package com.ora.service;

import java.util.List;

import com.ora.entity.Feedback;
import com.ora.entity.Mechanic;
import com.ora.entity.User;

public interface AdminService {
	
	public List<Mechanic> viewMechanicDetails();
	public List<User> viewUserDetails();
	public List<Feedback> viewFeedback();
	public boolean allowOrBlockMechanic(int mecId);
	
	}
