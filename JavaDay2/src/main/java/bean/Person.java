package bean;

import java.io.Serializable;

public class Person implements Serializable{ //Serializable is depricated.
	
	//POJO - Plain Old Java Object. 
	
	//For a class to be a bean, a class must have all private fields, 
	//public getters and setters, and implement Serializable.
	//Anything that doesn't meet these requirements is a POJO (Most things in Java are a POJO)
	
	private String name;
	private int ssid;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSsid() {
		return ssid;
	}
	public void setSsid(int ssid) {
		this.ssid = ssid;
	}
	
	
	
}
