import javax.swing.JPanel;

import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class ActualGame extends JPanel { //Nedarver fra JPanel
	//Instanitere lokalvariable
	private Main client;
	private JSONObject CurrentGame = null;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	/**
	 * Create the panel.
	 */
	public ActualGame(Main client, String GameName) { //Klassen konstruktør, som indeholder Main client og String GameName
		
		this.client = client; //this.client sættes ind i client
		
		JSONObject GameInfo = new JSONObject(); //oprette et JSONObject variable som hedder GameInfo og modtager nyt JSONObject 
		
		try {
					        
			GameInfo.put("GameName", GameName); //Der indsættes en værdi i GameName som kaldes GameName
			GameInfo.put("Username", this.client.getCurrentUser());//Der indsættes en værdi i GameInfo under Username som indeholder this.client.getCurrentUser 
			GameInfo.put("Method", "GameInfo"); //Spørg efter method, som her er GameInfo
			
			JSONObject Response = this.client.MessageToServer(GameInfo); //Her oprettes en ny JSONObject variable, som sætter GameInfo ind i den nye variable som hedder Response
			
			if (Response != null && Response.has("Result")) { //Hvis Response (GameInfo) er rigtigt og har et resultat, bliver den sendt videre
			
				if (Response.getBoolean("Result")) { //Boolean undersøge om response er sandt eller falsk 	
					
					this.CurrentGame = Response.getJSONObject("GameInfo"); // this.CurrentGame indeholder Response som indeholder GameInfo
				}
		    }
		    
		} catch (JSONException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}
		
		if (this.CurrentGame == null) { //Hvis this.CurrentGame er det samme som null så kører if funktionen
			
			this.client.changePage(new GUICreateGame(this.client)); //Ændre side til GUICreateGame
		}
		
		setLayout(null);
		
		JButton btnGetBack = new JButton("Get Back"); //Knappen som fører brugeren tilbage til GUICreateGame siden
		btnGetBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //Event handler med mouseclicked
				
				ActualGame This = (ActualGame) (e.getComponent().getParent()); //Component spørg hvad e er, som er vores mouseclicked, og getParent er hele siden den er på
				
				This.client.changePage(new GUICreateGame(This.client)); //Ændre side til GUICreateGame
			}
		});
		btnGetBack.setBackground(new Color(107, 142, 35));
		btnGetBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGetBack.setBounds(319, 249, 89, 23);
		add(btnGetBack);
		
		try {
			String ButtonText = "Leave Game"; //En knap med Leave Game
			
			if (this.client.getCurrentUser().equals(this.CurrentGame.getString("Player1"))) { //Hvis CurrentUser er den samme som har lavet CurrentGame kan brugeren slette spillet
			
				ButtonText = "Delete Game"; //Slet knap for brugeren som har oprettet spillet
			}
			
			JButton btnDeleteGame = new JButton(ButtonText);
			btnDeleteGame.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) { //Event handler med mouseclicked
					
					JSONObject DeleteGame = new JSONObject(); //Oprettes JSONObjekt variable som bliver kaldt DeleteGame
					
					ActualGame This = (ActualGame) (e.getComponent().getParent()); //Component spørg hvad e er, som er vores mouseclicked, og getParent er hele siden den er på
			        		        
			        try {
			        	
						String Method = "LeaveGame"; //En String metode som indeholder LeaveGame
						
						if (This.client.getCurrentUser().equals(This.CurrentGame.getString("Player1"))) { //Hvis CurrentUser er det samme som CurrentGame kører if funktionen 
						
							Method = "DeleteGame"; // Metoden som indeholder DeleteGame 
						}
						            
			            DeleteGame.put("Username", This.client.getCurrentUser()); //Der indsættes en værdi i DeleteGame under Username som indeholder this.client.getCurrentUser 
			            DeleteGame.put("GameName", This.CurrentGame.getString("GameName")); //Der indsættes en værdi i DeleteGame under GameName som indeholder This.CurrentGame.getString("GameName")
			            DeleteGame.put("Method", Method); //Spørg efter Method, som er method
			            
			            JSONObject Response = This.client.MessageToServer(DeleteGame); //Her oprettes en ny JSONObject variable, som sætter DeleteGame ind i den nye variable som hedder Response
			            
			            if (Response != null && Response.has("Result")) { //Hvis DeleteGame (Response) er rigtigt og har et resultat, bliver den sendt videre
			            	
			            	if (Response.getBoolean("Result")) { //Her undersøges om Response er sandt eller falsk
			            
			            	This.client.changePage(new GUICreateGame(This.client)); //Skifter side tilbage til GUICreateGame
			 
			            	}
			            }
			            
			        } catch (JSONException e1) {
			            // TODO Auto-generated catch block
			            e1.printStackTrace();
			        }
				}
			});
			btnDeleteGame.setBackground(new Color(128, 0, 128));
			btnDeleteGame.setForeground(new Color(0, 0, 0));
			btnDeleteGame.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnDeleteGame.setBounds(40, 249, 117, 23);
			add(btnDeleteGame);
	
		} catch (JSONException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		JLabel lblTest;
		
		try {
			lblTest = new JLabel(this.CurrentGame.getString("GameName")); //Overskrift på spil siden, som er det navn brugeren tildeler spillet
			lblTest.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
			lblTest.setHorizontalAlignment(SwingConstants.CENTER);
			lblTest.setBounds(133, 22, 202, 31);
			add(lblTest);
			
			JLabel lblNewLabel = new JLabel(CurrentGame.getString("Player1")); //I dette JLabel ses spiller1's navn på spil siden
			lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
			lblNewLabel.setBounds(40, 66, 66, 14);
			add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("" + CurrentGame.getInt("Player1Score")); //I dette JLabel ses spiller1's score på spil siden
			lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
			lblNewLabel_1.setBounds(40, 91, 46, 14);
			add(lblNewLabel_1);
			
			JButton btnNewButton = new JButton("Send Moves"); //Knappen som indsender spillerens træk til serveren
			btnNewButton.setBackground(new Color(0, 255, 255));
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) { //tilføjet en event handler med et mouseclicked event
					
					ActualGame This = (ActualGame) (e.getComponent().getParent()); //Component spørg hvad e er, som er vores mouseclicked, og getParent er hele siden den er på
					
					JSONObject UserInput = new JSONObject(); // Opretter et JSONObject variable med navnet UserInput og modtaget et nyt JSONObject 
					
					try {
						
						UserInput.put("Username", This.client.getCurrentUser()); //Der indsættes en værdi i UserInput under Username som indeholder this.client.getCurrentUser 
						UserInput.put("GameName", This.CurrentGame.getString("GameName")); //Der indsættes en værdi i UserInput under GameName som indeholder This.CurrentGame.getString("GameName")
						UserInput.put("Method", "UserInput"); //Indsættes en metode i UserInput som indeholder UserInput
						UserInput.put("UserInput", This.textField.getText()); //Indsættes værdien UserInput, som indeholder This.textField.getText
						
						JSONObject Response = This.client.MessageToServer(UserInput); //Her oprettes en ny JSONObject variable, som sætter UserInput ind i den nye variable som hedder Response
						
						if (Response != null && Response.has("Result")) { //Hvis Response er rigtigt og har et resultat, bliver den sendt videre
							
							int State = Response.getInt("Result"); //Opretter en int med navnet State som indeholder Response, og den indeholder Result 
							
							if (State != -1) { //Hvis State ikke er -1 kører if funktionen
								int Player = 1; //Player bliver sat til 1
								
								if (This.CurrentGame.getString("Player2").equals(This.client.getCurrentUser())) { //Hvis spiller 2 som man henter fra CurrentGame er den samme som som den spiller man henter fra klienten, så kører spillet
									
									Player = 2; //Her sættes player til 2
								}
								
								String Text; //En String som bliver sat til Text
								
								if (State == Player) { // Hvis State er det samme som player kører if funktionen
									
									Text = "You Win"; //Text viser You Win
								}
								else { // Hvis State ikker er det samme
									
									Text = "You Loss"; //Text viser You Loss
								}
								
								if (State == 0) { //Hvis State er det samme som 0
									
									Text = "Next Round"; //Viser Text Next Round
								}
								
								if (State == -2) { //Hvis State er det samme som -2
									
									Text = "Waiting for the other player"; //Viser Text Waiting for the other player
								}
								
								This.lblNewLabel_2.setText(Text);
							}
						}
						
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					
				}
			});
			btnNewButton.setBounds(175, 205, 117, 23);
			add(btnNewButton);
			
			textField = new JTextField(); //Her skriver spilleren sine træk ind i en JTextField
			textField.setBounds(175, 174, 117, 20);
			add(textField);
			textField.setColumns(10);
			
			lblNewLabel_2 = new JLabel(""); // I dette JLabel kan spilleren se hvad serveren svarer tilbage, og om man har vundet eller tabt 
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(133, 125, 242, 14);
			add(lblNewLabel_2);
			
			if (CurrentGame.has("Player2")) { //Hvis CurrentGame har spiller nr 2 kan følgende ses
			
				JLabel label = new JLabel(CurrentGame.getString("Player2")); //I dette JLabel ses spiller2's navn på spil siden
				label.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
				label.setBounds(40, 147, 66, 14);
				add(label);
				
				JLabel label_1 = new JLabel("" + CurrentGame.getInt("Player2Score")); //I dette JLabel ses spiller2's score på spil siden
				label_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
				label_1.setBounds(40, 172, 46, 14);
				add(label_1);
				
			}
			
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
