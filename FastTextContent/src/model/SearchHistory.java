package model;

import java.util.Hashtable;

import view.SearchContent;

public class SearchHistory {
	private static SearchHistory Instance;
	private Hashtable<String, SearchContent> searchRecord;
	
	public SearchHistory(){
		searchRecord = new Hashtable<>();
	}
	
	public synchronized static SearchHistory getInstance(){
		if(Instance == null){
			Instance = new SearchHistory();
		}
		return Instance;
	}
	
	public SearchContent getRecord(String pKeyWord){
		if(searchRecord.containsKey(pKeyWord)){
			return searchRecord.get(pKeyWord);
		}
		return null;
	}
	
	public void storedSearchRecord(String keyWord, SearchContent searchResult){
		if(!searchRecord.containsKey(keyWord)){
			searchRecord.put(keyWord, searchResult);
		}
	}

	public Hashtable<String, SearchContent> getSearchRecord() {
		return searchRecord;
	}

	public void setSearchRecord(Hashtable<String, SearchContent> searchRecord) {
		this.searchRecord = searchRecord;
	}
}
