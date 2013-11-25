package edu.mines.ncoats.hookahtracker;

public class ShishaBrand {

	int id;
	String name;

	//constructors

	public ShishaBrand() {

	}

	public ShishaBrand(String name) {
		this.name = name;
	}

	//Setters

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	//Getters

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

}