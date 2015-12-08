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

public class ActualGame extends JPanel {

	private Main client;
	private JSONObject CurrentGame = null;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	/**
	 * Create the panel.
	 */
	public ActualGame(Main client, String GameName) {
		
		this.client = client;
		
		JSONObject GameInfo = new JSONObject(); 
		
		try {
					        
			GameInfo.put("GameName", GameName);
			GameInfo.put("Username", this.client.getCurrentUser());
			GameInfo.put("Method", "GameInfo");
			
			JSONObject Response = this.client.MessageToServer(GameInfo);
			
			if (Response != null && Response.has("Result")) {
			
				if (Response.getBoolean("Result")) {
					
					this.CurrentGame = Response.getJSONObject("GameInfo");
				}
		    }
		    
		} catch (JSONException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}
		
		if (this.CurrentGame == null) {
			
			this.client.changePage(new GUICreateGame(this.client));
		}
		
		setLayout(null);
		
		JButton btnGetBack = new JButton("Get Back");
		btnGetBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ActualGame This = (ActualGame) (e.getComponent().getParent());
				
				This.client.changePage(new GUICreateGame(This.client));
			}
		});
		btnGetBack.setBackground(new Color(107, 142, 35));
		btnGetBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGetBack.setBounds(319, 249, 89, 23);
		add(btnGetBack);
		
		try {
			String ButtonText = "Leave Game";
			
			if (this.client.getCurrentUser().equals(this.CurrentGame.getString("Player1"))) {
			
				ButtonText = "Delete Game";
			}
			
			JButton btnDeleteGame = new JButton(ButtonText);
			btnDeleteGame.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					JSONObject DeleteGame = new JSONObject();
					
					ActualGame This = (ActualGame) (e.getComponent().getParent());
			        		        
			        try {
			        	
						String Method = "LeaveGame";
						
						if (This.client.getCurrentUser().equals(This.CurrentGame.getString("Player1"))) {
						
							Method = "DeleteGame";
						}
						            
			            DeleteGame.put("Username", This.client.getCurrentUser());
			            DeleteGame.put("GameName", This.CurrentGame.getString("GameName"));
			            DeleteGame.put("Method", Method);
			            
			            JSONObject Response = This.client.MessageToServer(DeleteGame);
			            
			            if (Response != null && Response.has("Result")) {
			            	
			            	if (Response.getBoolean("Result")) {
			            
			            	This.client.changePage(new GUICreateGame(This.client));
			 
			            	
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
			lblTest = new JLabel(this.CurrentGame.getString("GameName"));
			lblTest.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
			lblTest.setHorizontalAlignment(SwingConstants.CENTER);
			lblTest.setBounds(133, 22, 202, 31);
			add(lblTest);
			
			JLabel lblNewLabel = new JLabel(CurrentGame.getString("Player1"));
			lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
			lblNewLabel.setBounds(40, 66, 66, 14);
			add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("" + CurrentGame.getInt("Player1Score"));
			lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
			lblNewLabel_1.setBounds(40, 91, 46, 14);
			add(lblNewLabel_1);
			
			JButton btnNewButton = new JButton("Send Moves");
			btnNewButton.setBackground(new Color(0, 255, 255));
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					ActualGame This = (ActualGame) (e.getComponent().getParent());
					
					JSONObject UserInput = new JSONObject();
					
					try {
						
						UserInput.put("Username", This.client.getCurrentUser());
						UserInput.put("GameName", This.CurrentGame.getString("GameName"));
						UserInput.put("Method", "UserInput");
						UserInput.put("UserInput", This.textField.getText());
						
						JSONObject Response = This.client.MessageToServer(UserInput);
						
						if (Response != null && Response.has("Result")) {
							
							int State = Response.getInt("Result");
							
							if (State != -1) {
								int Player = 1;
								
								if (This.CurrentGame.getString("Player2").equals(This.client.getCurrentUser())) {
									
									Player = 2;
								}
								
								String Text;
								
								if (State == Player) {
									
									Text = "You Win";
								}
								else {
									
									Text = "You Loss";
								}
								
								if (State == 0) {
									
									Text = "Next Round";
								}
								
								if (State == -2) {
									
									Text = "Waiting for the other player";
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
			
			textField = new JTextField();
			textField.setBounds(175, 174, 117, 20);
			add(textField);
			textField.setColumns(10);
			
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(190, 125, 86, 14);
			add(lblNewLabel_2);
			
			if (CurrentGame.has("Player2")) {
			
				JLabel label = new JLabel(CurrentGame.getString("Player2"));
				label.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
				label.setBounds(40, 147, 66, 14);
				add(label);
				
				JLabel label_1 = new JLabel("" + CurrentGame.getInt("Player2Score"));
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
