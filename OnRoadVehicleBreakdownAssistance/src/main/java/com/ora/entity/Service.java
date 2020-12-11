package com.ora.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Service")
public class Service {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Service_Id")
	private int serviceId;
	@Column(name="Service_Type")
	private String serviceType;
	@Override
	public String toString() {
		return "Service [serviceId=" + serviceId + ", serviceType=" + serviceType + ", userId=" + userId + ", location="
				+ location + "]";
	}
	@Column(name="UserId")
	private int userId;
	@Column(name="MechanicId")
	private int mechanicId;
	public int getMechanicId() {
		return mechanicId;
	}

public void setMechanicId(int mechanicId) {
		this.mechanicId = mechanicId;
	}
	@Column(name="Service_location")
	private String location;
	
	public Service(int mechanicId,String serviceType,int userId,String location)
{
	this.mechanicId=mechanicId;
	this.serviceType=serviceType;
	this.userId=userId;
	this.location=location;
}
		
			
			
		

	public Service() {
		super();
		
	}
	
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	

}
