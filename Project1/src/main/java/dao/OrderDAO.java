package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Order;
import util.JDBCConnection;

public class OrderDAO implements IOrder {

	/**
	 * getOrder method
	 * Returns an Order from the database if the given order_id is found
	 * @param order_id The order_id of the order you want to retrieve from the database
	 * @return An Order if the given order_id is found, else null
	 */
	@Override
	public Order getOrder(int order_id) {
		
		try {
			// prepare an SQL statement
			String sql = "SELECT * FROM an_order WHERE order_id = ?";
			
			Connection conn = JDBCConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(order_id));
			
			// Get the results of the SQL statement
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				// pass in the results of the query into a constructor to make an order object
				// and return it
				return new Order(
						rs.getInt("order_id"),
						rs.getDouble("cost"),
						rs.getLong("time_ordered"),
						rs.getString("status"),
						rs.getString("order_type"),
						rs.getInt("saved")						
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * addOrder method
	 * Adds an Order to the database
	 * @param o The Order to add to the database
	 * @return true if the Order was successfully added, else false
	 */
	@Override
	public boolean addOrder(int user_id, Order o) {
		
		try {
			// prepare an SQL procedure call
			String sql = "CALL add_order(?, ?, ?, ?, ?, ?)";
			Connection conn = JDBCConnection.getConnection();
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, Integer.toString(user_id));
			cs.setString(2, Double.toString(o.getCost()));
			cs.setString(3, Long.toString(o.getTime_ordered()));
			cs.setString(4, o.getStatus());
			cs.setString(5, o.getOrder_type());
			cs.setString(6, Integer.toString(o.getSaved()));
			
			// execute the query
			cs.executeQuery();
			
			return true;
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * updateOrder method
	 * Updates an Order's status and saved state
	 * @param The Order to update
	 * @return true if an Order was actually updated, else false
	 */
	@Override
	public boolean updateOrder(Order o) {
		
		try {
			// prepare an SQL statement
			String sql = "UPDATE an_order SET status = ?, saved = ? WHERE order_id = ?";
            Connection conn = JDBCConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, o.getStatus());
            ps.setString(2, Integer.toString(o.getSaved()));
            ps.setString(3, Integer.toString(o.getOrder_id()));
            
            // get the result set from the query
            ResultSet rs = ps.executeQuery();
            
            // return true if at least one row was updated, else false
            return rs.next();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return false;
	}
	
	/**
	 * allActiveOrders method
	 * @return All orders that are active/ not complete
	 */
	@Override
	public List<Order> allActiveOrders() {
		
		List<Order> orders = new ArrayList<Order>();
        try {
        	// prepare an SQL statement
        	String sql = "SELECT * FROM an_order WHERE status NOT LIKE '%complete%' ORDER BY order_id";
			Connection conn = JDBCConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
            
			// get the result set from the query
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
				
				// pass in the results of the query into a constructor to make an order object
            	// then add the order to the orders list
            	orders.add(new Order(
        			rs.getInt("order_id"),
					rs.getDouble("cost"),
					rs.getLong("time_ordered"),
					rs.getString("status"),
					rs.getString("order_type"),
					rs.getInt("saved")	
				));
			}
            
            return orders;
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
	}
	
	/**
	 * allOrdersPerUser method
	 * @param user_id The user id for a user
	 * @return All orders for a given user
	 */
	@Override
	public List<Order> allOrdersPerUser(int user_id) {
		
		List<Order> orders = new ArrayList<Order>();
        try {
        	// prepare an SQL statement
        	String sql = "SELECT * FROM an_order WHERE user_id = ? ORDER BY order_id";
			Connection conn = JDBCConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(user_id));
            
			// get the result set from the query
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
				
				// pass in the results of the query into a constructor to make an order object
            	// then add the order to the orders list
            	orders.add(new Order(
        			rs.getInt("order_id"),
					rs.getDouble("cost"),
					rs.getLong("time_ordered"),
					rs.getString("status"),
					rs.getString("order_type"),
					rs.getInt("saved")	
				));
			}
            
            return orders;
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
	}
	
	/**
	 * allSavedOrdersPerUser method
	 * @param user_id The user id for a user
	 * @return All orders for a given user that are saved
	 */
	@Override
	public List<Order> allSavedOrdersPerUser(int user_id) {
		
		List<Order> orders = new ArrayList<Order>();
        try {
        	// prepare an SQL statement
        	String sql = "SELECT * FROM an_order WHERE user_id = ? and saved = 1 ORDER BY order_id";
			Connection conn = JDBCConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(user_id));
            
			// get the result set from the query
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
				
				// pass in the results of the query into a constructor to make an order object
            	// then add the order to the orders list
            	orders.add(new Order(
        			rs.getInt("order_id"),
					rs.getDouble("cost"),
					rs.getLong("time_ordered"),
					rs.getString("status"),
					rs.getString("order_type"),
					rs.getInt("saved")	
				));
			}
            
            return orders;
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
	}
}
