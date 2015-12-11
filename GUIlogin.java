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

public class GUILogin extends JPanel { //GUILogin klassen nedarver JPanel
	//Instanitere lokalvariable
	private JTextField txtQ;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private Main client;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public GUILogin(Main client) { //GUILogin klassens konstruktør, ejes af Main klassen som bliver kaldt client
		
		this.client = client; //this.client sættes ind i client
		this.client.setCurrentUser(null);
		this.setLayout(null);
		
		txtQ = new JTextField(); //Her skrives brugernavnet ind 
		txtQ.setHorizontalAlignment(SwingConstants.CENTER);
		txtQ.setBounds(64, 87, 296, 20);
		this.add(txtQ);
		txtQ.setColumns(10);
		
		lblUsername = new JLabel("Username:"); //JLabel med indholdet Username, den placering, skriftype og størrelse
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(177, 62, 87, 14);
		this.add(lblUsername);
		
		lblPassword = new JLabel("Password:"); //JLabel med indholdet Password, den placering, skriftype og størrelse
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(177, 125, 61, 14);
		this.add(lblPassword);
		
		JButton btnLogIn = new JButton("Log in to the 90s"); //Login knappen 
		btnLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //Har tilføjet en event handler som er mouseclicked
				
				GUILogin This = (GUILogin) (e.getComponent().getParent()); //Component spørg hvad e er, som er vores mouseclicked, og getParent er hele siden den er på
				
				JSONObject login = new JSONObject();  //oprette et JSONObject variable som hedder login og modtager nyt JSONObject 
				
				try {
					login.put("Username", This.txtQ.getText()); //her skal der indsættes en værdi som er Username, som indeholder this.txtQ.getText
					login.put("Password", new String(This.passwordField.getPassword())); //Indsættes en værdi som er Password, som indeholder This.passwordField.getPassword
					login.put("Method", "Login"); //Spørg efter method, som her er Login
					
					JSONObject success = This.client.MessageToServer(login); //Her oprettes en ny JSONObject variable, som sætter login ind i den nye variable som hedder success 
					
					if (success != null && success.has("Result")) {	//Hvis login er rigtigt og login har et resultat
						
						if (success.getBoolean("Result")) { //Her undersøges om resultatet er sandt eller falsk
							This.client.setCurrentUser(success.getString("Username")); //Hvis resultatet er sandt, sættes CurrentUser på Username plads
							This.client.changePage(new GUIMenu(This.client)); //Og logger ind til menuen i spillet
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
		
		JLabel lblSnakepit = new JLabel("Snakepit "); //Overskriften på login siden, dens placering, skrifttype og størrelse
		lblSnakepit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSnakepit.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblSnakepit.setBounds(64, 11, 296, 33);
		this.add(lblSnakepit);
		
		passwordField = new JPasswordField(); //Her indskrives password for brugeren
		passwordField.setBounds(64, 150, 296, 20);
		add(passwordField);

	}
}
