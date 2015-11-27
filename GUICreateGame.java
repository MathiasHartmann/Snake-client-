import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUICreateGame {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUICreateGame window = new GUICreateGame();
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
	public GUICreateGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 240));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCreateGame = new JLabel("Create Game");
		lblCreateGame.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblCreateGame.setBounds(167, 41, 141, 30);
		frame.getContentPane().add(lblCreateGame);
		
		JLabel lblToCreateGame = new JLabel("To create a new game please type a game name below");
		lblToCreateGame.setBounds(101, 82, 264, 14);
		frame.getContentPane().add(lblToCreateGame);
		
		textField = new JTextField();
		textField.setBounds(101, 107, 264, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Create Game");
		btnNewButton.setBackground(new Color(154, 205, 50));
		btnNewButton.setBounds(180, 138, 111, 45);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnGetBack = new JButton("Get Back");
		btnGetBack.setBackground(new Color(160, 82, 45));
		btnGetBack.setBounds(290, 227, 89, 23);
		frame.getContentPane().add(btnGetBack);
	}

}
