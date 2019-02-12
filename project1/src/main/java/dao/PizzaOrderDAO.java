package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PizzaOrder;
import util.JDBCConnection;

public class PizzaOrderDAO implements IPizzaOrder {

	@Override
	public PizzaOrder getOrder(int u_id) {
		String sql = "select * from pizza_order where u_id = ?";

		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, Integer.toString(u_id));

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return new PizzaOrder(
						rs.getInt("O_ID"),
						rs.getInt("U_ID"),
						rs.getInt("TOTAL"),
						rs.getString("STATUS"),
						rs.getString("DATETIME"),
						rs.getInt("SAVED"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<PizzaOrder> allOrders() {
		String sql = "select * from pizza_order";
		List<PizzaOrder> orders = new ArrayList<>();
		PreparedStatement ps;
		try {
			ps = JDBCConnection.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				orders.add(new PizzaOrder(
						rs.getInt("O_ID"),
						rs.getInt("U_ID"),
						rs.getInt("TOTAL"),
						rs.getString("STATUS"),
						rs.getString("DATETIME"),
						rs.getInt("SAVED")));
			}
			return orders;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addOrder(int u_id) {
		String sql = "call add_order(?,?,?,?,?)";
		
		return false;
	}

	@Override
	public boolean saveOrder(int u_id, int o_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStatus(int o_id) {
		// TODO Auto-generated method stub
		return false;
	}

}
