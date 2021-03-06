package model;

public class PizzaOrder {
	
	private int o_id;
	private int u_id;
	private int total;
	private String status;
	private String datetime;
	private int saved;
	private String o_type;
	
	public PizzaOrder() {
		super();
	}

	@Override
	public String toString() {
		return "PizzaOrder [o_id=" + o_id + ", u_id=" + u_id + ", total=" + total + ", status=" + status + ", datetime="
				+ datetime + ", saved=" + saved + ", o_type=" + o_type + "]";
	}

	public PizzaOrder(int o_id, int u_id, int total, String status, String datetime, int saved, String o_type) {
		super();
		this.o_id = o_id;
		this.u_id = u_id;
		this.total = total;
		this.status = status;
		this.datetime = datetime;
		this.saved = saved;
		this.o_type = o_type;
	}

	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public int getSaved() {
		return saved;
	}

	public void setSaved(int saved) {
		this.saved = saved;
	}

	public String getO_type() {
		return o_type;
	}

	public void setO_type(String o_type) {
		this.o_type = o_type;
	}
	
	
	
	

}
