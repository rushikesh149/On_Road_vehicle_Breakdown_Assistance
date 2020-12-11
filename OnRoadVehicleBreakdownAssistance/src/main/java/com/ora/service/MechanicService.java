package com.ora.service;


import java.util.List;

import com.ora.entity.Feedback;
import com.ora.entity.Mechanic;
import com.ora.entity.Service;

public interface MechanicService {
	public List<Service> viewRequest(int mecId);
	public List<Feedback> viewFeedback(int mecId);
	public boolean addMechanic(Mechanic mcn);


}