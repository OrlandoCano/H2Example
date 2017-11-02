package com.model;

public class Person {
	private String name;
	private MyDate dob;

	public Person(String name, MyDate dob) {
		super();
		this.name = name;
		this.dob = dob;
	}

	public Person() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MyDate getDob() {
		return dob;
	}
	public void setDob(MyDate dob) {
		this.dob = dob;
	}
	
}
