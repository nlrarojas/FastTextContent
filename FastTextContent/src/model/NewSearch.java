package model;

import java.util.Observable;

public class NewSearch extends Observable{
	
	private String keyWord;
	private String HtmlString;
	private double timeRequired;
	
	public void searchComplete(String pKeyWord, String pHtmlString, double pTimeRequired){
		this.keyWord = pKeyWord;
		this.timeRequired = pTimeRequired;
		this.HtmlString = pHtmlString;
		this.setChanged();
		this.notifyObservers();
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public double getTimeRequired() {
		return timeRequired;
	}

	public void setTimeRequired(double timeRequired) {
		this.timeRequired = timeRequired;
	}

	public String getHtmlString() {
		return HtmlString;
	}

	public void setHtmlString(String htmlString) {
		HtmlString = htmlString;
	}
}
