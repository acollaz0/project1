package testing;


	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	public class Triangle {
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
			if(this.sideOne==this.sideTwo && this.sideTwo == this.sideThree) {
				System.out.println("The triangle is equilateral");
				return true;
			}
			else {
				System.out.println("no equilateral");
				return false;
			}
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			if(this.sideOne==this.sideTwo&&this.sideOne!=this.sideThree||this.sideTwo==this.sideThree&&this.sideTwo!=this.sideOne||this.sideOne==this.sideThree&&this.sideTwo!=this.sideThree) {
			System.out.println("the triangle is Isosceles");
			return true;
			}
			else {
				System.out.println("nope isosceles");
			return false;
			}
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			if(this.sideOne != this.sideTwo && this.sideOne != this.sideThree && this.sideTwo != this.sideThree) {
				System.out.println("The triangle is scalene");
				return true;
			}
			else {
				System.out.println("no scalene");
			return false;
			}
		}

	}

