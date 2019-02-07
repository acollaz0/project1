package model;

public class User {
	
	private int user_id;
	private String username;
	private String password;
	private String f_name;
	private String l_name;
	private String user_type;
	private int loyalty_points;
	
	/**
	 * Constructor used for getting a User from the database
	 * @param user_id
	 * @param username
	 * @param password
	 * @param f_name
	 * @param l_name
	 * @param user_type
	 * @param loyalty_points
	 */
	public User(int user_id, String username, String password, String f_name, String l_name, String user_type, int loyalty_points) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.f_name = f_name;
		this.l_name = l_name;
		this.user_type = user_type;
		this.loyalty_points = loyalty_points;
	}

	/**
	 * Constructor used for adding a User to the database.
	 * Lacks a user_id parameter because a SQL sequence will generate a new user_id.
	 * @param username
	 * @param password
	 * @param f_name
	 * @param l_name
	 * @param user_type
	 * @param loyalty_points
	 */
	public User(String username, String password, String f_name, String l_name, String user_type, int loyalty_points) {
		super();
		this.username = username;
		this.password = password;
		this.f_name = f_name;
		this.l_name = l_name;
		this.user_type = user_type;
		this.loyalty_points = loyalty_points;
	}

	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the f_name
	 */
	public String getF_name() {
		return f_name;
	}

	/**
	 * @param f_name the f_name to set
	 */
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	/**
	 * @return the l_name
	 */
	public String getL_name() {
		return l_name;
	}

	/**
	 * @param l_name the l_name to set
	 */
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	/**
	 * @return the user_type
	 */
	public String getUser_type() {
		return user_type;
	}

	/**
	 * @param user_type the user_type to set
	 */
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	/**
	 * @return the loyalty_points
	 */
	public int getLoyalty_points() {
		return loyalty_points;
	}

	/**
	 * @param loyalty_points the loyalty_points to set
	 */
	public void setLoyalty_points(int loyalty_points) {
		this.loyalty_points = loyalty_points;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", f_name=" + f_name
				+ ", l_name=" + l_name + ", user_type=" + user_type + ", loyalty_points=" + loyalty_points + "]";
	}
	
	
}
