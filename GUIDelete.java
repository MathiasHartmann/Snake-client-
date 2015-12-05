import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIDelete extends JPanel {
	
	private JTextField textField;
	private Main client;

	/**
	 * Create the panel.
	 */
	public GUIDelete(Main client) {
		
		this.client = client;
		this.setBackground(new Color(255, 255, 240));
		this.setLayout(null);
		
		JLabel lblDeleteGame = new JLabel("Delete Game");
		lblDeleteGame.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblDeleteGame.setBounds(150, 33, 137, 30);
		this.add(lblDeleteGame);
		
		textField = new JTextField();
		textField.setBounds(254, 74, 114, 20);
		this.add(textField);
		textField.setColumns(10);
		
		JLabel lblWhichGameDo = new JLabel("Which game do you want to delete:");
		lblWhichGameDo.setBounds(40, 77, 204, 14);
		this.add(lblWhichGameDo);
		
		JButton btnDeleteGame = new JButton("Delete Game");
		btnDeleteGame.setBackground(new Color(255, 255, 0));
		btnDeleteGame.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		btnDeleteGame.setBounds(163, 105, 118, 46);
		this.add(btnDeleteGame);
		
		JButton btnGetBack = new JButton("Get Back");
		btnGetBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				GUIDelete This = (GUIDelete) (e.getComponent().getParent());
				
				This.client.changePage(new GUIMenu(This.client));
			}
		});
		btnGetBack.setBackground(new Color(138, 43, 226));
		btnGetBack.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		btnGetBack.setBounds(267, 213, 89, 23);
		this.add(btnGetBack);

	}

}
