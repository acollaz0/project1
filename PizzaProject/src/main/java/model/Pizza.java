package model;

public class Pizza implements Item {
	private String orderID;
	private static String[] toppingnames = {"Pepperoni","Sausage","Cheese","Mushrooms"};
	private int[] toppings;
	public Pizza(String orderID, String details) {
		this.orderID = orderID;
		String[] tops = details.split(",");
		for (int i = 0; i < tops.length; i++){
			this.toppings[i] = Integer.parseInt(tops[i]);
		}
	}
	@Override
	public String getOrderID() {
		return orderID;
	}
	@Override
	public String getDetails() {
		return null;
	}
	@Override
	public String getType() {
		return "Pizza";
	}
}
