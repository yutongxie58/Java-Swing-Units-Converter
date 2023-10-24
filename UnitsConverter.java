import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

/**
 * This class creates a GUI application to convert units: 
 * Gallon to Liter; 
 * Liter to Gallon; 
 * Gallon to Fl oz; 
 * Fl oz to gallon.
 * 
 * @author Yutong Xie
 * @since 5/25/2022
 */
public class UnitsConverter {

	private JFrame frame;
	private JTextField textEntry;
	private JTextField textResult;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnitsConverter window = new UnitsConverter();
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
	public UnitsConverter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Yutong Xie Converter");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEntry = new JLabel("Entry");
		lblEntry.setBounds(96, 36, 61, 16);
		frame.getContentPane().add(lblEntry);
		
		textEntry = new JTextField();
		textEntry.setBounds(187, 31, 130, 26);
		frame.getContentPane().add(textEntry);
		textEntry.setColumns(10);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(96, 228, 61, 16);
		frame.getContentPane().add(lblResult);
		
		textResult = new JTextField();
		textResult.setBounds(187, 223, 130, 26);
		frame.getContentPane().add(textResult);
		textResult.setColumns(10);
		
		JRadioButton rdbtnGallon2Liter = new JRadioButton("Gallon to Liter");
		rdbtnGallon2Liter.setBounds(61, 83, 141, 23);
		frame.getContentPane().add(rdbtnGallon2Liter);
		
		JRadioButton rdbtnLiter2Gallon = new JRadioButton("Liter to Gallon");
		rdbtnLiter2Gallon.setBounds(253, 83, 141, 23);
		frame.getContentPane().add(rdbtnLiter2Gallon);
		
		JRadioButton rdbtnGallon2Floz = new JRadioButton("Gallon to Fl oz");
		rdbtnGallon2Floz.setBounds(61, 130, 141, 23);
		frame.getContentPane().add(rdbtnGallon2Floz);
		
		JRadioButton rdbtnFloz2Gallon = new JRadioButton("Fl oz to Gallon");
		rdbtnFloz2Gallon.setBounds(253, 130, 141, 23);
		frame.getContentPane().add(rdbtnFloz2Gallon);
		
		ButtonGroup G = new ButtonGroup();
		G.add(rdbtnGallon2Liter);
		G.add(rdbtnLiter2Gallon);
		G.add(rdbtnGallon2Floz);
		G.add(rdbtnFloz2Gallon);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strEntry = textEntry.getText();
				if(strEntry.equals("")) {
				}else {
					if(rdbtnGallon2Liter.isSelected()) {
						Double gallon = Double.parseDouble(strEntry);
						String liter = df.format(gallon * 3.8);
						textResult.setText(liter);
					}else if(rdbtnLiter2Gallon.isSelected()) {
						Double liter = Double.parseDouble(strEntry);
						String gallon = df.format(liter / 3.8);
						textResult.setText(gallon);
					}else if(rdbtnGallon2Floz.isSelected()) {
						Double gallon = Double.parseDouble(strEntry);
						String floz = df.format(gallon * 128);
						textResult.setText(floz);
					}else if(rdbtnFloz2Gallon.isSelected()) {
						Double floz = Double.parseDouble(strEntry);
						String gallon = df.format(floz / 128);
						textResult.setText(gallon);
					}
				}
			}
		});
		btnConvert.setBounds(61, 176, 117, 29);
		frame.getContentPane().add(btnConvert);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(263, 176, 117, 29);
		frame.getContentPane().add(btnExit);
	}
}
