package model;

import java.util.Observable;

public class SearchNewResult extends Observable{
	protected String HTMLText;
	private double timeSearch;
	private String searchWord;

	public void searchComplete(String pHTMLText, double pTimeSearch, String psearchWord) {		
		this.HTMLText = pHTMLText;
		this.timeSearch = pTimeSearch;
		this.searchWord = psearchWord;
		setChanged();
		this.notifyObservers();
	}
	
	public String getHTMLText() {
		return HTMLText;
	}

	public void setHTMLText(String hTMLText) {
		HTMLText = hTMLText;
	}

	public double getTimeSearch() {
		return timeSearch;
	}

	public void setTimeSearch(double timeSearch) {
		this.timeSearch = timeSearch;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
}
