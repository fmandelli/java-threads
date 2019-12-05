package com.mndlli.learning.thread;

import java.time.LocalDateTime;


public class Employee {
	
	private int id;
	private String name;
	private LocalDateTime lastUpdated;
	private String threadName;
	
	public Employee() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", lastUpdated=" + lastUpdated + ", threadName=" + threadName
				+ "]";
	}

}
