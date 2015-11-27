import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class GUIJoinGame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIJoinGame window = new GUIJoinGame();
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
	public GUIJoinGame() {
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
		
		JLabel lblNewLabel = new JLabel("Join Game");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(160, 27, 110, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(137, 79, 161, 156);
		frame.getContentPane().add(list);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Select a game <br/> you want to join</html>");
		lblNewLabel_1.setBounds(10, 80, 110, 34);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnGetBack = new JButton("Get Back");
		btnGetBack.setBackground(new Color(255, 140, 0));
		btnGetBack.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		btnGetBack.setBounds(335, 212, 89, 23);
		frame.getContentPane().add(btnGetBack);
	}
}
