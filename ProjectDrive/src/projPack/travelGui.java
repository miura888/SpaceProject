package projPack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class travelGui {

	public int count = 0;
	private JFrame travelWindow;
	private Game manager;
	public int int1;
	public int int2;
	public static JLabel travelDialog;
	
	
	
	public travelGui(Game incomingManager) {
		manager = incomingManager;
		initialize();
		travelWindow.setVisible(true);
	}
	public void closeWindow() {
		travelWindow.dispose();
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					travelGui window = new travelGui();
					window.travelWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public travelGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		travelWindow = new JFrame();
		travelWindow.setBounds(100, 100, 818, 474);
		travelWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		travelWindow.getContentPane().setLayout(new MigLayout("", "[129.00][99.00][161.00]", "[97.00][80.00][72.00][81.00][40][]"));
		
		JButton travelButton = new JButton("Travel to New Planet");
		travelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.NewPlanet(int1, int2);
				closeWindow();
				
			}
		});
		travelButton.setEnabled(false);
		travelWindow.getContentPane().add(travelButton, "cell 0 4 2 1,grow");
		
		
		JLabel crewLabel = new JLabel(Game.Crew.get(0).getName());
		travelWindow.getContentPane().add(crewLabel, "cell 0 0");
		
		JRadioButton crew1Button = new JRadioButton(Game.Crew.get(0).getName());
		crew1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				if (crew1Button.isSelected()) {
					if (count >= 2) {
						crew1Button.setSelected(false);
						System.out.println("there are too  many buttons selected");
					} else {
						count += 1;
						System.out.println(count);
						if (count == 2) {
							int2 = 0;
							travelButton.setEnabled(true);
						} else {
							int1 = 0;
						}
					}
				} else {
					
					count -= 1;
					System.out.println(count);
					travelButton.setEnabled(false);
				}
			}
		});
		travelWindow.getContentPane().add(crew1Button, "cell 1 0");
		if (Game.Crew.get(0).getAction() == 0) {
			crew1Button.setEnabled(false);
		}
		
		JLabel label = new JLabel(Game.Crew.get(1).getName());
		travelWindow.getContentPane().add(label, "cell 0 1");
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeWindow();
			}
		});
		travelWindow.getContentPane().add(backButton, "cell 2 4");
		
		travelDialog = new JLabel("Choose Members to pilot ship");
		travelWindow.getContentPane().add(travelDialog, "cell 0 5 3 1,alignx center");
		
		JRadioButton crew2Button = new JRadioButton(Game.Crew.get(1).getName());
		crew2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (crew2Button.isSelected()) {
					if (count >= 2) {
						crew2Button.setSelected(false);
						System.out.println("there are too  many buttons selected");
					} else {
						count += 1;
						System.out.println(count);
						if (count == 2) {
							int2 = 1;
							travelButton.setEnabled(true);
						} else {
							int1 = 1;
						}
					}
				} else {
					count -= 1;
					System.out.println(count);
					travelButton.setEnabled(false);
					
				}
			}
		});
		if (Game.Crew.size() >= 3) {
			travelWindow.getContentPane().add(crew2Button, "cell 1 1");
			if (Game.Crew.get(1).getAction() == 0) {
				crew2Button.setEnabled(false);
			}
		
			JLabel crew3Label = new JLabel(Game.Crew.get(2).getName());
			travelWindow.getContentPane().add(crew3Label, "cell 0 2");
		
			JRadioButton crew3Button = new JRadioButton(Game.Crew.get(2).getName());
			crew3Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (crew3Button.isSelected()) {		
						if (count >= 2) {
							crew3Button.setSelected(false);
							System.out.println("there are too  many buttons selected");
						} else {
							count += 1;
							System.out.println(count);
							if (count == 2) {
								int2 = 2;
								travelButton.setEnabled(true);
							} else {
								int1 = 2;
							}
						}
					} else {
						count -= 1;
						System.out.println(count);
						travelButton.setEnabled(false);
					}
				}
			});
			travelWindow.getContentPane().add(crew3Button, "cell 1 2");
			if (Game.Crew.get(2).getAction() == 0) {
				crew3Button.setEnabled(false);
			}
		}
		
		if (Game.Crew.size() >= 4) {
			
			JLabel crew4Label = new JLabel(Game.Crew.get(3).getName());
			travelWindow.getContentPane().add(crew4Label, "cell 0 3");
			JRadioButton crew4Button = new JRadioButton(Game.Crew.get(3).getName());
			crew4Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (crew4Button.isSelected()) {
						if (count >= 2) {
							crew4Button.setSelected(false);
							System.out.println("there are too  many buttons selected");
						} else {
							count += 1;
							System.out.println(count);
							if (count == 2) {
								int2 = 3;
								travelButton.setEnabled(true);
							} else {
								int1 = 3;
							}
						}
					} else {
						count -= 1;
						System.out.println(count);
						travelButton.setEnabled(false);
					}
				}
			});
			travelWindow.getContentPane().add(crew4Button, "cell 1 3");
			if (Game.Crew.get(3).getAction() == 0) {
				crew4Button.setEnabled(false);
			}
		}
		
	}
	
}


