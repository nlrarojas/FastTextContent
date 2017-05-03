package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Semaphore;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import util.Utility;

public class NewSearch extends Thread implements Utility{
	private final String USER_AGENT = "Mozilla/5.0";
	private double requiredTime;
	private String keyWord;
	private Semaphore semaphore;
	private SearchNewResult SearchContent;
	private SearchResultContent SearchContentPanel;
	private StringBuffer resultString;

	public NewSearch(String pKeyWord) {		
		this.keyWord = pKeyWord;
		semaphore = new Semaphore(1);
		SearchContent = new SearchNewResult();
		SearchContentPanel = new SearchResultContent();
	}

	public void run() {
		try {
			try {
				semaphore.acquire();
				System.out.println("Nueva búsqueda");
				double startTime = System.nanoTime();
				sendGet(keyWord);
				double endTime = System.nanoTime();
				requiredTime = (endTime - startTime) / 1000000;
				
				SearchContent.addObserver(SearchContentPanel);
				SearchContent.searchComplete(resultString.toString(), requiredTime, keyWord);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				semaphore.release();
			}					
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendGet (String keyWord) throws ClientProtocolException, IOException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet request = new HttpGet(URL_ADRESS + keyWord);
		request.addHeader("User-Agent", USER_AGENT);
		CloseableHttpResponse response1 = httpclient.execute(request);

		HttpEntity entity1 = response1.getEntity();

		try {	
			BufferedReader rd = new BufferedReader(
					new InputStreamReader(entity1.getContent()));

			resultString = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				resultString.append(line);
			}	
		} finally {
			EntityUtils.consume(entity1);
			response1.close();
			httpclient.close();
		}
	}

	public SearchResultContent getSearchContentPanel() {
		return SearchContentPanel;
	}

	public void setSearchContentPanel(SearchResultContent searchContentPanel) {
		SearchContentPanel = searchContentPanel;
	}
}
