import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.List;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class GUICreateGame extends JPanel { //Klassen nedarver fra JPanel
	//Instanitere lokalvariable
	private JTextField textField;
	private Main client;
	private JList list; 

	/**
	 * Create the panel.
	 */
	public GUICreateGame(Main client) { //Klassens konstrukt�r
		
		this.client = client; //this.client s�ttes ind i client
		
		class item {// klasse som kan indeholder spillets navn som man kan se i gui, det kan holde p� highscoren og brugernavn
			//Instanitere lokalvariable
			public int highscore;
			public String gameName;
			public item(int highscore, String gameName) {
				
				this.highscore = highscore; 
				this.gameName = gameName;
			}
			
			public String toString() {
				
				return this.gameName+ "  " + this.highscore; // returne en string s� det er l�seligt

			}
			
		}
		
		this.setBackground(new Color(255, 255, 240));
		this.setLayout(null);
		
		JLabel lblCreateGame = new JLabel("Create Game"); //Create Game overskriften p� siden, dens font, skrifttype og placering p� siden
		lblCreateGame.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblCreateGame.setBounds(34, 11, 141, 30);
		this.add(lblCreateGame);
		
		JLabel lblToCreateGame = new JLabel("<html>To create a new game<br/> please type a game name below</html>"); //JLabel med forklarende tekst til brugeren
		lblToCreateGame.setBounds(34, 48, 147, 56);
		this.add(lblToCreateGame);
		
		textField = new JTextField();
		textField.setBounds(34, 99, 141, 20);
		this.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Create Game"); //Create Game knappen som er en JButton
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //Tilf�jet event handler som er sat til mouseclicked
				
				GUICreateGame This = (GUICreateGame) (e.getComponent().getParent()); //Component sp�rg hvad e er, som er vores mouseclicked, og getParent er hele siden den er p�
								
				JSONObject CreateGame = new JSONObject(); //oprette et JSONObject variable som hedder CreateGame og modtager nyt JSONObject 
				
				try {
					CreateGame.put("Method", "CreateGame"); //Sp�rg efter method, som her er CreateGame
					CreateGame.put("Username", This.client.getCurrentUser()); //Der inds�ttes en v�rdi i CreateGame under Username som indeholder this.client.getCurrentUser 
					CreateGame.put("GameName", This.textField.getText()); //Inds�ttes v�rdien GameName, som indeholder This.textField.getText
					
					JSONObject success = This.client.MessageToServer(CreateGame); //Her oprettes en ny JSONObject variable, som s�tter CreateGame ind i den nye variable som hedder success
					
					if (success != null && success.has("Result")) {	//Hvis CreateGame er rigtigt og har et resultat, bliver den sendt videre
						
						if (success.getBoolean("Result")) { //Her unders�ges om resultatet er sandt eller falsk
							
							This.client.changePage(new ActualGame(This.client, This.textField.getText())); //Efter man har oprettet et nyt spil kommer man ind p� ActualGame siden
						}
					}
					 	
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(154, 205, 50));
		btnNewButton.setBounds(34, 132, 111, 45);
		this.add(btnNewButton);
		
		JButton btnGetBack = new JButton("Get Back"); //Knappen f�rer brugeren tilbage til menu siden
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
		
		JLabel label = new JLabel("Join Game"); //Join Game knappen som er en JButton
		label.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		label.setBounds(195, 11, 141, 30);
		add(label);
		
		JLabel label_1 = new JLabel("<html>Select a game<br/>you want to join </html>"); //JLabel med forklarende tekst til brugeren
		label_1.setBounds(191, 41, 147, 56);
		add(label_1);
		
		JButton button = new JButton("Join Game");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //Tilf�jet event handler som er sat til mouseclicked
				
				GUICreateGame This = (GUICreateGame) (e.getComponent().getParent()); //Component sp�rg hvad e er, som er vores mouseclicked, og getParent er hele siden den er p�
				
				JSONObject JoinGame = new JSONObject(); //oprette et JSONObject variable som hedder JoinGame og modtager nyt JSONObject 
				
				item Selection = (item) This.list.getSelectedValue(); //Opretter et item objekt som har navnet Selection, som indeholder (item) og det indeholder This.list.getSelectedValue som er det brugeren har valgt p� siden
				
				if (Selection != null) { //Hvis Selection ikke er nul, k�rer try
				
					try {
									            
						JoinGame.put("GameName", Selection.gameName); //Inds�ttes v�rdien GameName, som indeholder This.textField.getText
			            JoinGame.put("Username", This.client.getCurrentUser()); //Der inds�ttes en v�rdi i JoinGame under Username som indeholder this.client.getCurrentUser 
			            JoinGame.put("Method", "JoinGame"); //Sp�rg efter method, som her er JoinGame
			            
			            JSONObject Response = This.client.MessageToServer(JoinGame); //Her oprettes en ny JSONObject variable, som s�tter JoinGame ind i den nye variable som hedder Response
			            
			            if (Response != null && Response.has("Result")) { //Hvis Response (JoinGame) er rigtigt og har et resultat, bliver den sendt videre
			                
			                boolean ThisResult = Response.getBoolean("Result"); //Her unders�ges om resultatet er sandt eller falsk
			                
			                if (ThisResult) {
			                	
			                	This.client.changePage(new ActualGame(This.client, Selection.gameName)); //Hvis resultatet er sandt sendes brugeren videre til ActualGame siden
			                	
			                }
			            }
			            
			        } catch (JSONException e1) {
			            // TODO Auto-generated catch block
			            e1.printStackTrace();
			        }
				}
			}
		});
		button.setBackground(new Color(189, 183, 107));
		button.setBounds(187, 184, 111, 45);
		add(button);
		
		JSONObject ShowGames = new JSONObject(); //oprette et JSONObject variable som hedder ShowGames og modtager nyt JSONObject 
		
		JSONObject Response; //Her oprettes et JSONObject Response 
		
		JSONArray GameList = null; //Her oprettes et JSONArray GameList som er sat til null
		
		try {
            
            ShowGames.put("Method", "ShowGames"); //Sp�rg efter method, som her er ShowGames
            
            Response = this.client.MessageToServer(ShowGames); //Her oprettes en ny JSONObject variable, som s�tter ShowGames ind i den nye variable som hedder Response
            
            if (Response != null && Response.has("Result")) { //Hvis Response (ShowGames) er rigtigt og har et resultat, bliver den sendt videre
                
                GameList = Response.getJSONArray("Result"); //Her oprettes en ny JSONArray variable, som s�tter Result ind i den nye variable som hedder GameList
            }
            
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		
		list = new JList(); //En JList som viser hvilke spil man kan tilslutte 
		list.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		list.setBackground(Color.WHITE);
		list.setBounds(187, 99, 150, 78);
		add(list);
		
		if (GameList != null) { // Hvis GameList ikker er null s� k�rer if'en
			
			DefaultListModel listModel = new DefaultListModel(); //Oprettes en DefaultListModel variable som hedder listModel
			
			JSONObject CurrentGame; //JSONObject CurrentGame bliver oprettet
			
			for (int i = 0; i < GameList.length(); i++) { //I for loop laves en int som hedder i og s�ttes lig med 0. Hvis i er mindre end GameList, s� k�rer try, og loppet k�rer igen og 1 l�gges for hver gang

				
				try {
					
					CurrentGame = GameList.getJSONObject(i); // CurrentGame indeholder en GameList som indeholder et JSONObject i
					
					listModel.addElement(new item(CurrentGame.getInt("Highscore"), CurrentGame.getString("Name"))); //listModel tilf�jer et element som kaldes new item som indeholder CurrentGame.getInt("Highscore") og CurrentGame.getString("Name")

                    
			    } catch (JSONException e1) {
		            // TODO Auto-generated catch block
		            e1.printStackTrace();
		        }
				
				
			}
			
			list.setModel(listModel);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //G�r at man kun kan v�lge et spil af gangen
			
			JScrollPane scrollPane_1 = new JScrollPane(list); //Tilf�jer et scrollpane s� man kan rulle op og ned i spillene
	        scrollPane_1.setBounds(187, 99, 150, 78);
	        this.add(scrollPane_1);
			
			
		}
		
		JButton btnOpdate = new JButton("Opdate"); //En opdater knap 
		btnOpdate.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnOpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //Event handler med et mousecliced 
				
				GUICreateGame This = (GUICreateGame) (e.getComponent().getParent()); //Component sp�rg hvad e er, som er vores mouseclicked, og getParent er hele siden den er p�
				
				This.client.changePage(new GUICreateGame(This.client)); //Opdatere siden s� man kommer ind p� den samme
			}
			
		});
		btnOpdate.setBounds(343, 98, 69, 23);
		add(btnOpdate);

	}
}
