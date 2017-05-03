package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;

import javax.swing.*;

import util.Utility;
import controller.DefaultController;
import model.SearchHistory;

public class PrincipalContent extends JPanel implements ActionListener, MouseListener, KeyListener, FocusListener, Utility{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDesktopPane desktopPane;
	private JButton BtnSearch;
	private JTextField JtxtSearch;
	private DefaultController Controller;
	private JPanel JpHTMLContent;
	private JScrollPane JScrollHTMLContent;
	
	public PrincipalContent(JDesktopPane desktopPane){
		this.desktopPane = desktopPane;
		initialize();
	}

	private void initialize() {
		this.setLayout(null);
		this.setBackground(Color.white);
		
		BtnSearch = new JButton("Buscar");
		BtnSearch.addActionListener(this);
		BtnSearch.addKeyListener(this);
		
		JtxtSearch = new JTextField();
		JtxtSearch.setText("Ingrese las palabras a buscar");
		JtxtSearch.addFocusListener(this);
		JtxtSearch.addMouseListener(this);
		JtxtSearch.addKeyListener(this);
		
		Controller = new DefaultController();
		
		JpHTMLContent = new JPanel();
		JpHTMLContent.setLayout(new BoxLayout(JpHTMLContent, BoxLayout.Y_AXIS));
		JpHTMLContent.setBackground(Color.WHITE);
		JpHTMLContent.addMouseListener(this);
		JScrollHTMLContent = new JScrollPane(JpHTMLContent);
		
		desktopPane.add(JScrollHTMLContent).setBounds(30, 200, 1285, 500);
		
		this.addMouseListener(this);
		
		this.add(JtxtSearch).setBounds(30, 50, 1100, 25);
		this.add(BtnSearch).setBounds(1160, 50, 100, 25);
	}
	
	private void searchAction(){
		if(!JtxtSearch.getText().equals("Ingrese las palabras a buscar") && !JtxtSearch.getText().equals("")){
			String wordList[] = JtxtSearch.getText().split(" ");
			for (int i = 0; i < wordList.length; i++) {
				Controller.SearchWords(wordList[i], JpHTMLContent);
			}	
				Enumeration<String> keysSaved = SearchHistory.getInstance().getSearchRecord().keys();
				while(keysSaved.hasMoreElements()){
					boolean find = false;
					String wordFind = keysSaved.nextElement().toString();
					for (int i = 0; i < wordList.length; i++) {
						if(wordFind.equals(wordList[i])){
							find = true;
							break;
						}
					}
					if(!find){
						SearchContent SearchContentToBeDeleted = SearchHistory.getInstance().getRecord(wordFind);
						JpHTMLContent.remove(SearchContentToBeDeleted);
						JpHTMLContent.revalidate();
					}
				}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		searchAction();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			searchAction();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
			
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == JtxtSearch){
			if(JtxtSearch.getText().equals("Ingrese las palabras a buscar")){
				JtxtSearch.setText("");
			}
		}
		if(e.getSource() == this || e.getSource() == JScrollHTMLContent){
			if(JtxtSearch.getText().equals("")){			
				JtxtSearch.setText("Ingrese las palabras a buscar");
			}			
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource() == JtxtSearch){
			if(JtxtSearch.getText().equals("Ingrese las palabras a buscar")){
				JtxtSearch.setText("");
			}
		}	
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(JtxtSearch.getText().equals("")){			
			JtxtSearch.setText("Ingrese las palabras a buscar");
		}
	}
}