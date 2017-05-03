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
	private String HTMLText;
	
	public void createWebViewPanel(String pHTMLText){
		this.HTMLText = pHTMLText;
		Platform.runLater(() -> {
			webView = new WebView();
			this.setScene(new Scene(webView));			
			webView.getEngine().loadContent(this.HTMLText);
			//webView.getEngine().load(pHTMLText);
		});
	}

	public WebView getWebView() {
		return webView;
	}

	public void setWebView(WebView webView) {
		this.webView = webView;
	}

	public String getHTMLText() {
		return HTMLText;
	}

	public void setHTMLText(String hTMLText) {
		HTMLText = hTMLText;
	}
}
