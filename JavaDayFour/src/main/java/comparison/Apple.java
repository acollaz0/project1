package comparison;

public class Apple {
	
	int mass;
	String color;
	boolean sour;


	
	/*
	 * method designed to see if two objects should be considered equal
	 * the definition is up to you!!
	 * Is part of the object class the default of .equals will require objects to 
	 * be of the same class
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + mass;
		result = prime * result + (sour ? 1231 : 1237);
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apple other = (Apple) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (mass != other.mass)
			return false;
		if (sour != other.sour)
			return false;
		return true;
	}
	
}
