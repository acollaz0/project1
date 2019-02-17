package dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PizzaOrder;
import util.JDBCConnection;

public class PizzaOrderDAO implements IPizzaOrder {

	@Override
	public List<PizzaOrder> getOrder(int u_id) {
		String sql = "select * from pizza_order where u_id = ?";
		List<PizzaOrder> orders = new ArrayList<>();

		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, Integer.toString(u_id));

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				orders.add(new PizzaOrder(
						rs.getInt("O_ID"),
						rs.getInt("U_ID"),
						rs.getInt("TOTAL"),
						rs.getString("STATUS"),
						rs.getString("DATETIME"),
						rs.getInt("SAVED")));
			}
			rs.close();
			return orders;
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
			rs.close();
			return orders;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addOrder(PizzaOrder p) {
		String sql = "call add_order(?,?,?,?,?)";
		try {
			CallableStatement cs = JDBCConnection.getConnection().prepareCall(sql);
			cs.setString(1, Integer.toString(p.getU_id()));
			cs.setString(2, Integer.toString(p.getTotal()));
			cs.setString(3, p.getStatus());
			cs.setString(4, p.getDatetime());
			cs.setString(5, Integer.toString(p.getSaved()));
			cs.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean saveOrder(int o_id) {
		String sql = "update pizza_order set saved = 1 where o_id = ?";
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, Integer.toString(o_id));
			ps.executeQuery();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateStatus(int o_id, String status) {
		String sql = "update pizza_order set status = ? where o_id = ?";
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, status);
			ps.setString(2, Integer.toString(o_id));
			ps.executeQuery();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<PizzaOrder> activeOrders() {
		String sql = "select * from pizza_order where status not in 'Complete'";
		List<PizzaOrder> orders = new ArrayList<>();
		
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
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
			rs.close();
			return orders;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
