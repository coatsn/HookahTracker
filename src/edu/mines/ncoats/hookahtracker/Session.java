package edu.mines.ncoats.hookahtracker;

public class Session {

	int id;
	int hookahId;
	int bowlId;
	int shishaId;
	int numCoals;
	String date;

	//Constructors

	public Session() {

	}

	public Session(int hookahId, int bowlId, int shishaId, int numCoals, String date) {
		this.hookahId = hookahId;
		this.bowlId = bowlId;
		this.shishaId = shishaId;
		this.numCoals = numCoals;
		this.date = date;
	}

	//Setters

	public void setId(int id) {
		this.id = id;
	}

	public void setHookahId(int hookahId) {
		this.hookahId = hookahId;
	}

	public void setBowlId(int bowlId) {
		this.bowlId = bowlId;
	}

	public void setShishaId(int shishaId) {
		this.shishaId = shishaId;
	}

	public void setNumCoals(int numCoals) {
		this.numCoals = numCoals;
	}

	public void setDate(String date) {
		this.date = date;
	}

	//Getters

	public int getId() {
		return this.id;
	}

	public int getHookahId() {
		return this.hookahId;
	}

	public int getBowlId() {
		return this.bowlId;
	}

	public int getShishaId() {
		return this.shishaId;
	}

	public int getNumCoals() {
		return this.numCoals;
	}

	public String getDate() {
		return this.date;
	}

}