import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.List;

public class GUICreateGame extends JPanel {
	
	private JTextField textField;
	private Main client;

	/**
	 * Create the panel.
	 */
	public GUICreateGame(Main client) {
		
		this.client = client;
		this.setBackground(new Color(255, 255, 240));
		this.setLayout(null);
		
		JLabel lblCreateGame = new JLabel("Create Game");
		lblCreateGame.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblCreateGame.setBounds(46, 11, 141, 30);
		this.add(lblCreateGame);
		
		JLabel lblToCreateGame = new JLabel("<html>To create a new game<br/> please type a game name below</html>");
		lblToCreateGame.setBounds(46, 41, 147, 56);
		this.add(lblToCreateGame);
		
		textField = new JTextField();
		textField.setBounds(46, 99, 141, 20);
		this.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Create Game");
		btnNewButton.setBackground(new Color(154, 205, 50));
		btnNewButton.setBounds(56, 130, 111, 45);
		this.add(btnNewButton);
		
		JButton btnGetBack = new JButton("Get Back");
		btnGetBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGetBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				GUICreateGame This = (GUICreateGame) (e.getComponent().getParent());
				
				This.client.changePage(new GUIMenu(This.client));
			}
		});
		btnGetBack.setBackground(new Color(160, 82, 45));
		btnGetBack.setBounds(290, 266, 89, 23);
		this.add(btnGetBack);
		
		JLabel label = new JLabel("Join Game");
		label.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		label.setBounds(238, 11, 141, 30);
		add(label);
		
		JLabel label_1 = new JLabel("<html>Select a game<br/>you want to join </html>");
		label_1.setBounds(238, 41, 147, 56);
		add(label_1);
		
		JButton button = new JButton("Join Game");
		button.setBackground(new Color(189, 183, 107));
		button.setBounds(249, 210, 111, 45);
		add(button);
		
		List list = new List();
		list.setBounds(229, 99, 150, 105);
		add(list);

	}
}
