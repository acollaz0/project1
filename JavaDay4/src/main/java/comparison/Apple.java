package comparison;

public class Apple {
	
	int mass;
	String color;
	boolean sour;

	//Hashing is a process by which we give Hopefully unique numeric identification
	//to an object's value
	//Designed to give me one number representative of a certain state
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mass;
		return result;
	}
	//method designed to see if two objects should be considered equal
	//the definition of equal is up to you
	//is part of the object class
	//the default of .equals will require objects to be of the sssame class and memory address
	@Override
	public boolean equals(Object obj) {
		//returns true or false if it is of that class
		if(obj instanceof Orange) {
			Orange o = (Orange) obj;
			if(this.mass == o.mass) {
				return true;
			}
		}
		
		Apple other = (Apple) obj;
		if (mass != other.mass)
			return false;
		return true;
	}
	
	

}
