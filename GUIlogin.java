import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.json.JSONException;
import org.json.JSONObject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JPasswordField;

public class GUILogin extends JPanel {
	
	private JTextField txtQ;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private Main client;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public GUILogin(Main client) {
		
		this.client = client;
		this.client.setCurrentUser(null);
		this.setLayout(null);
		
		txtQ = new JTextField();
		txtQ.setHorizontalAlignment(SwingConstants.CENTER);
		txtQ.setBounds(64, 87, 296, 20);
		this.add(txtQ);
		txtQ.setColumns(10);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(177, 62, 87, 14);
		this.add(lblUsername);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(177, 125, 61, 14);
		this.add(lblPassword);
		
		JButton btnLogIn = new JButton("Log in to the 90s");
		btnLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUILogin This = (GUILogin) (e.getComponent().getParent());
				
				JSONObject login = new JSONObject(); 
				
				try {
					login.put("Username", This.txtQ.getText());
					login.put("Password", new String(This.passwordField.getPassword()));
					login.put("Method", "Login");
					JSONObject success = This.client.MessageToServer(login);
					
					if (success != null && success.has("Result")) {	
						
						if (success.getBoolean("Result")) {
							This.client.setCurrentUser(success.getString("Username"));
							This.client.changePage(new GUIMenu(This.client));
						}
					}
					 	
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogIn.setBounds(148, 192, 136, 23);
		this.add(btnLogIn);
		
		JLabel lblSnakepit = new JLabel("Snakepit ");
		lblSnakepit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSnakepit.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblSnakepit.setBounds(64, 11, 296, 33);
		this.add(lblSnakepit);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(64, 150, 296, 20);
		add(passwordField);

	}
}
