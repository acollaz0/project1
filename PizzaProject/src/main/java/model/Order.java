package model;

import java.util.List;

public class Order {
	private List<Item> items;
	private String address;
	private String orderID;
	private String username;
	public Order(List<Item> items, String address, String orderID, String username) {
		super();
		this.items = items;
		this.address = address;
		this.orderID = orderID;
		this.username = username;
	}
	public List<Item> getItems() {
		return items;
	}
	public String getAddress() {
		return address;
	}
	public String getOrderID() {
		return orderID;
	}
	public String getUsername() {
		return username;
	}
	
}
