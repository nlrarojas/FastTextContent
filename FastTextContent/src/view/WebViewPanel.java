package view;


import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

public class WebViewPanel extends JFXPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WebView webView;
	
	public WebViewPanel(String HTMLText){
		Platform.runLater(() -> {
			webView = new WebView();
			this.setScene(new Scene(webView));			
			webView.getEngine().loadContent(HTMLText);
		});
	}
}
