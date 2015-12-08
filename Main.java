import java.awt.Container;
import java.awt.EventQueue;
import java.io.BufferedReader;
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

	private JFrame frame;
	private String serverAdresse = "localhost";
	private int port = 10800; 
	private Socket socket; 
	private String CurrentUser = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		
Socket kkSocket;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel JPanel = new GUILogin(this);
		frame.getContentPane().add(JPanel);
	}
	
	public void changePage(JPanel newJPanel) {
		Container page = frame.getContentPane();
		page.removeAll();
		page.add(newJPanel);
		page.repaint();
		page.revalidate();
	}
	
	public JSONObject MessageToServer(JSONObject data) {
		
		System.out.println(data);
		
		JSONObject response = null; //Hvis serveren sendet andet end JSONobjekter, så returneres null
		
		try {
			
			this.socket = new Socket(this.serverAdresse, this.port);
			PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			
			out.println(data.toString()); 
			
			try {
				response = new JSONObject(in.readLine());
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
		
		System.out.println(response);
		return response;
	}
	
	public String getCurrentUser() {
        return CurrentUser;
    }

	public void setCurrentUser(String currentUser) {
        CurrentUser = currentUser;
    }
}
