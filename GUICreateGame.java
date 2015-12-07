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

public class GUICreateGame extends JPanel {
	
	private JTextField textField;
	private Main client;
	private JList list; 

	/**
	 * Create the panel.
	 */
	public GUICreateGame(Main client) {
		
		this.client = client;
		
		class item {
			
			public int highscore;
			public String gameName;
			public item(int highscore, String gameName) {
				
				this.highscore = highscore; 
				this.gameName = gameName;
			}
			
			public String toString() {
				
				return this.gameName+ "    " + this.highscore;
			}
			
		}
		
		this.setBackground(new Color(255, 255, 240));
		this.setLayout(null);
		
		JLabel lblCreateGame = new JLabel("Create Game");
		lblCreateGame.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblCreateGame.setBounds(34, 11, 141, 30);
		this.add(lblCreateGame);
		
		JLabel lblToCreateGame = new JLabel("<html>To create a new game<br/> please type a game name below</html>");
		lblToCreateGame.setBounds(34, 48, 147, 56);
		this.add(lblToCreateGame);
		
		textField = new JTextField();
		textField.setBounds(34, 99, 141, 20);
		this.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Create Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				GUICreateGame This = (GUICreateGame) (e.getComponent().getParent());
				
				This.client.changePage(new ActualGame(This.client));
				
				JSONObject CreateGame = new JSONObject(); 
				
				try {
					CreateGame.put("Method", "CreateGame");
					CreateGame.put("GameName", This.textField.getText()); 
					JSONObject success = This.client.MessageToServer(CreateGame);
					
					if (success != null && success.has("Result")) {	
						
						if (success.getBoolean("Result")) {
							This.client.changePage(new ActualGame(This.client));
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
		label.setBounds(195, 11, 141, 30);
		add(label);
		
		JLabel label_1 = new JLabel("<html>Select a game<br/>you want to join </html>");
		label_1.setBounds(191, 41, 147, 56);
		add(label_1);
		
		JButton button = new JButton("Join Game");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				GUICreateGame This = (GUICreateGame) (e.getComponent().getParent());
				
				JSONObject JoinGame = new JSONObject(); 
				
				try {
					
					item Selection = (item) This.list.getSelectedValue();
		            
					JoinGame.put("GameName", Selection.gameName);
		            JoinGame.put("Username", This.client.getCurrentUser());
		            JoinGame.put("Method", "JoinGame");
		            
		            JSONObject Response = This.client.MessageToServer(JoinGame);
		            
		            if (Response != null && Response.has("Result")) {
		                
		                boolean ThisResult = Response.getBoolean("Result");
		                
		                if (ThisResult) {
		                	
		                	This.client.changePage(new ActualGame(This.client));
		                	
		                }
		            }
		            
		        } catch (JSONException e1) {
		            // TODO Auto-generated catch block
		            e1.printStackTrace();
		        }
			}
		});
		button.setBackground(new Color(189, 183, 107));
		button.setBounds(187, 184, 111, 45);
		add(button);
		
		JSONObject ShowGames = new JSONObject();
		
		JSONObject Response;
		
		JSONArray GameList = null;
		
		try {
            
            ShowGames.put("Method", "ShowGames");
            
            Response = this.client.MessageToServer(ShowGames);
            
            if (Response != null && Response.has("Result")) {
                
                GameList = Response.getJSONArray("Result");  
            }
            
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		
		list = new JList();
		list.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		list.setBackground(Color.WHITE);
		list.setBounds(187, 99, 150, 78);
		add(list);
		
		if (GameList != null) {
			
			DefaultListModel listModel = new DefaultListModel();
			
			JSONObject CurrentGame;
			
			for (int i = 0; i < GameList.length(); i++) {
				
				try {
					
					CurrentGame = GameList.getJSONObject(i);
					
					listModel.addElement(new item(CurrentGame.getInt("Highscore"), CurrentGame.getString("Name")));
                    
			    } catch (JSONException e1) {
		            // TODO Auto-generated catch block
		            e1.printStackTrace();
		        }
				
				
			}
			
			list.setModel(listModel);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			JScrollPane scrollPane_1 = new JScrollPane(list);
	        scrollPane_1.setBounds(187, 99, 150, 78);
	        this.add(scrollPane_1);
			
			
		}
		
		JButton btnOpdate = new JButton("Opdate");
		btnOpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				GUICreateGame This = (GUICreateGame) (e.getComponent().getParent());
				
				This.client.changePage(new GUICreateGame(This.client));
			}
			
		});
		btnOpdate.setBounds(343, 98, 89, 23);
		add(btnOpdate);

	}
}
