package bean;

import java.io.Serializable;
//For a class to be a bean you need 3 things
//1.private fields
//2.public getters/setters
//3.Serializable
//If it does not have these 3 it is a POJO
//Plain Old Java Object
public class Person implements Serializable /*Serializable */{
	
	//private fields
	
	private String name;
	private String ssid;
	
	//public getters/setters
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsid() {
		return ssid;
	}
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	
}
