package edu.mines.ncoats.hookahtracker;

public class Coal {

	int id;
	String name;
	int num;

	//constructors

	public Coal() {

	}

	public Coal(String name, int num) {
		this.name = name;
		this.num = num;
	}

	//Setters

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNum(int num) {
		this.num = num;
	}

	//Getters

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getNum() {
		return this.num;
	}
	
}