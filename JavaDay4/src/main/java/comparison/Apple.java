package comparison;

public class Apple {
	
	int mass;
	String color;
	boolean sour;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + mass;
		result = prime * result + (sour ? 1231 : 1237);
		return result;
	}
	//when two objects with different states end up with the same hash number, that's called a hash collision
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Orange) { //instanceof operator returns true or false
			Orange o = (Orange) obj;
			if (this.mass==o.mass) {
				return true;
			} else {return false;}
		}
		
		Apple other = (Apple) obj;
		if (mass != other.mass)
			return false;
		return true;
	}

	//Hashing is a process where we give hopefully unique numeric id to an object's values
	//Designed to be representative of all objects in that state.
	

	//in general, the definition of "equal" is up to the coder
	//The default of .equals will require objects to be of the same class and memory address

	

}
