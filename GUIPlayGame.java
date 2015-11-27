import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class GUIPlayGame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIPlayGame window = new GUIPlayGame();
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
	public GUIPlayGame() {
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
		
		JButton btnCreateNewGame = new JButton("Create Game");
		btnCreateNewGame.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		btnCreateNewGame.setBackground(new Color(135, 206, 235));
		btnCreateNewGame.setBounds(92, 82, 117, 53);
		frame.getContentPane().add(btnCreateNewGame);
		
		JButton button = new JButton("Join Game");
		button.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		button.setBackground(new Color(255, 215, 0));
		button.setBounds(227, 82, 117, 53);
		frame.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("Get Back");
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(178, 34, 34));
		btnNewButton.setBounds(255, 191, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblTheSnakepit = new JLabel("The Snakepit");
		lblTheSnakepit.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheSnakepit.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblTheSnakepit.setBounds(138, 35, 153, 36);
		frame.getContentPane().add(lblTheSnakepit);
	}

}
