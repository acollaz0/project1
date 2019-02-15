package dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Toppings;
import util.JDBCConnection;

public class ToppingsDAO implements IToppings {

	@Override
	public Toppings getToppings(int p_id) {
		String sql = "select all from toppings where p_id = ?";
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, Integer.toString(p_id));
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new Toppings(
						rs.getInt("T_ID"),
						rs.getInt("P_ID"),
						rs.getInt("PEPPERONI"),
						rs.getInt("I_SAUSAGE"),
						rs.getInt("BACON"),
						rs.getInt("HAM"),
						rs.getInt("SALAMI"),
						rs.getInt("MUSHROOMS"),
						rs.getInt("B_OLIVES"),
						rs.getInt("B_PEPPERS"),
						rs.getInt("PINEAPPLE"),
						rs.getInt("ONIONS"),
						rs.getInt("G_PEPPERS"),
						rs.getInt("FETA"),
						rs.getInt("SPINACH")
						);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addToppings(Toppings t) {
		String sql = "call add_toppings(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			CallableStatement cs = JDBCConnection.getConnection().prepareCall(sql);
			cs.setString(1, Integer.toString(t.getP_id()));
			cs.setString(2, Integer.toString(t.getPepperoni()));
			cs.setString(3, Integer.toString(t.getI_sausage()));
			cs.setString(4, Integer.toString(t.getBacon()));
			cs.setString(5, Integer.toString(t.getHam()));
			cs.setString(6, Integer.toString(t.getSalami()));
			cs.setString(7, Integer.toString(t.getMushrooms()));
			cs.setString(8, Integer.toString(t.getB_olives()));
			cs.setString(9, Integer.toString(t.getB_peppers()));
			cs.setString(10, Integer.toString(t.getPineapple()));
			cs.setString(11, Integer.toString(t.getOnions()));
			cs.setString(12, Integer.toString(t.getG_peppers()));
			cs.setString(13, Integer.toString(t.getFeta()));
			cs.setString(14, Integer.toString(t.getSpinach()));
			return cs.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
	

}
