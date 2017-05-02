package controller;

import javax.swing.*;

import model.*;

public class DefaultController{

	public DefaultController(){
		
	}

	public SearchResultContent createSearchHistory (String keyWord, JScrollPane JscpHTMLContent){
		SearchResultContent SearchContent = null;
		if(SearchHistory.getInstance().getRecord(keyWord) != null){
			ExistingRecordSearch ExistingSearch = new ExistingRecordSearch(keyWord);
			ExistingSearch.start();
			SearchContent = ExistingSearch.getSearchContentPanel();
		}else{
			NewSearch TemporalResult = new NewSearch(keyWord);
			TemporalResult.start();
			SearchContent = TemporalResult.getSearchContentPanel();
			JscpHTMLContent.add(SearchContent);	
			SearchHistory.getInstance().storedSearchRecord(keyWord, SearchContent);
		}
		return SearchContent;
	}
}
