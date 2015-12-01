import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GUIMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public GUIMenu() {
		
		this.setBackground(new Color(255, 255, 240));
		this.setLayout(null);
		
		JLabel lblWelcomeNameTo = new JLabel("Welcome Name to The Snakepit");
		lblWelcomeNameTo.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblWelcomeNameTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeNameTo.setBounds(66, 39, 331, 27);
		this.add(lblWelcomeNameTo);
		
		JButton btnNewButton = new JButton("Play Game");
		btnNewButton.setBackground(new Color(154, 205, 50));
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		btnNewButton.setBounds(90, 86, 128, 64);
		this.add(btnNewButton);
		
		JButton button = new JButton("<html>Show<br/> Highscore</html>");
		button.setBackground(new Color(255, 165, 0));
		button.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		button.setBounds(228, 86, 121, 64);
		this.add(button);
		
		JButton button_1 = new JButton("Delete Game");
		button_1.setBackground(new Color(220, 20, 60));
		button_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		button_1.setBounds(90, 157, 128, 64);
		this.add(button_1);
		
		JButton button_2 = new JButton("<html>Back to <br /> The Future</html>");
		button_2.setBackground(new Color(106, 90, 205));
		button_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		button_2.setBounds(228, 157, 121, 64);
		this.add(button_2);

	}

}
