import java.awt.Container;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.json.JSONException;
import org.json.JSONObject;

public class Main {
    //Instanitere lokalvariable
	private JFrame frame;
	private String serverAdresse = "localhost";
	private int port = 10800; 
	private Socket socket; 
	private String CurrentUser = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { //Klassens main funktion, som indeholder en String array
		EventQueue.invokeLater(new Runnable() { //Spørg mark
			public void run() { //Her oprettes run-funktionen 
				try {
					Main window = new Main(); //Opretter Main objekt som bliver kaldt window, og det indeholder new Main
					window.frame.setVisible(true); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() { //Main klassens konstruktør 
		
		try {
			BufferedReader Reader = new BufferedReader(new FileReader("ClientConfig.txt"));
			
			try {
				JSONObject Setup = new JSONObject(Reader.readLine());
				
				this.serverAdresse = Setup.getString("Address");
				this.port = Setup.getInt("Port");
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { //her oprettes JFrame, samt hvor vinduet åbnes på skærmen og hvor det kan lukkes
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel JPanel = new GUILogin(this); //Her fortæller man JPanel hvad der er hovedprogrammet og at det ejes af Main klassen
		frame.getContentPane().add(JPanel);
	}
	
	public void changePage(JPanel newJPanel) { //Skifter side, og vil have nyt JPanel
		Container page = frame.getContentPane();
		page.removeAll();
		page.add(newJPanel);
		page.repaint();
		page.revalidate();
	}
	
	public JSONObject MessageToServer(JSONObject data) { //Forespørgsel til serveren om data, som skal være JSONObject 
		
		System.out.println(data); 
		
		JSONObject response = null; //Hvis serveren sender andet end JSONobjekter, så returneres null
		
		try {
			
			this.socket = new Socket(this.serverAdresse, this.port); //Den nye socket indeholder server adresse og port 
			PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true); //sender forespørgsler/beskeder til serveren
			BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream())); //modtager svar fra serveren
			
			out.println(data.toString()); //Her sendes forespørgslen til serveren om at få noget data 
			
			try {
				
				response = new JSONObject(in.readLine()); //Serveren skal returnere JSONObject 
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.socket.close();
			
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(response); //Her udskrives svaret fra serveren
		
		return response;
	}
	
	public String getCurrentUser() { //Get og set funktionerne til CurrentUser, som returnere CurrentUser 
        return CurrentUser;
    }

	public void setCurrentUser(String currentUser) {
        CurrentUser = currentUser;
    }
}
