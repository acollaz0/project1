package dao_test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Order;
import model.User;
import service.OrderService;
import service.UserService;


public class OrderDAOTesting {

	@BeforeClass
	public static void beforeClass() {
		UserService.addUser(new User("test_username", "test_password", "test_first", "test_last", "customer"));
		User u = UserService.getUser("test_username");
		Order o = new Order(21.99, 520L, "pending", "pickup", 1);
		OrderService.addOrder(u.getUser_id(), o);
		Order o2 = new Order(19.99, 525L, "complete", "pickup", 1);
		OrderService.addOrder(u.getUser_id(), o2);
	}
	
	@AfterClass
	public static void afterClass() {
		User u = UserService.getUser("test_username");
		UserService.deleteUser(u.getUser_id());
	}
	
	@Test
	public void getExistingOrder() {
		User u = UserService.getUser("test_username");
		List<Order> orders = OrderService.allOrdersPerUser(u.getUser_id());
		assertTrue(OrderService.getOrder(orders.get(0).getOrder_id()) != null);
	}
	
	@Test
	public void addNewOrder() {
		User u = UserService.getUser("test_username");
		Order o = new Order(15.99, 532L, "complete", "delivery", 0);
		assertTrue(OrderService.addOrder(u.getUser_id(), o));
	}
	
	@Test
	public void updateExistingOrder() {
		User u = UserService.getUser("test_username");
		List<Order> orders = OrderService.allOrdersPerUser(u.getUser_id());
		Order o = orders.get(0);
		o.setStatus("ready for pickup");
		assertTrue(OrderService.updateOrder(o));
	}
	
	@Test
	public void getAllActiveOrders() {
		
		assertTrue(OrderService.allActiveOrders().size() == 1);
	}
	
	@Test
	public void getAllOrdersPerUser() {
		User u = UserService.getUser("test_username");
		assertTrue(OrderService.allOrdersPerUser(u.getUser_id()).size() >= 2);
	}
	
	@Test
	public void getAllSavedOrdersPerUser() {
		User u = UserService.getUser("test_username");
		assertTrue(OrderService.allSavedOrdersPerUser(u.getUser_id()).size() == 2);
	}

}
