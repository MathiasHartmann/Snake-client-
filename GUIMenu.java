import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIMenu extends JPanel {
	
	private Main client;

	/**
	 * Create the panel.
	 */
	public GUIMenu(Main client) {
		
		this.client = client;
		this.setBackground(new Color(255, 255, 240));
		this.setLayout(null);
		
		JLabel lblWelcomeNameTo = new JLabel("Welcome " + this.client.getCurrentUser() + " to The Snakepit");
		lblWelcomeNameTo.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		lblWelcomeNameTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeNameTo.setBounds(61, 11, 331, 27);
		this.add(lblWelcomeNameTo);
		
		JButton btnNewButton = new JButton("Play Game");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				GUIMenu This = (GUIMenu) (e.getComponent().getParent());
				
				This.client.changePage(new GUICreateGame(This.client));
			}
		});
		btnNewButton.setBackground(new Color(154, 205, 50));
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		btnNewButton.setBounds(160, 49, 128, 64);
		this.add(btnNewButton);
		
		JButton button = new JButton("<html>Show<br/> Highscore</html>");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				GUIMenu This = (GUIMenu) (e.getComponent().getParent());
				
				This.client.changePage(new GUIHighscore(This.client));
			}
		});
		button.setBackground(new Color(255, 165, 0));
		button.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		button.setBounds(160, 124, 128, 64);
		this.add(button);
		
		JButton button_2 = new JButton("<html>Back to <br /> The Future</html>");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				GUIMenu This = (GUIMenu) (e.getComponent().getParent());
				
				This.client.changePage(new GUILogin(This.client));
			}
		});
		button_2.setBackground(new Color(106, 90, 205));
		button_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		button_2.setBounds(160, 199, 128, 64);
		this.add(button_2);

	}

}
