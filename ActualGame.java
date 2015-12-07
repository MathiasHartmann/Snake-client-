import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ActualGame extends JPanel {

	private Main client;
	/**
	 * Create the panel.
	 */
	public ActualGame(Main client) {
		
		this.client = client;
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

	}

}
