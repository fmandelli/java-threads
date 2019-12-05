package com.mndlli.learning.thread;

import java.util.ArrayList;
import java.util.List;


/**
 * Main class used to demonstrate how multithreading and 
 * synchronized block code work.
 * 
 * @author fmandelli
 * @version 1.0
 * @since 2019-12-05
 *
 */
public class Main {	
	
	
	/**
	 * Main method that creates all threads and generates a 
	 * bulk of records to be used in the demonstration
	 * @param args
	 */
	public static void main(String args[]) {
		
		StaffManagement staffMgnt = new StaffManagement();
		
		//records are generated and set within the Staff Management's ArrayList
		List<Employee> people = generateRecords();
		staffMgnt.setStaff(people);

		//threads are instantiated
		StaffManagementThread pr1 = new StaffManagementThread("thread-1", staffMgnt);
		StaffManagementThread pr2 = new StaffManagementThread("thread-2", staffMgnt);
		StaffManagementThread pr3 = new StaffManagementThread("thread-3", staffMgnt);
		
		//starts threads
		pr1.start();
		pr2.start();
		pr3.start();
		
		//puts all thread on wait until they are dead
		try {
			pr1.join();
			pr2.join();
			pr3.join();
		} catch ( Exception e) {
			System.out.println("Interrupted");
		}
		
		printRecords(people);
	} 
	
	
	/**
	 * Generates a bulk or Employee objects within a for-loop
	 * @return an list of Employee objects is returned.
	 */
	private static List<Employee> generateRecords() {
		
		List<Employee> people = new ArrayList<Employee>();
		Employee employee;
		
		for (int i = 0; i <= 100; i++) {
			employee = new Employee();
			employee.setId(i);
			employee.setName("person" + i);
			people.add(employee);
			System.out.println("Record created: " + employee.toString());
		}
		return people;
	}
	
	
	/**
	 * Prints all Employee objects within an ArrayList
	 * @param people is a list of Employee objects
	 */
	private static void printRecords(List<Employee> people) {
		
		people.forEach(e -> {
			System.out.println(e.toString());
		});
	}

}
