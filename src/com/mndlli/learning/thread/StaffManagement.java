package com.mndlli.learning.thread;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.IntStream;


/**
 * This class only handles basic methods of 
 * getting from, setting to, and updating records 
 * on an ArrayList
 *  
 * @author fmandelli
 * @version 1.0
 * @since 2019-12-05
 *
 */
public class StaffManagement {
	
	private static List<Employee> staff = new ArrayList<Employee>();
	
	
	/**
	 * Default constructor.
	 */
	public StaffManagement() {
	}	

	
	/**
	 * Returns a staff list containing Employee objects
	 * @return a List of Employee objects
	 */
	public List<Employee> getStaff() {
		return staff;
	}
	

	/**
	 * Sets an entire list of Employee objects within an ArrayList
	 * @param employeeList a list containing Employee objects
	 */
	public void setStaff(List<Employee> employeeList) {
		staff = employeeList;
	}
	

	/**
	 * Sets an Employee object to a specific position into an ArrayList 
	 * @param index is the index position where the Employee object will be set
	 * @param employee is the Employee object to be set
	 */
	public void updateEmployee(int index, Employee employee) {
		staff.set(index, employee);
	}
	
	
	/**
	 * Returns an Employee object that needs to be updated, which is
	 * represented by its "lastUpdated" attribute equals null.
	 * @return an Employee object
	 */
	public Employee getNotUpdatedRecord() {
		//better to use Lambdas instead of loop/while into the ArrayList.
		//Method stream() on a list of objects returns a regular object stream.
		//Then filters any not-updated Employee object.
		return staff.stream()
					.filter(e -> e.getLastUpdated() == null)
					.findAny()
					.orElse(null);
	}
	
	
	/**
	 * Gets the current index of an Employee object within the ArrayList
	 * @param employee is the Employee to get its position within the ArrayList
	 * @return an integer value containing the index of the specified Employee within the ArrayList. 
	 *         In case it does not exist within the ArrayList, -1 is returned
	 */
	public int getCurrentListIndex(Employee  employee) {
		//IntStreams can replace the regular for-loop utilizing IntStream.range()
		return IntStream.range(0, staff.size())
				 		.filter(i -> employee.getId() == staff.get(i).getId())
			 			.findFirst()
			 			.orElse(-1);
	}
	
	



}
