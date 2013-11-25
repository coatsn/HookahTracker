package edu.mines.ncoats.hookahtracker;

public class Shisha {

	int id;
	String name;
	int brandId;
	int grams;

	//Constructors

	public Shisha() {

	}

	public Shisha(String name, int brandId, int grams) {
		this.name = name;
		this.brandId = brandId;
		this.grams = grams;
	}

	//Setters

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public void setGrams(int grams) {
		this.grams = grams;
	}

	//Getters

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getBrandId() {
		return this.brandId;
	}

	public int getGrams() {
		return this.grams;
	}
}