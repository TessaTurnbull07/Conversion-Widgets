//Thessalonica Turnbull
//Advanced Java Spring 2023
//Created March 29, 2023
//Temperature Converter Widget
//
//worked with Kyle Nguyen to complete this program
//
//allows user to convert temperatures between fahrenheit, celsius, and kelvin

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TTT_TemperatureConverter extends JPanel implements ActionListener{
	//global variables
	JComboBox<String> fromMenu;
	String[] fromList;
	JComboBox<String> toMenu;
	String[] toList;
	TextField fromText, answer;
	JButton convertButton, resetButton, exitButton;
	
	
	//cconstructor
	TTT_TemperatureConverter(){
		//for layout
		////GridLayout - used for all panels
		this.setLayout(new GridLayout(4,1));
		JPanel titlePanel = new JPanel();
		JPanel fromPanel = new JPanel();
		JPanel toPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		Font appFontLarge = new Font("Arial", Font.PLAIN, 50);
		Font appFontSmall = new Font("Arial", Font.PLAIN, 18);
		
		//title panel
		JLabel titleLabel = new JLabel("Temperature Converter");
		titleLabel.setFont(appFontLarge);;
		titlePanel.add(titleLabel);
		
		
		//from panel
		fromList = new String[] {"Fahrenheit", "Celsius", "Kelvin"};
		JLabel fromLabel = new JLabel("Original temperature: "); //creates label for from
		fromLabel.setFont(appFontSmall);
		fromText = new TextField(); //creates fromText textbox
		fromText.setPreferredSize(new Dimension(200,30));
		fromText.setFont(appFontSmall);
		fromText.setForeground(Color.BLACK);
		fromMenu = new JComboBox<String>(fromList); //creates fromMenu dropdown box
		fromMenu.setFont(appFontSmall);
		
		fromPanel.add(fromLabel);
		fromPanel.add(fromText);
		fromPanel.add(fromMenu);
		
		
		//to panel
		toList = new String[] {"Fahrenheit", "Celsius", "Kelvin"};
		JLabel toLabel = new JLabel("Converted temperature: "); //creates label for from
		toLabel.setFont(appFontSmall);
		answer = new TextField(); //creates fromText textbox
		answer.setPreferredSize(new Dimension(200,30));
		answer.setFont(appFontSmall);
		answer.setForeground(Color.BLACK);
		toMenu = new JComboBox<String>(fromList); //creates fromMenu dropdown box
		toMenu.setFont(appFontSmall);
		
		fromPanel.add(toLabel);
		fromPanel.add(answer);
		fromPanel.add(toMenu);
		
		
		//button panel
    	convertButton = new JButton("Convert");
    	resetButton = new JButton("Reset");
    	exitButton = new JButton("Exit");
    	
    	buttonPanel.add(convertButton); //adds each item below to buttonPanel
    	buttonPanel.add(resetButton);
    	buttonPanel.add(exitButton);
    	
    	
		//add JPanels to GridLayout
		this.add(titlePanel);
		this.add(fromPanel);
		this.add(toPanel);
		this.add(buttonPanel);
		
		
		//actionListener handles
		fromMenu.addActionListener(this);
		toMenu.addActionListener(this);
		convertButton.addActionListener(this);
		resetButton.addActionListener(this);
		exitButton.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fromMenu) {//clears textboxes if fromMenu selection changes
    		fromText.setText(null);
    		answer.setText(null);
    	}
    	if(e.getSource() == toMenu) {//clears textboxes if toMenu selection changes
    		fromText.setText(null);
    		answer.setText(null);
    	}
    	
		if(e.getSource() == exitButton) {//exits program
    		System.exit(0);
    	}
    	
    	if(e.getSource() == resetButton) {//resets all fields
    		fromMenu.setSelectedIndex(0);
    		toMenu.setSelectedIndex(0);
    		fromText.setText(null);
    		answer.setText(null);
    	} 
    	
    	if(e.getSource() == convertButton) {//does conversions based on user input/selection
            if (fromMenu.getSelectedIndex() < 0 || fromText.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Invalid Input", "Getting Error", JOptionPane.ERROR_MESSAGE);
            } else {
	        	double originalAmount = Double.parseDouble(fromText.getText());
	            double amountInF = 0.0;
	            switch (fromMenu.getSelectedItem().toString()) {
	                case "Fahrenheit":
	                	amountInF = originalAmount;
	                    break;
	                case "Celsius":
	                	amountInF = (originalAmount * (1.8)) + 32;
	                    break;
	                case "Kelvin":
	                	amountInF = (originalAmount - 273.15) * 1.8 + 32;
	                    break;
	                default:
	                	amountInF = 0.0;
	            }
	            double newamount = 0.0;
	            switch (toMenu.getSelectedItem().toString()) {
	                case "Fahrenheit":
	                    newamount = amountInF;
	                    break;
	                case "Celsius":
	                    newamount = (amountInF - 32) * (5.0/9);
	                    break;
	                case "Kelvin":
	                    newamount = (amountInF + 459.67) * (5.0/9);
	                    break;
	                default:
	                    newamount = amountInF = 0.0;
	            }
	            String amount = String.format("%.2f", newamount);
	            answer.setText(amount);
            }
    	}
	}
}