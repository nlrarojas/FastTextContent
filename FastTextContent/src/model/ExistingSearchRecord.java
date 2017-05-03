package model;

import java.util.concurrent.Semaphore;

import javax.swing.JPanel;

import view.SearchContent;

public class ExistingSearchRecord extends Thread{
	private double requiredTime;
	private String keyWord;
	private Semaphore semaphore;
	private JPanel JpHtmlContent;

	private ExistingSearch Search;
	private SearchContent SearchContentRequired;

	public ExistingSearchRecord(String pKeyWord, JPanel pJpHtmlContent){
		this.requiredTime = 0.0;
		this.keyWord = pKeyWord;
		this.JpHtmlContent = pJpHtmlContent;
		semaphore = new Semaphore(1);
		Search = new ExistingSearch();
		SearchContentRequired = new SearchContent();
	}

	public void run(){
		try{
			this.semaphore.acquire();
			double startTime = System.nanoTime();
			
			getSearchContentSaved();
			
			double endTime = System.nanoTime();
			requiredTime = (endTime - startTime) / 1000000;
			
			Search.addObserver(SearchContentRequired);
			Search.searchComplete(requiredTime);
			JpHtmlContent.add(SearchContentRequired);
			JpHtmlContent.revalidate();
			
		}catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}finally{
			this.semaphore.release();
		}
	}
	
	public void getSearchContentSaved(){
		SearchContentRequired = SearchHistory.getInstance().getRecord(keyWord);
	}
	
	public SearchContent getSearchContentRequired() {
		return SearchContentRequired;
	}

	public void setSearchContentRequired(SearchContent searchContentRequired) {
		SearchContentRequired = searchContentRequired;
	}
}
