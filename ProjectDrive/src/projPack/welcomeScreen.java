package projPack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class welcomeScreen {

	private JFrame welcomeWindow;
	
	private Game manager;
	public static String c1Type;
	public static String c1Name;
	public static String c2Type;
	public static String c2Name;
	public static String c3Type = null;
	public static String c3Name;
	public static String c4Type = null;
	public static String c4Name;
	public static String shipName;
	
	
	
	private JTable crewTypeTable;
	private JTextField txtCrew1;
	private JTextField txtCrew2;
	private JTextField txtCrew3;
	private JTextField txtCrew4;
	private JTextField txtStarship;
	
	public welcomeScreen(Game incomingManager) {
		manager = incomingManager;
		initialize();
		welcomeWindow.setVisible(true);
	}
	public void closeWindow() {
		welcomeWindow.dispose();
	}
//	public void finishedWindow() {
//		manager.closeMainScreen(this);
//	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcomeScreen window = new welcomeScreen();
					window.welcomeWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public welcomeScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		welcomeWindow = new JFrame();
		welcomeWindow.setTitle("Welcome Screen");
		welcomeWindow.setBounds(100, 100, 788, 532);
		welcomeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomeWindow.getContentPane().setLayout(new MigLayout("", "[567.00][567.00][567.00][567.00]", "[40][30][30][69.00,fill][20][30][30][30][10][30][40]"));
		
		JLabel lblWelcomeToYour = new JLabel("Welcome to your Space Adventure");
		lblWelcomeToYour.setFont(new Font("Dialog", Font.BOLD, 19));
		welcomeWindow.getContentPane().add(lblWelcomeToYour, "cell 0 0 4 1,alignx center");
		
		JLabel lblChooseNumberOf = new JLabel("Choose Number of Days:");
		lblChooseNumberOf.setFont(new Font("Dialog", Font.BOLD, 14));
		welcomeWindow.getContentPane().add(lblChooseNumberOf, "flowx,cell 0 1 4 1,alignx left");
		
		
		JComboBox<Object> comboBox = new JComboBox<Object>(); 
		comboBox.setModel(new DefaultComboBoxModel<Object>(new Integer[] {3, 4, 5, 6, 7, 8, 9, 10}));
		welcomeWindow.getContentPane().add(comboBox, "cell 0 1 4 1,alignx left");
		
		JLabel lblCrewClasses = new JLabel("Crew Classes:");
		lblCrewClasses.setFont(new Font("Dialog", Font.BOLD, 14));
		welcomeWindow.getContentPane().add(lblCrewClasses, "cell 0 2 4 1");
		
		crewTypeTable = new JTable();
		crewTypeTable.setFont(new Font("Dialog", Font.BOLD, 16));
		crewTypeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		crewTypeTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		crewTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "Pilot", "Engineer", "Medic", "Merchant", "Guard", "Goat"},
				{"Health", "100", "80", "90", "100", "80", "100"},
				{"Repair Rate", "80", "100", "50", "40", "40", "40"},
				{"Search Rate", "3", "5", "6", "6", "7", "8"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		crewTypeTable.getColumnModel().getColumn(0).setPreferredWidth(95);
		welcomeWindow.getContentPane().add(crewTypeTable, "cell 0 3 4 1,grow");
		
		JLabel lblChooseCrew = new JLabel("Choose 2-4 Crew Members:");
		lblChooseCrew.setFont(new Font("Dialog", Font.BOLD, 16));
		welcomeWindow.getContentPane().add(lblChooseCrew, "cell 0 4 4 1,alignx center,aligny bottom");
		
		JLabel lblCrew = new JLabel("Crew 1:");
		lblCrew.setFont(new Font("Dialog", Font.BOLD, 14));
		welcomeWindow.getContentPane().add(lblCrew, "cell 0 5");
		
		JLabel lblCrew_1 = new JLabel("Crew 2:");
		lblCrew_1.setFont(new Font("Dialog", Font.BOLD, 14));
		welcomeWindow.getContentPane().add(lblCrew_1, "cell 1 5");
		
		JLabel lblCrew_2 = new JLabel("Crew 3:");
		lblCrew_2.setFont(new Font("Dialog", Font.BOLD, 14));
		welcomeWindow.getContentPane().add(lblCrew_2, "cell 2 5");
		
		JLabel lblCrew_3 = new JLabel("Crew 4:");
		lblCrew_3.setFont(new Font("Dialog", Font.BOLD, 14));
		welcomeWindow.getContentPane().add(lblCrew_3, "cell 3 5");
		
		JComboBox<Object> comboCrew1 = new JComboBox<Object>();
		comboCrew1.setFont(new Font("Dialog", Font.BOLD, 14));
		comboCrew1.setModel(new DefaultComboBoxModel<Object>(new String[] {"Pilot", "Engineer", "Medic", "Merchant", "Guard", "GOAT"}));
		welcomeWindow.getContentPane().add(comboCrew1, "cell 0 6,growx");
		
		JComboBox<Object> comboCrew2 = new JComboBox<Object>();
		comboCrew2.setFont(new Font("Dialog", Font.BOLD, 14));
		comboCrew2.setModel(new DefaultComboBoxModel<Object>(new String[] {"Pilot", "Engineer", "Medic", "Merchant", "Guard", "GOAT"}));
		welcomeWindow.getContentPane().add(comboCrew2, "cell 1 6,growx");
		
		JComboBox<Object> comboCrew3 = new JComboBox<Object>();
		comboCrew3.setFont(new Font("Dialog", Font.BOLD, 14));
		comboCrew3.setModel(new DefaultComboBoxModel(new String[] { "Dead", "Pilot", "Engineer", "Medic", "Merchant", "Guard", "GOAT"}));
		welcomeWindow.getContentPane().add(comboCrew3, "cell 2 6,growx");
		
		JComboBox<Object> comboCrew4 = new JComboBox<Object>();
		comboCrew4.setFont(new Font("Dialog", Font.BOLD, 14));
		comboCrew4.setModel(new DefaultComboBoxModel(new String[] { "Dead", "Pilot", "Engineer", "Medic", "Merchant", "Guard", "GOAT"}));
		welcomeWindow.getContentPane().add(comboCrew4, "cell 3 6,growx");
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Dialog", Font.BOLD, 14));
		welcomeWindow.getContentPane().add(lblName, "flowx,cell 0 7");
		
		txtCrew1 = new JTextField();
		txtCrew1.setText("Unknown");
		welcomeWindow.getContentPane().add(txtCrew1, "cell 0 7");
		txtCrew1.setColumns(10);
		
		JLabel label = new JLabel("Name:");
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		welcomeWindow.getContentPane().add(label, "flowx,cell 1 7");
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		welcomeWindow.getContentPane().add(label_1, "flowx,cell 2 7");
		
		JLabel label_2 = new JLabel("Name:");
		label_2.setFont(new Font("Dialog", Font.BOLD, 14));
		welcomeWindow.getContentPane().add(label_2, "flowx,cell 3 7");
		
		txtCrew2 = new JTextField();
		txtCrew2.setText("Unknown");
		txtCrew2.setColumns(10);
		welcomeWindow.getContentPane().add(txtCrew2, "cell 1 7");
		
		txtCrew3 = new JTextField();
		txtCrew3.setText("Unknown");
		txtCrew3.setColumns(10);
		welcomeWindow.getContentPane().add(txtCrew3, "cell 2 7");
		
		txtCrew4 = new JTextField();
		txtCrew4.setText("Unknown");
		txtCrew4.setColumns(10);
		welcomeWindow.getContentPane().add(txtCrew4, "cell 3 7");
		
		JLabel lblShipName = new JLabel("Ship Name:");
		lblShipName.setFont(new Font("Dialog", Font.BOLD, 14));
		welcomeWindow.getContentPane().add(lblShipName, "flowx,cell 0 9");
		
		
		
		
		
		JButton btnStartGame = new JButton("Start Game"); //Action when Start Game Button is Pressed
		btnStartGame.setFont(new Font("Dialog", Font.BOLD, 14));
		btnStartGame.setBackground(Color.ORANGE);
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Game.Days = (int) comboBox.getSelectedItem();
				c1Type = (String) comboCrew1.getSelectedItem();
				c1Name = txtCrew1.getText();
				c2Type = (String) comboCrew2.getSelectedItem();
				c2Name = txtCrew2.getText();
				c3Type = (String) comboCrew3.getSelectedItem();
				c3Name = txtCrew3.getText();
				c4Type = (String) comboCrew4.getSelectedItem();
				c4Name = txtCrew4.getText();
				//Game.Our_ship.setName(txtStarship.getText());
				shipName = txtStarship.getText();
				
				
				
				//System.out.println(Game.Our_ship.getName());
				
				Game.setup();
				manager.launchShip();
				closeWindow();
			}
		});
		
		
		welcomeWindow.getContentPane().add(btnStartGame, "cell 3 9,grow");
		txtStarship = new JTextField();
		txtStarship.setText("The Starship");
		welcomeWindow.getContentPane().add(txtStarship, "cell 0 9");
		txtStarship.setColumns(10);
		
	}

}
