package model;

import java.util.*;
import javax.swing.*;
import view.WebViewPanel;

public class SearchResultContent extends JPanel implements Observer{

	private static final long serialVersionUID = 1L;
	private JLabel wordLabel;
	private JLabel timeLabel;	
	private WebViewPanel jfxPanel;
	
	public SearchResultContent() {
		init();
	}
	
	private void init(){
		this.setLayout(null);
		this.setSize(1235, 390);
		
		wordLabel = new JLabel();
		timeLabel = new JLabel();
		
		this.add(wordLabel).setBounds(50, 0, 400, 20);
		this.add(timeLabel).setBounds(50, 20, 400, 20);		
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0 instanceof SearchNewResult){			
			SearchNewResult result = (SearchNewResult) arg0;
			wordLabel.setText("Palabra: " + result.getSearchWord());
			timeLabel.setText("Tiempo de búsqueda: " + result.getTimeSearch());
			
			jfxPanel = new WebViewPanel(result.getHTMLText()); 
			this.add(jfxPanel).setBounds(0, 40 , 1235, 350);
		}
		if(arg0 instanceof ExistingResult){
			ExistingResult result = (ExistingResult) arg0;
			timeLabel.setText("Tiempo de búsqueda: " + result.getTimeSearch());
		}
		repaint();
	}

	public JLabel getWordLabel() {
		return wordLabel;
	}

	public void setWordLabel(JLabel wordLabel) {
		this.wordLabel = wordLabel;
	}

	public JLabel getTimeLabel() {
		return timeLabel;
	}

	public void setTimeLabel(JLabel timeLabel) {
		this.timeLabel = timeLabel;
	}
}
