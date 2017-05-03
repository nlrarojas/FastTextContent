package model;

import java.util.Observable;

public class ExistingSearch extends Observable{
	
	private double requiredTime;

	public void searchComplete(double pRequiredTime) {
		this.requiredTime = pRequiredTime;
		this.setChanged();
		this.notifyObservers();
	}
	
	public double getTimeRequired() {
		return requiredTime;
	}

	public void setTimeRequired(double timeRequired) {
		this.requiredTime = timeRequired;
	}
}
