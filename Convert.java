import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Convert {

	private JFrame frame;
	private JTextField textCelsius;
	private JTextField textFahrenheit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Convert window = new Convert();
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
	public Convert() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Celsius and Fahrenheit Conversion");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCelsius = new JLabel("Celsius: ");
		lblCelsius.setBounds(91, 38, 61, 16);
		frame.getContentPane().add(lblCelsius);
		
		JLabel lblFahrenheit = new JLabel("Fahrenheit: ");
		lblFahrenheit.setBounds(91, 83, 86, 16);
		frame.getContentPane().add(lblFahrenheit);
		
		textCelsius = new JTextField();
		textCelsius.setBounds(206, 33, 130, 26);
		frame.getContentPane().add(textCelsius);
		textCelsius.setColumns(10);
		
		textFahrenheit = new JTextField();
		textFahrenheit.setBounds(206, 78, 130, 26);
		frame.getContentPane().add(textFahrenheit);
		textFahrenheit.setColumns(10);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strCelsius = textCelsius.getText();
				String strFahrenheit = textFahrenheit.getText();
				if(!strCelsius.equals("")) {
					Integer tempCelsius = Integer.parseInt(strCelsius);
					Integer tempFahrenheit = tempCelsius * 9 / 5 + 32;
					textFahrenheit.setText(Integer.toString(tempFahrenheit));
				}else if(!strFahrenheit.equals("")) {
					Integer tempFahrenheit = Integer.parseInt(strFahrenheit);
					Integer tempCelsius = (tempFahrenheit - 32) * 5 / 9;
					textCelsius.setText(Integer.toString(tempCelsius));
				}
			}
		});
		btnConvert.setBounds(164, 163, 117, 29);
		frame.getContentPane().add(btnConvert);
	}
}
