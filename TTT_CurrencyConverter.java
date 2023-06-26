//Thessalonica Turnbull
//Advanced Java Spring 2023
//Created March 29, 2023
//Currency Converter Widget
//
//worked with Kyle Nguyen to complete this program
//
//User selects country currency they would like to convert from and to
//uses exchange rates based off of March 30, 3032 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TTT_CurrencyConverter extends JPanel implements ActionListener{
	//global variables
	JComboBox<String> fromMenu;
	String[] fromList;
	JLabel fromUnit;
	JComboBox<String> toMenu;
	String[] toList;
	JLabel toUnit;
	TextField fromText, answer;
    String[] currencyUnits= {
    		"US Dollar",
    	    "Mexican Peso",
    	    "Brazillian Real",
    	    "Jamaican Dollar",
    	    "Chinese Yuan",
    	    "Japanese Yen",
    	    "English Pound",
    	    "Irish Euro",
    	    "Egyptian Pound", 
    	    "Moroccan Dirham"};
    JButton convertButton, resetButton, exitButton;
    double US_Dollar = 1.0;
    double Mexico_Peso = 18.1;
    double Brazil_Real = 5.09;
    double Jamaica_Dollar = 150.87;
    double China_Yuan = 6.87;
    double Japan_Yen = 132.71;
    double England_Pound = 0.81;
    double Ireland_Euro = 0.92;
    double Egypt_Pound = 30.90;
    double Morocco_Dirham = 10.21;
    
    //constructor
    TTT_CurrencyConverter(){
    	//for layout
    	////BorderLayout - has two areas-titlePanel and centerPanel
    	////GridLayout - create centerPanel (combines fromPanel, toPanel, and buttonPanel
    	////FlowLayout does single rows (so JUST fromPanel and JUST toPanel)
    	this.setLayout(new BorderLayout());;   	
    	JPanel titlePanel = new JPanel();
    	JPanel fromPanel = new JPanel();
    	JPanel toPanel = new JPanel();
    	JPanel buttonPanel = new JPanel();
    	JPanel centerPanel = new JPanel();
    	centerPanel.setLayout(new GridLayout(3,1)); //three rows, one column
    	
    	Font appFontLarge = new Font("Arial", Font.PLAIN, 50);
    	Font appFontSmall = new Font("Arial", Font.PLAIN, 18);
    	
    	
    	//title panel
    	JLabel titleLabel = new JLabel("Currency Converter");
    	titleLabel.setFont(appFontLarge);;
    	titlePanel.add(titleLabel);
    	
    	
    	//from panel
    	fromList = new String [] 
    			{"US", "Mexico", "Brazil", "Jamaica", "China", "Japan", "England", "Ireland", "Egypt", "Moroco"};
    	JLabel fromLabel = new JLabel("From country: "); //sets up title of panel
    	fromLabel.setFont(appFontSmall);
    	fromMenu = new JComboBox<String>(fromList); //creates menu of countries
    	fromMenu.setFont(appFontSmall);
    	fromText = new TextField();//adds textbox for user input
    	fromText.setPreferredSize(new Dimension(200, 30));
    	fromText.setFont(appFontSmall);
    	fromText.setForeground(Color.BLACK);
    	fromUnit = new JLabel(currencyUnits[0]); //adds unit from each country
    	fromUnit.setFont(appFontSmall);
    	
    	fromPanel.setLayout(new FlowLayout(FlowLayout.CENTER));//adds each item below to fromPanel
    	fromPanel.add(fromLabel);
    	fromPanel.add(fromMenu);
    	fromPanel.add(fromText);
    	fromPanel.add(fromUnit);
    	
    	
    	//to panel
    	toList = new String [] 
    			{"US", "Mexico", "Brazil", "Jamaica", "China", "Japan", "England", "Ireland", "Egypt", "Moroco"};
    	JLabel toLabel = new JLabel("To country: "); //sets up title of panel
    	toLabel.setFont(appFontSmall);
    	toMenu = new JComboBox<String>(fromList); //creates menu of countries
    	toMenu.setFont(appFontSmall);
    	answer = new TextField();//adds textbox for user input
    	answer.setPreferredSize(new Dimension(200, 30));
    	answer.setFont(appFontSmall);
    	answer.setForeground(Color.BLACK);
    	toUnit = new JLabel(currencyUnits[0]); //adds unit from each country
    	toUnit.setFont(appFontSmall);
    	
    	toPanel.setLayout(new FlowLayout(FlowLayout.CENTER));//adds each item below to toPanel
    	toPanel.add(toLabel);
    	toPanel.add(toMenu);
    	toPanel.add(answer);
    	toPanel.add(toUnit);
    	
    	
    	//buttons panel
    	convertButton = new JButton("Convert");
    	resetButton = new JButton("Reset");
    	exitButton = new JButton("Exit");
    	
    	buttonPanel.add(convertButton); //adds each item below to buttonPanel
    	buttonPanel.add(resetButton);
    	buttonPanel.add(exitButton);
    	
    	
    	//add JPanels to FlowLayout's center
    	centerPanel.add(fromPanel);
    	centerPanel.add(toPanel);
    	centerPanel.add(buttonPanel);
    	
    	//add JPanels from FlowLayout into the BorderLayout
    	this.add(titlePanel, BorderLayout.NORTH);
    	this.add(centerPanel, BorderLayout.CENTER);
    	
    	
    	//ActionListener handlers
    	fromMenu.addActionListener(this);
    	toMenu.addActionListener(this);
    	convertButton.addActionListener(this);
    	resetButton.addActionListener(this);
    	exitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == fromMenu) {//changes unit of from
    		int selectedIndex = fromMenu.getSelectedIndex();
    		fromUnit.setText(currencyUnits[selectedIndex]);
    		fromText.setText(null);
    		answer.setText(null);
    	}
    	if(e.getSource() == toMenu) {//changes unit of to
    		int selectedIndex = toMenu.getSelectedIndex();
    		toUnit.setText(currencyUnits[selectedIndex]);
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
                double amountInUSD = 0.0;
                switch (fromMenu.getSelectedItem().toString()) {
                    case "US":
                    	amountInUSD = originalAmount / US_Dollar;
                        break;
                    case "Mexico":
                    	amountInUSD = originalAmount / Mexico_Peso;
                        break;
                    case "Brazil":
                    	amountInUSD = originalAmount / Brazil_Real;
                        break;
                    case "Jamaica":
                    	amountInUSD = originalAmount / Jamaica_Dollar;
                        break;
                    case "China":
                    	amountInUSD = originalAmount / China_Yuan;
                        break;
                    case "Japan":
                    	amountInUSD = originalAmount / Japan_Yen;
                        break;
                    case "England":
                    	amountInUSD = originalAmount / England_Pound;
                        break;
                    case "Ireland":
                    	amountInUSD = originalAmount / Ireland_Euro;
                        break;
                    case "Egypt":
                    	amountInUSD = originalAmount / Egypt_Pound;
                        break;
                    case "Morocco":
                    	amountInUSD = originalAmount / Morocco_Dirham;
                    	break;
                    default:
                    	amountInUSD = 0.0;
                }

                double newamount = 0.0;
                switch (toMenu.getSelectedItem().toString()) {
                    case "US":
                        newamount = amountInUSD * US_Dollar;
                        break;
                    case "Mexico":
                        newamount = amountInUSD * Mexico_Peso;
                        break;
                    case "Brazil":
                        newamount = amountInUSD * Brazil_Real;
                        break;
                    case "Jamaica":
                        newamount = amountInUSD * Jamaica_Dollar;
                        break;
                    case "China":
                        newamount = amountInUSD * China_Yuan;
                        break;
                    case "Japan":
                        newamount = amountInUSD * Japan_Yen;
                        break;
                    case "England":
                        newamount = amountInUSD * England_Pound;
                        break;
                    case "Ireland":
                        newamount = amountInUSD * Ireland_Euro;
                        break;
                    case "Egypt":
                        newamount = amountInUSD * Egypt_Pound;
                        break;
                    case "Morocco":
                    	newamount = amountInUSD * Morocco_Dirham;
                    	break;
                    default:
                        newamount = amountInUSD = 0.0;
                }
                String amount = String.format("%.2f", newamount);
                answer.setText(amount);
            }
        }
    }
    
}