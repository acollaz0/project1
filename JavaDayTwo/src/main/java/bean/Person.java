package bean;

import java.io.Serializable;

// for a class to be a bean you need to have 3 things
//1. private fields
//2. public getters and setters
//3. Serializable (old school deprecated)

//Any class that does not meet these requirements is a POJO
// Plain Old Java Object
public class Person implements Serializable{

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
