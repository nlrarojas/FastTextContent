package model;

import java.util.concurrent.Semaphore;

public class ExistingRecordSearch extends Thread{
	private double requiredTime;
	private String keyWord;
	private Semaphore semaphore;
	private ExistingResult ResultChanged;
	private SearchResultContent SearchContentPanel;

	public ExistingRecordSearch(String pKeyWord){
		this.keyWord = pKeyWord;
		semaphore = new Semaphore(1);
		ResultChanged = new ExistingResult();
		SearchContentPanel = new SearchResultContent();
	}

	public void run(){
		try {
			semaphore.acquire();
			double startTime = System.nanoTime();
			getExistingRecordSearch();			
			double endTime = System.nanoTime();
			requiredTime = (endTime - startTime) / 1000000;
			
			ResultChanged.addObserver(SearchContentPanel);
			ResultChanged.searchComplete(requiredTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			semaphore.release();
		}
	}
	
	public SearchResultContent getExistingRecordSearch(){
		return SearchContentPanel = SearchHistory.getInstance().getRecord(keyWord);
	}

	public SearchResultContent getSearchContentPanel() {
		return SearchContentPanel;
	}

	public void setSearchContentPanel(SearchResultContent searchContentPanel) {
		SearchContentPanel = searchContentPanel;
	}
}
