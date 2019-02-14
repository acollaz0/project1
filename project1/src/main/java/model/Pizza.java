package model;

public class Pizza {
	private int p_id;
	private int o_id;
	private String p_size;
	private String crust;
	private String sauce;
	
	
	public Pizza() {
		super();
	}
	public Pizza(int p_id, int o_id, String p_size, String crust, String sauce) {
		super();
		this.p_id = p_id;
		this.o_id = o_id;
		this.p_size = p_size;
		this.crust = crust;
		this.sauce = sauce;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getO_id() {
		return o_id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}
	public String getP_size() {
		return p_size;
	}
	public void setP_size(String p_size) {
		this.p_size = p_size;
	}
	public String getCrust() {
		return crust;
	}
	public void setCrust(String crust) {
		this.crust = crust;
	}
	public String getSauce() {
		return sauce;
	}
	public void setSauce(String sauce) {
		this.sauce = sauce;
	}
	@Override
	public String toString() {
		return "Pizza [p_id=" + p_id + ", o_id=" + o_id + ", t_id=" + ", p_size=" + p_size + ", crust=" + crust
				+ ", sauce=" + sauce + "]";
	}
	
	
	

}
