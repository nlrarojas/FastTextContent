package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import controller.DefaultController;
import util.Utility;

public class PrincipalContent extends JPanel implements Utility, ActionListener, FocusListener, MouseListener{
	
	private JButton BtnSearch;
	private JTextField JtfSearch;
	private DefaultController controller;
	
	public PrincipalContent(){
		init();
	}
	
	private void init(){
		this.setLayout(null);
		this.setSize(WIDTH_RESOLUTION, HEIGHT_RESOLUTION);
		
		BtnSearch = new JButton("Buscar");
		BtnSearch.addActionListener(this);
		
		JtfSearch = new JTextField();
		JtfSearch.setText("Ingrese las palabras a buscar");
		JtfSearch.addFocusListener(this);
		JtfSearch.addMouseListener(this);
		
		controller = new DefaultController();
		
		this.addMouseListener(this);
		
		this.add(BtnSearch).setBounds(1200, 50, 100, 30);
		this.add(JtfSearch).setBounds(100, 50, 1000, 30);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == BtnSearch){
			if(!JtfSearch.getText().equals("Ingrese las palabras a buscar")){
				String wordList[] = JtfSearch.getText().split(" ");
				
			}
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
		if(e.getSource() == this){
			if(JtfSearch.getText().equals("")){			
				JtfSearch.setText("Ingrese las palabras a buscar");
			}			
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
