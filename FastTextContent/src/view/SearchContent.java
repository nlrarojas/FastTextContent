package view;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ExistingSearch;
import model.NewSearch;

public class SearchContent extends JPanel implements Observer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel JLabelTimeRequired;
	private JLabel JLabelWordKey;
	private WebViewPanel WebViewContent;
	
	public SearchContent() {
		initialize();
	}
	
	private void initialize() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.WHITE);
		
		JLabelTimeRequired = new JLabel();
		JLabelWordKey = new JLabel();
		WebViewContent = new WebViewPanel();
		
		this.add(JLabelWordKey);
		this.add(JLabelTimeRequired);
		this.add(WebViewContent);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0 instanceof NewSearch){
			NewSearch Search = (NewSearch) arg0;
			JLabelWordKey.setText("Palabra: " + Search.getKeyWord());
			JLabelTimeRequired.setText("Tiempo de búsqueda: " + Search.getTimeRequired() + " milisegundos");
			
			WebViewContent.createWebViewPanel(Search.getHtmlString());
		}
		if(arg0 instanceof ExistingSearch){
			ExistingSearch Search = (ExistingSearch) arg0;
			JLabelTimeRequired.setText("Tiempo de búsqueda: " + Search.getTimeRequired());
		}
	}

	@Override
	public String toString() {
		return "SearchContent [JLabelTimeRequired=" + JLabelTimeRequired.getText() + ", JLabelWordKey=" + JLabelWordKey.getText()
				+ ", \nWebViewContent=" + WebViewContent + "]\n";
	}
	
	
}
