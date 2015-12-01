import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUICreateGame extends JPanel {
	
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public GUICreateGame() {
		
		this.setBackground(new Color(255, 255, 240));
		this.setLayout(null);
		
		JLabel lblCreateGame = new JLabel("Create Game");
		lblCreateGame.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblCreateGame.setBounds(167, 41, 141, 30);
		this.add(lblCreateGame);
		
		JLabel lblToCreateGame = new JLabel("To create a new game please type a game name below");
		lblToCreateGame.setBounds(101, 82, 264, 14);
		this.add(lblToCreateGame);
		
		textField = new JTextField();
		textField.setBounds(101, 107, 264, 20);
		this.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Create Game");
		btnNewButton.setBackground(new Color(154, 205, 50));
		btnNewButton.setBounds(180, 138, 111, 45);
		this.add(btnNewButton);
		
		JButton btnGetBack = new JButton("Get Back");
		btnGetBack.setBackground(new Color(160, 82, 45));
		btnGetBack.setBounds(290, 227, 89, 23);
		this.add(btnGetBack);

	}

}
