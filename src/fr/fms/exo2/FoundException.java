package fr.fms.exo2;

import java.util.Date;

public class FoundException {
	public static void main(String[] args) {
		Date date = null;
		Date today = new Date();
		//	System.out.println(date.getClass().getName());  provoque une exception
		try {
			System.out.println(date.getClass().getName());
		} catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(today.getClass().getName());
	}
}
