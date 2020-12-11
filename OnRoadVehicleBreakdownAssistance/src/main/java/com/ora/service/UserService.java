package com.ora.service;

import java.util.List;

import com.ora.entity.Feedback;
import com.ora.entity.Mechanic;
import com.ora.entity.Service;
import com.ora.entity.User;

public interface UserService {
	

		public boolean addUser(User user);
		public boolean updateUser(User user);
		public List<Mechanic> searchMechanic(String location);
		public boolean addRequest(Service service);
		public boolean giveFeedback(Feedback feedback);
		

}

