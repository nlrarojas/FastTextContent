package view;

import javax.swing.*;

import util.Utility;

public class PrincipalWindow extends JFrame implements Utility{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDesktopPane desktopPane;
	private PrincipalContent Content;

	public PrincipalWindow(){
		Initialize();
	}

	private void Initialize() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(WIDTH_RESOLUTION, HEIGHT_RESOLUTION);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		desktopPane = new JDesktopPane();
		Content = new PrincipalContent(desktopPane);
		desktopPane.add(Content).setBounds(0, 0, WIDTH_RESOLUTION, 150);
		this.getContentPane().add(desktopPane).setBounds(0, 0, WIDTH_RESOLUTION, HEIGHT_RESOLUTION);
	}
}
