import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends Calculator{

	private JFrame frame;
	final int mNY =12;
	int termYearV;
	final double percentage = 0.01;
	double interestRateLV, getHouseP, downPaymentLV, amortizationLV, getHouseUinMonth, getPropertyTaxIMonth, getHouseInMonth;
	double mortgage, morAmount, tPayment, tExpences, iRate, interestPayment, princpalPayment, downPaymentAmount, mortgageRemaing;
	
	Calculator cal = new Calculator();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		interestRateLV = cal.window.getMortgageRate;
		getHouseP = cal.window.getHousePrice;
		downPaymentLV = cal.window.downPaymentListValue;
		amortizationLV = cal.window.amortizationListValue;
		getHouseUinMonth = (cal.window.getHouseUtilities)/mNY;
		getPropertyTaxIMonth = (cal.window.getPropertyTax)/ mNY;
		getHouseInMonth = (cal.window.getHouseInsurance)/mNY;
		termYearV = (cal.window.termYearListValue * mNY);
		
		
		iRate = (interestRateLV * percentage) / mNY;
		morAmount = getHouseP - (getHouseP * downPaymentLV * percentage);
		mortgage = cal.window.primeRate * (morAmount * iRate / (1 - 1 / Math.pow(1+iRate, amortizationLV * mNY)));
		tPayment = morAmount - (mortgage * termYearV);
		
		 
		tExpences = (mortgage + getHouseUinMonth + getPropertyTaxIMonth + getHouseInMonth);
		
		interestPayment = iRate * tPayment;
		princpalPayment = mortgage - interestPayment;
		mortgageRemaing = morAmount - (princpalPayment * termYearV);
		
		
		

		frame = new JFrame("Output Message");
		frame.setBounds(100, 100, 450, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel titleMessage = new JLabel("According to your information ...");
		titleMessage.setForeground(Color.BLUE);
		titleMessage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		titleMessage.setBounds(45, 22, 231, 23);
		frame.getContentPane().add(titleMessage);
		
		JLabel monthlyMortgageLable = new JLabel("Monthly Mortgage: ");
		monthlyMortgageLable.setFont(new Font("Tahoma", Font.BOLD, 11));
		monthlyMortgageLable.setBounds(149, 74, 112, 14);
		frame.getContentPane().add(monthlyMortgageLable);
		
		JLabel totalNumberPaymentLable = new JLabel("Total Number of Payment in Terms: ");
		totalNumberPaymentLable.setFont(new Font("Tahoma", Font.BOLD, 11));
		totalNumberPaymentLable.setBounds(54, 99, 207, 14);
		frame.getContentPane().add(totalNumberPaymentLable);
		
		JLabel totalPrincipalPaymentLable = new JLabel("Total Principal Payment in Terms: ");
		totalPrincipalPaymentLable.setFont(new Font("Tahoma", Font.BOLD, 11));
		totalPrincipalPaymentLable.setBounds(64, 149, 207, 14);
		frame.getContentPane().add(totalPrincipalPaymentLable);
		
		JLabel totalMortgageRemainingLable = new JLabel("Total Mortgage Remaining after Term: ");
		totalMortgageRemainingLable.setFont(new Font("Tahoma", Font.BOLD, 11));
		totalMortgageRemainingLable.setBounds(39, 174, 222, 14);
		frame.getContentPane().add(totalMortgageRemainingLable);
		
		JLabel totalMontlyExpenceLable = new JLabel("Total Montly Expences:");
		totalMontlyExpenceLable.setForeground(Color.RED);
		totalMontlyExpenceLable.setFont(new Font("Tahoma", Font.BOLD, 13));
		totalMontlyExpenceLable.setBounds(106, 251, 155, 23);
		frame.getContentPane().add(totalMontlyExpenceLable);
		
		JLabel totalInterstPaymentsLable = new JLabel("Total Interest Payments in Terms");
		totalInterstPaymentsLable.setFont(new Font("Tahoma", Font.BOLD, 11));
		totalInterstPaymentsLable.setBounds(64, 124, 207, 14);
		frame.getContentPane().add(totalInterstPaymentsLable);
		
		JLabel cratorName = new JLabel("Created By iPretom");
		cratorName.setForeground(Color.BLUE);
		cratorName.setFont(new Font("Segoe Print", Font.BOLD, 11));
		cratorName.setBounds(305, 395, 119, 23);
		frame.getContentPane().add(cratorName);
		
		
		
		JLabel monthlyMortgageAmount = new JLabel("$"+Calculator.window.df.format(mortgage));
		monthlyMortgageAmount.setForeground(Color.MAGENTA);
		monthlyMortgageAmount.setFont(new Font("Tahoma", Font.BOLD, 11));
		monthlyMortgageAmount.setBounds(271, 74, 70, 14);
		frame.getContentPane().add(monthlyMortgageAmount);
		
		JLabel totalNumberPaymentAmount = new JLabel(Calculator.window.df.format(termYearV)+ " Months");
		totalNumberPaymentAmount.setForeground(Color.MAGENTA);
		totalNumberPaymentAmount.setFont(new Font("Tahoma", Font.BOLD, 11));
		totalNumberPaymentAmount.setBounds(271, 99, 70, 14);
		frame.getContentPane().add(totalNumberPaymentAmount);
		
		JLabel totalInterestPaymentAmount = new JLabel("$"+Calculator.window.df.format(interestPayment * termYearV));
		totalInterestPaymentAmount.setForeground(Color.MAGENTA);
		totalInterestPaymentAmount.setFont(new Font("Tahoma", Font.BOLD, 11));
		totalInterestPaymentAmount.setBounds(271, 124, 70, 14);
		frame.getContentPane().add(totalInterestPaymentAmount);
		
		JLabel totalPrincipalPaymentAmount = new JLabel("$"+Calculator.window.df.format(princpalPayment * termYearV));
		totalPrincipalPaymentAmount.setForeground(Color.MAGENTA);
		totalPrincipalPaymentAmount.setFont(new Font("Tahoma", Font.BOLD, 11));
		totalPrincipalPaymentAmount.setBounds(271, 149, 70, 14);
		frame.getContentPane().add(totalPrincipalPaymentAmount);
		
		JLabel totalMontlyExpencesAmount = new JLabel("$"+Calculator.window.df.format(tExpences));
		totalMontlyExpencesAmount.setForeground(Color.RED);
		totalMontlyExpencesAmount.setFont(new Font("Tahoma", Font.BOLD, 13));
		totalMontlyExpencesAmount.setBounds(271, 251, 70, 23);
		frame.getContentPane().add(totalMontlyExpencesAmount);

		
		JLabel totalMortgageRemaining = new JLabel("$"+Calculator.window.df.format(mortgageRemaing));
		totalMortgageRemaining.setForeground(Color.MAGENTA);
		totalMortgageRemaining.setFont(new Font("Tahoma", Font.BOLD, 11));
		totalMortgageRemaining.setBounds(271, 174, 70, 14);
		frame.getContentPane().add(totalMortgageRemaining);
		
		
		
		
		
		JButton returnButton = new JButton("Return");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 if (e.getSource() == returnButton)
				 {
					frame.dispose();
					 //win.frame.setVisible(false);
				 }
				
				
			}
		});
		returnButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		returnButton.setBounds(106, 333, 89, 23);
		frame.getContentPane().add(returnButton);
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancle.setBounds(252, 333, 89, 23);
		frame.getContentPane().add(btnCancle);
		
		
	}
}
