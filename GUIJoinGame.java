import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GUIJoinGame extends JPanel {
	
	private Main client;

	/**
	 * Create the panel.
	 */
	public GUIJoinGame(Main client) {
		
		this.client = client;
		this.setBackground(new Color(255, 255, 240));
		this.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Join Game");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(160, 27, 110, 28);
		this.add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(137, 79, 161, 156);
		this.add(list);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Select a game <br/> you want to join</html>");
		lblNewLabel_1.setBounds(10, 80, 110, 34);
		this.add(lblNewLabel_1);
		
		JButton btnGetBack = new JButton("Get Back");
		btnGetBack.setBackground(new Color(255, 140, 0));
		btnGetBack.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		btnGetBack.setBounds(335, 212, 89, 23);
		this.add(btnGetBack);

	}

}
