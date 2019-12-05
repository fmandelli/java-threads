package com.mndlli.learning.thread;

import java.time.LocalDateTime;


/**
 * This class demonstrates how to process records by using 
 * synchronized block code and multithreading
 * 
 * @author fmandelli
 * @version 1.0
 * @since 2019-12-05
 *
 */
public class StaffManagementThread extends Thread {
	
	private Thread t;
	private String threadName;
	private StaffManagement staffMgnt;

	
	/**
	 * Class constructor
	 * @param name is a String to specify the name of the thread.
	 * @param staffManagement This class contains methods to manage staff.
	 */
	StaffManagementThread(String name, StaffManagement staffManagement) {
		threadName = name;
		staffMgnt = staffManagement;
	}
	   	   
	
	/**
	 * Starts a thread.
	 */
	public void start () {
		System.out.println("Starting " +  threadName );
		if (t == null) {
			t = new Thread (this, threadName);
			t.start ();
		}
	}
	   
	
	/**
	 * Is the execution method of the thread.
	 */
	public void run() {
		   
		Employee employee;		   
		int currIndex = -1;
		boolean run = true;
		   
		while (run && !Thread.currentThread().isInterrupted()) {
			
			try {
				//sleeps for 0.5 seconds
				Thread.sleep(500);
			}
			catch (InterruptedException e) {
				System.out.println("Thread " + threadName + " was interrupted");
				//restores the interrupted status
				Thread.currentThread().interrupt();
			}
			
			//synchronizes staffMgnt object, to avoid 
			//different threads getting the same record
			synchronized(staffMgnt) {
				
				try {
					//gets next record to be updated
					employee = staffMgnt.getNotUpdatedRecord();
					   
					System.out.println("Thread " + threadName + " is processing...");
					   
					if (employee != null) {
						//this variable holds the index/position of the object within the ArrayList,
						//and is going to be used to set an updated object at the same index/position.
						currIndex = staffMgnt.getCurrentListIndex(employee);
						if (currIndex >= 0) {
							employee.setLastUpdated(LocalDateTime.now());
							employee.setThreadName(threadName);
							//here the updated object is place in the 
							//same position it was before
							staffMgnt.updateEmployee(currIndex, employee);
							   
							System.out.println("Thread " + threadName + " updated the following record: " + employee.toString());
						}
					}
					else {
						//no more records for processing
						run = false;
					}
				}
				catch (Exception e) {
					System.out.println("Thread " + threadName + " threw an exception: " + e);
				}
			}			   
		}
		
		System.out.println("Thread " + threadName + " has stopped!");
	}
}
