import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIHighscore extends JPanel {
	
	private Main client;

	/**
	 * Create the panel.
	 */
	public GUIHighscore(Main client) {
		
		this.client = client;
		this.setBackground(new Color(255, 255, 240));
		this.setLayout(null);
		
		JLabel lblHighscore = new JLabel("Highscore");
		lblHighscore.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblHighscore.setBounds(162, 24, 109, 22);
		this.add(lblHighscore);
		
		JLabel lblNewLabel = new JLabel("Name Highscore");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		lblNewLabel.setBounds(41, 53, 95, 14);
		this.add(lblNewLabel);
		
		JLabel lblGameHighscore = new JLabel("Game Highscore");
		lblGameHighscore.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		lblGameHighscore.setBounds(162, 53, 95, 14);
		this.add(lblGameHighscore);
		
		JLabel lblOverallHighscore = new JLabel("Overall Highscore");
		lblOverallHighscore.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		lblOverallHighscore.setBounds(286, 53, 102, 14);
		this.add(lblOverallHighscore);
		
		JList list = new JList();
		list.setBounds(41, 79, 95, 14);
		this.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(161, 79, 96, 113);
		this.add(list_1);
		
		JList list_2 = new JList();
		list_2.setBounds(286, 78, 102, 113);
		this.add(list_2);
		
		JButton btnGetBack = new JButton("Get Back");
		btnGetBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				GUIHighscore This = (GUIHighscore) (e.getComponent().getParent());
				
				This.client.changePage(new GUIMenu(This.client));
			}
		});
		btnGetBack.setBackground(new Color(238, 130, 238));
		btnGetBack.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		btnGetBack.setBounds(299, 227, 89, 23);
		this.add(btnGetBack);

	}

}
