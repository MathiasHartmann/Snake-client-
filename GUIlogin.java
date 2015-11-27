import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class GUIlogin {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblUsername;
	private JLabel lblPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIlogin window = new GUIlogin();
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
	public GUIlogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(64, 87, 296, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(64, 150, 296, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(177, 62, 87, 14);
		frame.getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(177, 125, 61, 14);
		frame.getContentPane().add(lblPassword);
		
		JButton btnLogIn = new JButton("Log in to the 90s");
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogIn.setBounds(153, 192, 125, 23);
		frame.getContentPane().add(btnLogIn);
		
		JLabel lblSnakepit = new JLabel("Snakepit ");
		lblSnakepit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSnakepit.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblSnakepit.setBounds(64, 11, 296, 33);
		frame.getContentPane().add(lblSnakepit);
	}
}
