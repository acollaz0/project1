package users;

public class UserFactory {
	public static User getUser(String u, String p) {
		if(registered()) {
//			return new RegisteredUser(u);
		}
		return new RegisteredUser () ;
	}
	//checks DB to see if user ID exists
	public static boolean registered() {
		
		return false;
	}
}
