package com.ora.dao;

import java.util.List;

import com.ora.entity.Mechanic;
import com.ora.entity.User;

public interface MechanicDAO {
	
	public boolean addMechanic(Mechanic mechanic);
	
	public List<Mechanic> viewMechanicDetails();
	public List<Mechanic> searchMechanic(String location);
	

}
