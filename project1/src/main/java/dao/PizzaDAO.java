package dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pizza;
import util.JDBCConnection;

public class PizzaDAO implements IPizza {

	@Override
	public List<Pizza> getPizzas(int o_id) {
		String sql = "select * from pizza where o_id = ?";
		List<Pizza> pizzas = new ArrayList<>();
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, Integer.toString(o_id));
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				pizzas.add(new Pizza(
						rs.getInt("P_ID"),
						rs.getInt("O_ID"),
						rs.getString("P_SIZE"),
						rs.getString("CRUST"),
						rs.getString("SAUCE"))
						);
			}
			ps.close();
			rs.close();
			return pizzas;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addPizza(Pizza p) {
		String sql = "call add_pizza(?,?,?,?)";
		try {
			CallableStatement cs = JDBCConnection.getConnection().prepareCall(sql);
			cs.setString(1, Integer.toString(p.getO_id()));
			cs.setString(2, p.getP_size());
			cs.setString(3, p.getCrust());
			cs.setString(4, p.getSauce());
			cs.execute();
			cs.close();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Pizza> allPizzas() {
		String sql = "select * from pizza";
		List<Pizza> pizzas = new ArrayList<>();
		
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				pizzas.add(new Pizza(
						rs.getInt("P_ID"),
						rs.getInt("O_ID"),
						rs.getString("P_SIZE"),
						rs.getString("CRUST"),
						rs.getString("SAUCE"))
						);
			}
			ps.close();
			rs.close();
			return pizzas;
		} 
			catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
