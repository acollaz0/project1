package tools;

public class IntTools {
	
	/**
	 * @param i
	 * @param low inclusive
	 * @param high exclusive
	 * @return whether an int i is within the specified range
	 */
	public static boolean inRange(int i, int low, int high) {
		if (i < high && i >= low) {
			return true;
		} else {return false;}
	}

}
