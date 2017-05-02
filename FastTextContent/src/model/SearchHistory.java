package model;

import java.util.Hashtable;

public class SearchHistory {
	private static SearchHistory Instance;
	private Hashtable<String, SearchResultContent> searchRecord;
	
	public SearchHistory(){
		searchRecord = new Hashtable<>();
	}
	
	public synchronized static SearchHistory getInstance(){
		if(Instance == null)
			Instance = new SearchHistory();
		return Instance;
	}
	
	public SearchResultContent getRecord(String keyWord){
		if(!searchRecord.containsKey(keyWord)){
			return searchRecord.get(keyWord);
		}
		return null;
	}
	
	public void storedSearchRecord(String keyWord, SearchResultContent searchResult){
		if(!searchRecord.containsKey(keyWord)){
			searchRecord.put(keyWord, searchResult);
		}
	}
}
