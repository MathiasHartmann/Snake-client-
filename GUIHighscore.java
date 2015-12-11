import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import org.json.JSONException;
import org.json.JSONObject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIHighscore extends JPanel { //Denne klasse nedarver JPanel
	
	private Main client; //Instanitere lokalvariable

	/**
	 * Create the panel.
	 */
	public GUIHighscore(Main client) { //Klassen konstruktør, som ejes af Main klassen og bliver kaldt client
		
		this.client = client; //this.client sættes ind i client
		this.setBackground(new Color(255, 255, 240));
		this.setLayout(null);
		
		JLabel lblHighscore = new JLabel("Highscore"); //Overskriften på siden, dens font, skrifttype og placering på siden
		lblHighscore.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblHighscore.setBounds(162, 24, 109, 22);
		this.add(lblHighscore);
		
		JLabel lblNewLabel = new JLabel("Your Highscore"); //Underoverskrift for brugerens highscore
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		lblNewLabel.setBounds(99, 53, 95, 14);
		this.add(lblNewLabel);
		
		JLabel lblOverallHighscore = new JLabel("Overall Highscore"); //Underoverskrift for den bruger med højest highscore
		lblOverallHighscore.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		lblOverallHighscore.setBounds(217, 53, 102, 14);
		this.add(lblOverallHighscore);
		
		JButton btnGetBack = new JButton("Get Back"); //Tilbage knap, som fører brugeren tilbage til menu siden
		btnGetBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //tilføjet event handler mouseclicked
				
				GUIHighscore This = (GUIHighscore) (e.getComponent().getParent());
				
				This.client.changePage(new GUIMenu(This.client));
			}
		});
		btnGetBack.setBackground(new Color(238, 130, 238));
		btnGetBack.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		btnGetBack.setBounds(299, 227, 89, 23);
		this.add(btnGetBack);
		
		JSONObject NameHighscore = new JSONObject(); //Her oprettes en JSONObject variable NameHighscore
        
        int Highscore = -1;
        
        try {
            
            NameHighscore.put("Username", this.client.getCurrentUser()); //Der indsættes en værdi i NameHighscore under Username som indeholder this.client.getCurrentUser 
            NameHighscore.put("Method", "UserHighscore"); //Spørg efter method, som her er UserHighscore
            
            JSONObject Response = this.client.MessageToServer(NameHighscore); //Her oprettes en ny JSONObject variable, som sætter NameHighscore ind i den nye variable som hedder Response 
            
            if (Response != null && Response.has("Result")) { //Undersøger om Response (NameHighscore) ikke er null og det har et resultat
                
                Highscore = Response.getInt("Result");  //Her sættes Response som indeholder Result ind i Highscore
            }
            
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        JLabel lblNewLabel_1 = new JLabel(Integer.toString(Highscore)); //JLabel som viser highscore
		lblNewLabel_1.setBounds(132, 78, 43, 23);
		add(lblNewLabel_1);
        
        JSONObject OverallHighscore = new JSONObject(); //Her oprettes en JSONObject variable OverallHighscore, som indeholder et nyt JSONObject 
        
        Highscore = -1; //Sættes til -1 så man kan se at der ikke er modtaget highscore fra serveren
        
        try {
            
            OverallHighscore.put("Method", "GlobalHighscore"); //Spørg efter method, som her er GlobalHighscore
            
            JSONObject Response = this.client.MessageToServer(OverallHighscore); //Her oprettes en ny JSONObject variable, som sætter OverallHighscore ind i den nye variable som hedder Response
            
            if (Response != null && Response.has("Result")) { //Undersøger om Response (OverallHighscore) ikke er null og den har et resultat
                
                Highscore = Response.getInt("Result");  //Her sættes Response som indeholder Result ind i Highscore
            }
            
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		
        JLabel lblNewLabel_3 = new JLabel(Integer.toString(Highscore));
		lblNewLabel_3.setBounds(254, 78, 43, 23);
		add(lblNewLabel_3);

	}
}
