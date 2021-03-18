import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.JTextComponent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;



public class Calculator extends JFrame implements ActionListener{

	private JFrame frame;
	private JLabel morCalTitle;
	private JLabel txtHousePrice;
	private JLabel txtDownPayment;
	private JLabel txtInterestRate;
	private JLabel txtAmortization;
	private JTextField housePrice;
	private JList amortizationList;
	//private JList interestRateList;
	private JLabel txtPropertyTax;
	private JLabel txtHouseUtilities;
	private JLabel txtHouseInsurance;
	private JTextField propertyTax, interestRateField;
	private JTextField houseUtilities;
	private JTextField houseInsurance;
	private JButton calculateButton;
	private JScrollPane amortizationScroll, downPaymentScroll, termYearListScroll; //interstRateScroll
	private JList downPaymentList, termYearList;
	private JRadioButton fixedRateButton, ariableRateButton;
	private ButtonGroup groupRadio;
	double getPropertyTax, getHouseUtilities, getHouseInsurance, getMortgageRate;
	private JLabel validationHousePrice;
	private JLabel validationinterestRateField;
	private JLabel validitionPropertyTax;
	private JLabel validationHouseUtility;
	private JLabel validationHouseInsurance;
	private JLabel validationCalculator;
	double interestRateListValue, primeRate;
	static int downPaymentListValue, amortizationListValue, getHousePrice, termYearListValue;
	private JLabel lblNewLabel;
	//double mortgage, tMortgage, tPayment, tExpences, iRate, interestPayment, princpalPayment, downPaymentAmount, mortgageRemaing;
	double getHP, downPaymentAmount;
	//int nPayment;
	private JLabel txtTerm;
	static Calculator window;
	private JLabel mortgageTypeTxt;
	private JLabel downPaymentAm;
	DecimalFormat df;
	String letter;
	
	
	
	
	public static void main(String[] args) {
		
		//Calculator s1 = new Calculator();
		//s1.setVisible(true);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Mortgage Calculator");
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		//Message Titles
		morCalTitle = new JLabel();
		morCalTitle.setForeground(Color.RED);
		morCalTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		morCalTitle.setText("Please put all the information.....");
		morCalTitle.setBounds(53, 33, 197, 20);
		frame.getContentPane().add(morCalTitle);
		
		//House Price Text
		txtHousePrice = new JLabel();
		txtHousePrice.setText("House Asking Price");
		txtHousePrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHousePrice.setBounds(53, 80, 111, 20);
		frame.getContentPane().add(txtHousePrice);
		
		//DownPayment Text
		txtDownPayment = new JLabel();
		txtDownPayment.setText("Down Payment (%)");
		txtDownPayment.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtDownPayment.setBounds(53, 124, 111, 20);
		frame.getContentPane().add(txtDownPayment);
		
		//Amortization Text
		txtAmortization = new JLabel();
		txtAmortization.setText("Amortization Period");
		txtAmortization.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAmortization.setBounds(53, 181, 124, 20);
		frame.getContentPane().add(txtAmortization);
		
		//Interest Rate Text
		txtInterestRate = new JLabel();
		txtInterestRate.setText("Mortgage Rate (%)");
		txtInterestRate.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtInterestRate.setBounds(53, 236, 124, 20);
		frame.getContentPane().add(txtInterestRate);
		
		
		
		//Property Tax Text
		txtPropertyTax = new JLabel();
		txtPropertyTax.setText("Property Tax");
		txtPropertyTax.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtPropertyTax.setBounds(53, 404, 82, 20);
		frame.getContentPane().add(txtPropertyTax);
		
		//House Utilities Text
		txtHouseUtilities = new JLabel();
		txtHouseUtilities.setText("House Utilities");
		txtHouseUtilities.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHouseUtilities.setBounds(53, 441, 90, 20);
		frame.getContentPane().add(txtHouseUtilities);
		
		//House Insurance Text
		txtHouseInsurance = new JLabel();
		txtHouseInsurance.setText("House Insurance");
		txtHouseInsurance.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHouseInsurance.setBounds(53, 476, 99, 20);
		frame.getContentPane().add(txtHouseInsurance);
		
		//Term
		txtTerm = new JLabel();
		txtTerm.setText("Mortgage Term");
		txtTerm.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtTerm.setBounds(53, 295, 99, 20);
		frame.getContentPane().add(txtTerm);
		
		
		mortgageTypeTxt = new JLabel();
		mortgageTypeTxt.setText("Mortgage Type");
		mortgageTypeTxt.setFont(new Font("Tahoma", Font.BOLD, 11));
		mortgageTypeTxt.setBounds(53, 351, 99, 20);
		frame.getContentPane().add(mortgageTypeTxt);
		
		
		
		
		//Input Fields
		housePrice = new JTextField();
		housePrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if (Character.isLetter(c))
				{
					housePrice.setEditable(false);
					validationHousePrice.setText("<Enter Numbers only>");
				}
				else
				{
					housePrice.setEditable(true);
				}
			}
		});
		housePrice.setHorizontalAlignment(SwingConstants.RIGHT);
		housePrice.setBounds(189, 80, 109, 20);
		frame.getContentPane().add(housePrice);
		housePrice.setColumns(10);
		
		propertyTax = new JTextField();
		propertyTax.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if (Character.isLetter(c))
				{
					propertyTax.setEditable(false);
					validitionPropertyTax.setText("<Enter Numbers only>");
				}
				else
				{
					propertyTax.setEditable(true);
				}
			}
		});
		propertyTax.setHorizontalAlignment(SwingConstants.RIGHT);
		propertyTax.setColumns(10);
		propertyTax.setBounds(189, 404, 109, 20);
		frame.getContentPane().add(propertyTax);
		
		houseUtilities = new JTextField();
		houseUtilities.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if (Character.isLetter(c))
				{
					houseUtilities.setEditable(false);
					validationHouseUtility.setText("<Enter Numbers only>");
				}
				else
				{
					houseUtilities.setEditable(true);
				}
				
			}
		});
		houseUtilities.setHorizontalAlignment(SwingConstants.RIGHT);
		houseUtilities.setColumns(10);
		houseUtilities.setBounds(189, 441, 109, 20);
		frame.getContentPane().add(houseUtilities);
		
		houseInsurance = new JTextField();
		houseInsurance.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				char c = e.getKeyChar();
			
				if (Character.isLetter(c))
				{
					houseInsurance.setEditable(false);
					validationHouseInsurance.setText("<Enter Numbers only>");
				}
				else
				{
					houseInsurance.setEditable(true);
				}
			}
		});
		houseInsurance.setHorizontalAlignment(SwingConstants.RIGHT);
		houseInsurance.setColumns(10);
		houseInsurance.setBounds(189, 476, 109, 20);
		frame.getContentPane().add(houseInsurance);
		
		
		//Radio Button
		fixedRateButton = new JRadioButton("Fixed Terms");
		fixedRateButton.setBounds(189, 336, 109, 23);
		frame.getContentPane().add(fixedRateButton);
		
		ariableRateButton = new JRadioButton("Variable Rate");
		ariableRateButton.setBounds(189, 362, 109, 23);
		frame.getContentPane().add(ariableRateButton);
		
		groupRadio = new ButtonGroup();
		groupRadio.add(ariableRateButton);
		groupRadio.add(fixedRateButton);
		
		ariableRateButton.addActionListener(this);
		fixedRateButton.addActionListener(this);
		
	
		//ScrollBar
		String [] downperCent = {"5", "10", "15", "20", "25", "30", "40"};
		downPaymentList = new JList(downperCent);
		
		downPaymentList.addListSelectionListener(new ListSelectionListener() 
				{
					public void valueChanged(ListSelectionEvent e)
					{
						downPaymentListValue = Integer.parseInt(downPaymentList.getSelectedValue().toString());
						getHP = Integer.parseInt(housePrice.getText());
						downPaymentAmount = (double)((downPaymentListValue * getHP)/100);
						downPaymentAm.setText("$ " + String.valueOf(downPaymentAmount));
					}
				}
				);
		
		downPaymentList.setBounds(189, 115, 109, 43);
		frame.getContentPane().add(downPaymentList);
		
		downPaymentScroll = new JScrollPane(downPaymentList);
		downPaymentScroll.setSize(109, 43);
		downPaymentScroll.setLocation(189, 115);
		frame.getContentPane().add(downPaymentScroll, BorderLayout.CENTER);
		downPaymentList.setVisibleRowCount(2);
		
		
		
		String [] years = {"15 ", "18", "20", "22", "25", "27", "28", "30"};
		amortizationList = new JList(years);
		
		amortizationList.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e)
			{
				amortizationListValue = Integer.parseInt(amortizationList.getSelectedValue().toString());
			}
		}
		);
		
		amortizationList.setBounds(189, 169, 109, 43);
		frame.getContentPane().add(amortizationList);
		
		amortizationScroll = new JScrollPane(amortizationList);
		amortizationScroll.setSize(109, 43);
		amortizationScroll.setLocation(189, 169);
		frame.getContentPane().add(amortizationScroll, BorderLayout.CENTER);
		amortizationList.setVisibleRowCount(2);
		
		
		
		
		
		//String [] interstRate = {"1", "1.5", "1.8", "2.0", "2.1", "2.2", "2.3", "2.5"};
		//interestRateList = new JList(interstRate);
		
		//interestRateList.addListSelectionListener(new ListSelectionListener() 
		//{
			//public void valueChanged(ListSelectionEvent e)
		//	{
					
		//			interestRateListValue = Double.parseDouble(interestRateList.getSelectedValue().toString());
			
		//	}
		//}
		//);
		
	//	interestRateList.setBounds(189, 224, 109, 43);
		//frame.getContentPane().add(interestRateList);
		
	//	interstRateScroll = new JScrollPane(interestRateList);
	//	interstRateScroll.setSize(109, 43);
	//	interstRateScroll.setLocation(189, 224);
	//	frame.getContentPane().add(interstRateScroll, BorderLayout.CENTER);
	//	interestRateList.setVisibleRowCount(2);
		
		interestRateField = new JTextField();
		interestRateField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if (Character.isLetter(c))
				{
					interestRateField.setEditable(false);
					validationinterestRateField.setText("<Enter Numbers only>");
				}
				else
				{
					interestRateField.setEditable(true);
				}
				
			}
		});
		interestRateField.setHorizontalAlignment(SwingConstants.RIGHT);
		interestRateField.setColumns(10);
		interestRateField.setBounds(187, 236, 109, 20);
		frame.getContentPane().add(interestRateField);
		
		
		String [] termYear = {"1", "2", "3", "4", "5", "7", "10"};
		termYearList = new JList(termYear);
		
		termYearList.addListSelectionListener(new ListSelectionListener() 
				{
					public void valueChanged(ListSelectionEvent e)
					{
						termYearListValue = Integer.parseInt(termYearList.getSelectedValue().toString());
					}
				}
				);
		
		termYearList.setBounds(189, 280, 109, 43);
		frame.getContentPane().add(termYearList);
		
		termYearListScroll = new JScrollPane(termYearList);
		termYearListScroll.setSize(109, 43);
		termYearListScroll.setLocation(189, 280);
		frame.getContentPane().add(termYearListScroll, BorderLayout.CENTER);
		termYearList.setVisibleRowCount(2);
		
		
		
		
		//Validation 
		validationHousePrice = new JLabel("");
		validationHousePrice.setFont(new Font("Tahoma", Font.BOLD, 9));
		validationHousePrice.setForeground(Color.RED);
		validationHousePrice.setBounds(308, 83, 116, 17);
		frame.getContentPane().add(validationHousePrice);
		
		validitionPropertyTax = new JLabel("");
		validitionPropertyTax.setFont(new Font("Tahoma", Font.BOLD, 9));
		validitionPropertyTax.setForeground(Color.RED);
		validitionPropertyTax.setBounds(308, 404, 116, 17);
		frame.getContentPane().add(validitionPropertyTax);
		
		validationHouseUtility = new JLabel("");
		validationHouseUtility.setFont(new Font("Tahoma", Font.BOLD, 9));
		validationHouseUtility.setForeground(Color.RED);
		validationHouseUtility.setBounds(308, 441, 116, 20);
		frame.getContentPane().add(validationHouseUtility);
		
		validationHouseInsurance = new JLabel("");
		validationHouseInsurance.setFont(new Font("Tahoma", Font.BOLD, 9));
		validationHouseInsurance.setForeground(Color.RED);
		validationHouseInsurance.setBounds(308, 476, 116, 17);
		frame.getContentPane().add(validationHouseInsurance);
		
		validationCalculator = new JLabel("");
		validationCalculator.setForeground(Color.RED);
		validationCalculator.setFont(new Font("Tahoma", Font.BOLD, 12));
		validationCalculator.setBounds(84, 554, 249, 14);
		frame.getContentPane().add(validationCalculator);
		
		validationinterestRateField = new JLabel("");
		validationinterestRateField.setFont(new Font("Tahoma", Font.BOLD, 9));
		validationinterestRateField.setForeground(Color.RED);
		validationinterestRateField.setBounds(308, 236, 116, 20);
		frame.getContentPane().add(validationinterestRateField);
		
		lblNewLabel = new JLabel("Created By iPretom");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD, 11));
		lblNewLabel.setBounds(308, 579, 116, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		//Action Button
		
		calculateButton = new JButton("Calculate Now");
		calculateButton.setBackground(Color.GREEN);
		calculateButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		calculateButton.setBounds(147, 535, 124, 33);
		frame.getContentPane().add(calculateButton);
		
		//Downpayment Amount
		downPaymentAm = new JLabel("");
		downPaymentAm.setForeground(Color.BLUE);
		downPaymentAm.setFont(new Font("Tahoma", Font.BOLD, 12));
		downPaymentAm.setBounds(325, 130, 82, 14);
		frame.getContentPane().add(downPaymentAm);
		
		
		
		calculateButton.addActionListener(this);
		
	
		
	}
	
	
	

	public void actionPerformed(ActionEvent e){    
		if(fixedRateButton.isSelected()){    
			//JOptionPane.showMessageDialog(this,"Fixed Term Selected");  
			letter = "Fixed Terms";
			primeRate = 1;
		}    
		if(ariableRateButton.isSelected()){    
			//JOptionPane.showMessageDialog(this,"Variable Rate Selected");    
			primeRate = 1.05;
			letter = "Variable Rate";
		}  
		
		
		
			if (e.getSource() == calculateButton)
			{
				
				if (housePrice.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(frame, "Please enter House Price", "Error Message", JOptionPane.ERROR_MESSAGE);
				}

				else if (downPaymentList.isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(frame, "Select Down Payment Option", "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				
				else if (amortizationList.isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(frame, "Select Amotization Period Option", "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				
				else if (interestRateField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(frame, "Please enter Mortgage Rate", "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				
				else if (termYearList.isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(frame, "Select Mortgage Term Option", "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				
				else if (groupRadio.isSelected(null))
				{
					JOptionPane.showMessageDialog(frame, "Select One of Mortgage Type", "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				
				else if (propertyTax.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(frame, "Please enter Property Tax", "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				
				else if (houseUtilities.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(frame, "Please enter House Utilities", "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				
				else if (houseInsurance.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(frame, "Please enter House Insurance", "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				
				else
				{
				getHousePrice = Integer.parseInt(housePrice.getText());
				getPropertyTax = Double.parseDouble(propertyTax.getText());
				getHouseUtilities = Double.parseDouble(houseUtilities.getText());
				getHouseInsurance = Double.parseDouble(houseInsurance.getText());
				getMortgageRate = Double.parseDouble(interestRateField.getText());
				
				
				
				//iRate = ((double) interestRateListValue / (double)(100 * 12));
				//mortgage = (double) (getHousePrice - (double)((getHousePrice * downPaymentListValue)/100));
			//	tMortgage = (double)(primeRate * (mortgage * iRate / (double) (1 - 1 / Math.pow(1+iRate, (double) amortizationListValue * (double) mc.mY))));
			//	tPayment = (double) (mortgage - (tMortgage *((double)termYearListValue * (double)mc.mY)));
				
				 
			//	tExpences = (double)(tMortgage + ((getPropertyTax/ (double)mc.mY) + (getHouseUtilities/(double) mc.mY) + (getHouseInsurance/(double)mc.mY) ));
			//	nPayment = termYearListValue * mc.mY;
			//	interestPayment = iRate * tPayment;
			//	princpalPayment = tMortgage - interestPayment;
			//	mortgageRemaing = mortgage - (princpalPayment * nPayment);
				
				
				df = new DecimalFormat("#,###,###,###.##");
				 
				 int returnValue = JOptionPane.showConfirmDialog(
						    frame,
						    "House Asking Price:  $" + df.format(getHousePrice)
	                         + "\nDownPayment:  " + downPaymentListValue + "%"
	                         + "\nAmortization Period:  " + amortizationListValue + " Years"
	                         + "\nMortgage Rate:  " + getMortgageRate +"%"
	                         
	                         + " \nMortgage Term/Type:  " + termYearListValue + " Years " + "("+ letter + ")"
	                         + "\nProperty Tax:  $" + df.format(getPropertyTax)
	                         + "\nHouse Utilities:  $" + df.format(getHouseUtilities)
	                         + "\nHouse Insurance:  $" + df.format(getHouseInsurance),
						    "Your Input Information",
						    JOptionPane.YES_NO_CANCEL_OPTION);
				 
				
				 if (returnValue == 0)
				 {
					 
					 GUI myWindow = new GUI();
					 
				/*JOptionPane.showMessageDialog(null, "Montly Mortgage:  $" + df.format(tMortgage)
                         + "\nTotal Numbers of Payment in Terms:  " + df.format(nPayment) + " Months"
                         + "\nTotal Interest Payments in Terms:  $" + df.format(interestPayment * nPayment)
                         + "\nTotal Principal Paymentsin Terms:  $" + df.format(princpalPayment * nPayment)
                         + "\nTotal Mortgage remaining after Term:  $" + df.format(tPayment)
                         + "\n"
                         + "\nTotal Monthly Expences:  $" + df.format(tExpences));
				*/
				 }
				 else if (returnValue == 1)
				 {
					 JOptionPane.showMessageDialog(null, "Better Luck Next Time"
					 		+ "\n See you again...");
				 }
				 
				 else if (returnValue == 2)
				 {
					 window.frame.setVisible(false);
				 }
			//	JOptionPane.showMessageDialog(frame, "Please Enter everything correctly...", "Error Message", JOptionPane.ERROR_MESSAGE);
				//JOptionPane.showMessageDialog(null, "Test Test " + getHousePrice + downPay);
			}
			
			}
			//else
			//{
			//	JOptionPane.showMessageDialog(frame, "Please Enter everything correctly...", "Error Message", JOptionPane.ERROR_MESSAGE);
			//}
	}
		
		
	
	

	}
