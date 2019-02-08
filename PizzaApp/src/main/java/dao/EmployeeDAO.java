package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Order;
import model.Pizza;
import util.JDBCConnection;

public class EmployeeDAO implements IEmployee{

	@Override 
	public int login(String uname, String pass) {
		
		return 0;
	}

	@Override
	public boolean registerEmployee(String uname, String pass) {
		return false;
	}

	@Override
	public boolean orderPizza(Order order) {
		return false;
	}

	@Override
	public boolean savePizza(int id, Pizza pizza, int price) {
		return false;
	}

	@Override
	public boolean redeemPoints(int u_id, int o_id) {
		return false;
	}

	@Override
	public Order viewOrder(int u_id) {
		return null;
	}
	@Override
	public List<Order> ViewOrders(int u_id) {
		return null;
	}

	@Override
	public boolean updateOrder(int u_id) {
		return false;
	}

}
