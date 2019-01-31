package model;

public class UserFactory {
	
	/**
	 * getUser method
	 * Copies the fields from a User object to either a Superuser
	 * or RegularUser depending on the type field of the User ("user" or "superuser")
	 * @param u A User object with all fields instantiated
	 * @return A RegularUser if the User is of type "user" or
	 * a Superuser if the User is of type "superuser"
	 */
	public static User getUser(User u) {
		
		// return a RegularUser if the User is of type "user", else return a Superuser
		if (u.getType().equals("user")) {
			return new RegularUser(u);
		} else {
			return new Superuser(u);
		}
	}
}
