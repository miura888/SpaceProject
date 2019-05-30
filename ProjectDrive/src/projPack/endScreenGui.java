package projPack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class endScreenGui {

	private JFrame endWindow;
	private Game manager;
	public static JLabel endMessage1;
	public static JLabel endMessage2;
	public static JLabel endMessage3;
	
	public endScreenGui(Game incomingManager) {
		manager = incomingManager;
		initialize();
		endWindow.setVisible(true);
	}
	public void closeWindow() {
		endWindow.dispose();
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					endScreenGui window = new endScreenGui();
					window.endWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public endScreenGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		endWindow = new JFrame();
		endWindow.setBounds(100, 100, 450, 300);
		endWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		endWindow.getContentPane().setLayout(new MigLayout("", "[400][400]", "[40][40][40][40]"));
		
		endMessage1 = new JLabel("");
		endWindow.getContentPane().add(endMessage1, "cell 0 0 2 1");
		
		endMessage2 = new JLabel("You Found X Parts in Y Days");
		endWindow.getContentPane().add(endMessage2, "cell 0 1 2 1");
		
		endMessage3 = new JLabel("The surviving crew members are:");
		endWindow.getContentPane().add(endMessage3, "cell 0 2 2 1");
		
		JButton btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.main(null);
				closeWindow();
			}
		});
		endWindow.getContentPane().add(btnPlayAgain, "cell 0 3,grow");
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeWindow();
			}
		});
		endWindow.getContentPane().add(btnExit, "cell 1 3,grow");
	}

}
