package com.ora.dao;

import java.util.List;

import com.ora.entity.Service;

public interface ServiceDAO {
	
	public boolean addService(Service service);
	public List<Service> viewService(int mecId);

}
