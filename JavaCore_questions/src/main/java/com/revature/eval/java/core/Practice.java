package com.revature.eval.java.core;

public class Practice {

	public static void main(String[] args) {
		System.out.println(("Aasd Sasdf Hasdf"));
	}
	
	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			
			// extract all side lengths into variables
			double sideOne = getSideOne();
			double sideTwo = getSideTwo();
			double sideThree = getSideThree();
			
			// if all side lengths are equal, return true
			if (sideOne == sideTwo && sideTwo == sideThree) {
				return true;
			}
			
			// else return false
			return false;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			
			// extract all side lengths into variables
			double sideOne = getSideOne();
			double sideTwo = getSideTwo();
			double sideThree = getSideThree();
						
			// if at least two sides are equal, return true
			if (isEquilateral() || ((sideTwo == sideThree) && (sideTwo == sideOne)) || 
					((sideOne == sideTwo) && (sideOne == sideThree)) ||
					((sideThree == sideOne) && (sideThree == sideTwo))) {
				return true;
			}
						
			// else return false
			return false;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			
			// if not isosceles of equilateral, then return true
			if (!isEquilateral() && !isIsosceles()) {
				return true;
			}
			
			// else return false
			return false;
		}

	}
}
