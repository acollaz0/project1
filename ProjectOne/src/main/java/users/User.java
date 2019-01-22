package users;

import java.util.UUID;

public interface User{
	final UUID userID = UUID.randomUUID();	
	boolean login		() ;
	boolean logout		() ;
	boolean withdraw	() ;
	boolean deposit		() ;
	boolean create		() ;
	boolean delete		() ;
	boolean validatePassword(UUID id);
}
