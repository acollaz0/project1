package dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Order;
import model.Pizza;
import util.JDBCConnection;

public class UserDAO implements IUser{

	@Override
	public int login(String uname, String ppw) {
		//;
		String sql = "SELECT u_id FROM pizzauser natural join pizzapass WHERE pizzauser.uname = ? AND pizzapass.ppw = ?";
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int r = 0;
			while (rs.next()) {
				r = rs.getInt("u_id");
			}
			return r;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean registerUser(String uname, String ppw) {
		String sql = "call add_pizzauser(?,?)";
		try {
			CallableStatement cs = JDBCConnection.getConnection().prepareCall(sql);
			cs.setString(1, uname);
			cs.setString(2, ppw);
			return !cs.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean orderPizza(Order order) {
		String sql = "";
		return false;
	}

	@Override
	public boolean savePizza(int u_id, Pizza pizza) {
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
	public Order lastOrder(int u_id) {
		return null;
	}

	@Override
	public List<Order> ViewOrders(int u_id) {
		return null;
	}
	
}
