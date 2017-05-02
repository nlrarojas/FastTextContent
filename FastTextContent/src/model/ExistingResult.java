package model;

import java.util.Observable;

public class ExistingResult extends Observable{
	private double timeSearch;
	
	public void searchComplete(double pTimeSearch) {		
		this.timeSearch = pTimeSearch;
		setChanged();
		this.notifyObservers();
	}
	
	public double getTimeSearch() {
		return timeSearch;
	}

	public void setTimeSearch(double timeSearch) {
		this.timeSearch = timeSearch;
	}
}
