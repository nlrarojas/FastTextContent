package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import controller.DefaultController;
import model.SearchResultContent;
import util.Utility;

public class PrincipalContent extends JPanel implements Utility, ActionListener, FocusListener, MouseListener, KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton BtnSearch;
	private JTextField JtfSearch;
	private DefaultController Controller;
	private JScrollPane JscpHTMLContent;
	private JPanel JpHTMLContent;
	private List<SearchResultContent> resultList; 
	
	public PrincipalContent(){
		init();
	}
	
	private void init(){
		this.setLayout(null);
		this.setSize(WIDTH_RESOLUTION, HEIGHT_RESOLUTION);
		this.setBackground(Color.WHITE);
		
		BtnSearch = new JButton("Buscar");
		BtnSearch.addActionListener(this);
		BtnSearch.addKeyListener(this);
		
		JtfSearch = new JTextField();
		JtfSearch.setText("Ingrese las palabras a buscar");
		JtfSearch.addFocusListener(this);
		JtfSearch.addMouseListener(this);
		JtfSearch.addKeyListener(this);
		
		Controller = new DefaultController();
		
		JpHTMLContent = new JPanel();
		JpHTMLContent.setBackground(Color.BLACK);
		
		JscpHTMLContent = new JScrollPane();
		JscpHTMLContent.setBounds(50, 100, 1250, 620);
		JscpHTMLContent.setViewportView(JpHTMLContent);
		JscpHTMLContent.addMouseListener(this);
		
		JpHTMLContent.setLayout(new BoxLayout(JpHTMLContent, BoxLayout.Y_AXIS));
		JpHTMLContent.setPreferredSize(new Dimension(1250, 620));

		resultList = new ArrayList<>();
		
		this.addMouseListener(this);
		
		this.add(JscpHTMLContent);
		this.add(BtnSearch).setBounds(1200, 50, 100, 30);
		this.add(JtfSearch).setBounds(100, 50, 1000, 30);			
		repaint();
		revalidate();
		JscpHTMLContent.revalidate();
		JscpHTMLContent.repaint();
	}
	
	private void searchAction(){
		if(!JtfSearch.getText().equals("Ingrese las palabras a buscar") && !JtfSearch.getText().equals("")){
			JscpHTMLContent.removeAll();
			String wordList[] = JtfSearch.getText().split(" ");
			for (int i = 0; i < wordList.length; i++) {
				resultList.add(Controller.createSearchHistory(wordList[i], JpHTMLContent));
				JscpHTMLContent.setBorder(new LineBorder(Color.RED));
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == BtnSearch){
			searchAction();
		}		
	}

	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource() == JtfSearch){
			if(JtfSearch.getText().equals("Ingrese las palabras a buscar")){
				JtfSearch.setText("");
			}
		}		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(JtfSearch.getText().equals("")){			
			JtfSearch.setText("Ingrese las palabras a buscar");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == JtfSearch){
			if(JtfSearch.getText().equals("Ingrese las palabras a buscar")){
				JtfSearch.setText("");
			}
		}
		if(e.getSource() == this || e.getSource() == JscpHTMLContent){
			if(JtfSearch.getText().equals("")){			
				JtfSearch.setText("Ingrese las palabras a buscar");
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
}
