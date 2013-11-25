package edu.mines.ncoats.hookahtracker;

public class Hookah {

	int id;
	String name;
	int height;
	int numHoses;
	int numBowls;

	//Constructors

	public Hookah() {

	}

	public Hookah(String name, int height, int numHoses, int numBowls) {
		this.name = name;
		this.height = height;
		this.numHoses = numHoses;
		this.numBowls = numBowls;
	}

	//Setters

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setHeight(int height) {
		this.height = height;
	}

	public void setNumHoses(int numHoses) {
		this.numHoses = numHoses;
	}

	public void setNumBowls(int numBowls) {
		this.numBowls = numBowls;
	}

	//Getters

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getHeight() {
		return this.height;
	}

	public int getNumHoses() {
		return this.numHoses;
	}

	public int getNumBowls() {
		return this.numBowls;
	}
}