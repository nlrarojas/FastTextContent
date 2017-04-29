package view;

import javax.swing.*;

import util.Utility;

public class PrincipalWindow extends JFrame implements Utility{
	
	private JDesktopPane desktopPane;
	private PrincipalContent principalContent;

	public PrincipalWindow(){
		Init();
	}
	
	private void Init(){
		this.setLayout(null);
		this.setSize(WIDTH_RESOLUTION, HEIGHT_RESOLUTION);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		desktopPane = new JDesktopPane();
		principalContent = new PrincipalContent();
		
		desktopPane.add(principalContent);
		this.getContentPane().add(desktopPane).setBounds(0, 0, WIDTH_RESOLUTION, HEIGHT_RESOLUTION);
	}
}
