package dao;

import model.Employee;

public interface IEmployeeDAO {
	public boolean addEmployee(Employee employee);
	public boolean isEmployee(String username);
	/**
	 * This method is intended to take in the username and plaintext passowrd from the user
	 * @param username 
	 * @param password 
	 * @return true if matching username and password, false if otherwise
	 */
	public boolean validateEmployee(String username, String password);
	public Employee getEmployee(String username);
}
