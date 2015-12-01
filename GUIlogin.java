import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUILogin extends JPanel {
	
	private JTextField txtQ;
	private JTextField textField_1;
	private JLabel lblUsername;
	private JLabel lblPassword;

	/**
	 * Create the panel.
	 */
	public GUILogin() {
		
		this.setLayout(null);
		
		txtQ = new JTextField();
		txtQ.setText("q");
		txtQ.setHorizontalAlignment(SwingConstants.CENTER);
		txtQ.setBounds(64, 87, 296, 20);
		this.add(txtQ);
		txtQ.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(64, 150, 296, 20);
		this.add(textField_1);
		textField_1.setColumns(10);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(177, 62, 87, 14);
		this.add(lblUsername);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(177, 125, 61, 14);
		this.add(lblPassword);
		
		JButton btnLogIn = new JButton("Log in to the 90s");
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogIn.setBounds(148, 192, 136, 23);
		this.add(btnLogIn);
		
		JLabel lblSnakepit = new JLabel("Snakepit ");
		lblSnakepit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSnakepit.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblSnakepit.setBounds(64, 11, 296, 33);
		this.add(lblSnakepit);

	}

}
