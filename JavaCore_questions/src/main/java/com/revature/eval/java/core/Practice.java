package com.revature.eval.java.core;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice {

	public static void main(String[] args) {
		System.out.println(("___________ \n Practice \n"
				+ "___________"));
		System.out.println(solveWordProblem("What is 1 plus 1?"));		
		
		
	}
	
	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public static int solveWordProblem(String string) {
		// so we get a string of six words
				// we care about the third, fourth and sixth ones
				// so let's store those
				String[] parts = string.split(" ");
				
				Integer x = Integer.parseInt(parts[2]);
				String op = parts[3];
				Integer y = 1;
				if (parts.length==5) {
					String[] ys = parts[4].split("\\?");
					String yy = ys[0];
					y = Integer.parseInt(yy);
				} else {
					String[] ys = parts[5].split("//?");
					String yy = ys[0];
					y = Integer.parseInt(yy);
				}
				System.out.println(String.format("x: %s, y: %s, op: %s", x, y, op));

				// now perform operation depending on operator, op
				if (op.equals("plus")) {
					return x+y;
				} else if (op.equals("minus")) {
					return x-y;
				} else if (op.equals("multiplied")) {
					return x*y;
				} else {
					return x/y;
				}
	}
		
		
}
				
