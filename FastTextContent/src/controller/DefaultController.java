package controller;

import javax.swing.*;

import util.Utility;
import model.ExistingSearchRecord;
import model.NewSearchRecord;
import model.SearchHistory;
import view.SearchContent;

public class DefaultController implements Utility{
	private NewSearchRecord NewRecord;
	private ExistingSearchRecord ExistingRecord;
	
	public void SearchWords(String pKeyWord, JPanel pJpHTMLContent){
		if(SearchHistory.getInstance().getRecord(pKeyWord) == null){
			NewRecord = new NewSearchRecord(pKeyWord);
			NewRecord.start();
			SearchContent SearchResult = NewRecord.getSearchContentRequired();
			pJpHTMLContent.add(SearchResult);
			SearchHistory.getInstance().storedSearchRecord(pKeyWord, SearchResult);
		}else{
			ExistingRecord = new ExistingSearchRecord(pKeyWord, pJpHTMLContent);
			ExistingRecord.start();
			SearchContent SearchResult = ExistingRecord.getSearchContentRequired();
			pJpHTMLContent.add(SearchResult);
			pJpHTMLContent.revalidate();
		}
	}
}
