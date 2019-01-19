package com.revature.eval.java.core;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playground {

	public static void main(String[] args) {
		List<Integer> sortedList = Collections.unmodifiableList(Arrays.asList(1, 3, 5, 8, 13, 21, 34, 55, 89, 127, 128, 144, 233, 377, 634));
		BinarySearch<Integer> tree = new BinarySearch<>(sortedList);
		System.out.println(tree.indexOf(128));
	}
		
	static class BinarySearch<T> implements Comparable<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			
			for(T tl : sortedList) {
				if(tl.equals(t)) {
					return sortedList.indexOf(tl);
				}
			}
			
			return 123133;
					
		
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

		@Override
		public int compareTo(T arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

	}
		
	
	

}



