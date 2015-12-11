import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIMenu extends JPanel { //GUIMenu klassen nedarver JPanel
	
	private Main client; //Instanitere lokalvariable

	/**
	 * Create the panel.
	 */
	public GUIMenu(Main client) { //Klassens konstruktør
		
		this.client = client; //this.client sættes ind i client
		this.setBackground(new Color(255, 255, 240));
		this.setLayout(null);
		
		JLabel lblWelcomeNameTo = new JLabel("Welcome " + this.client.getCurrentUser() + " to The Snakepit"); //Overskriften på menu siden, som er en hardkodet tekst samt CurrentUsers brugernavn
		lblWelcomeNameTo.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		lblWelcomeNameTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeNameTo.setBounds(61, 11, 331, 27);
		this.add(lblWelcomeNameTo);
		
		JButton btnNewButton = new JButton("Play Game"); //Play Game knappen som er en JButton
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //Tilføjer en event handler som sættes til mouseclicked
				
				GUIMenu This = (GUIMenu) (e.getComponent().getParent()); //Component spørg hvad e er, som er vores mouseclicked, og getParent er hele siden den er på
				
				This.client.changePage(new GUICreateGame(This.client)); //Hvis man trykker på Play Game knappen ændres siden til GUICreateGame
			}
		});
		btnNewButton.setBackground(new Color(154, 205, 50));
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		btnNewButton.setBounds(160, 49, 128, 64);
		this.add(btnNewButton);
		
		JButton button = new JButton("<html>Show<br/> Highscore</html>"); //Show Highscore knappen som er en JButton
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //Tilføjer en event handler som sættes til mouseclicked
				
				GUIMenu This = (GUIMenu) (e.getComponent().getParent()); //Component spørg hvad e er, som er vores mouseclicked, og getParent er hele siden den er på
				
				This.client.changePage(new GUIHighscore(This.client)); //Hvis man trykker på Show Highscore knappen ændres siden til GUIHighscore
			}
		});
		button.setBackground(new Color(255, 165, 0));
		button.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		button.setBounds(160, 124, 128, 64);
		this.add(button);
		
		JButton button_2 = new JButton("<html>Back to <br /> The Future</html>"); //Log ud knappen som er en JButton
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //Tilføjer en event handler som sættes til mouseclicked
				
				GUIMenu This = (GUIMenu) (e.getComponent().getParent()); //Component spørg hvad e er, som er vores mouseclicked, og getParent er hele siden den er på
				
				This.client.changePage(new GUILogin(This.client)); //Hvis man trykker på Back to the future knappen ændres siden tilbage til GUILogin
			}
		});
		button_2.setBackground(new Color(106, 90, 205));
		button_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		button_2.setBounds(160, 199, 128, 64);
		this.add(button_2);

	}

}
