import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GUIPlayGame extends JPanel {
	
	private Main client;

	/**
	 * Create the panel.
	 */
	public GUIPlayGame(Main client) {
		
		this.client = client;
		this.setBackground(new Color(255, 255, 240));
		this.setLayout(null);
		
		JButton btnCreateNewGame = new JButton("Create Game");
		btnCreateNewGame.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		btnCreateNewGame.setBackground(new Color(135, 206, 235));
		btnCreateNewGame.setBounds(92, 82, 117, 53);
		this.add(btnCreateNewGame);
		
		JButton button = new JButton("Join Game");
		button.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		button.setBackground(new Color(255, 215, 0));
		button.setBounds(227, 82, 117, 53);
		this.add(button);
		
		JButton btnNewButton = new JButton("Get Back");
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(178, 34, 34));
		btnNewButton.setBounds(255, 191, 89, 23);
		this.add(btnNewButton);
		
		JLabel lblTheSnakepit = new JLabel("The Snakepit");
		lblTheSnakepit.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheSnakepit.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblTheSnakepit.setBounds(138, 35, 153, 36);
		this.add(lblTheSnakepit);

	}

}
