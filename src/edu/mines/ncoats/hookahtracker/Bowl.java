package edu.mines.ncoats.hookahtracker;


public class Bowl {

	int id;
	String name;
	int size;

	//constructors

	public Bowl() {

	}

	public Bowl(String name, int size) {
		this.name = name;
		this.size = size;
	}

	//setters

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSize(int size) {
		this.size = size;
	}

	//Getters

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getSize() {
		return this.size;
	}

}