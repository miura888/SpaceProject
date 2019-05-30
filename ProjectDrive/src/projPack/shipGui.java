package projPack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractButton;
import javax.swing.AbstractListModel;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;

public class shipGui {
	
	private Game manager;
	private static JFrame shipWindow;
	
	public static String outsideText = "";
	static JLabel gameDialog;
	static JLabel actions1;
	static JLabel actions2;
	static JLabel actions3;
	static JLabel actions4;
	static JLabel plagueLabel1;
	static JLabel plagueLabel2;
	static JLabel plagueLabel3;
	static JLabel plagueLabel4;
	static JComboBox foodInventory;
	public static JProgressBar hungerBar1; public static JProgressBar hungerBar2; public static JProgressBar hungerBar3; public static JProgressBar hungerBar4;
	static JComboBox medicalInventory;
	public static JProgressBar healthBar1; public static JProgressBar healthBar2; public static JProgressBar healthBar3; public static JProgressBar healthBar4;
	public static JProgressBar fatigueBar1; public static JProgressBar fatigueBar2; public static JProgressBar fatigueBar3; public static JProgressBar fatigueBar4;
	public static JProgressBar shieldLevel;
	public static JLabel currentMoney;
	public static JLabel dayLabel;
	public static JLabel partLabel;
	private static final ButtonGroup crew1Group = new ButtonGroup();
	private static final ButtonGroup crew2Group = new ButtonGroup();
	private static final ButtonGroup crew3Group = new ButtonGroup();
	private static final ButtonGroup crew4Group = new ButtonGroup();

		
	
	public shipGui(Game incomingManager) {
		manager = incomingManager;
		initialize();
		shipWindow.setVisible(true);
	}
	public static void closeWindow() {
		shipWindow.dispose();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shipGui window = new shipGui();
					window.shipWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**		shipGui.outsideText = "You have have traveled to a New planet";
	 * Create the application.
	 */
	public shipGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		shipWindow = new JFrame();
		shipWindow.setTitle("Ship");
		shipWindow.setBounds(100, 100, 912, 536);
		shipWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		shipWindow.getContentPane().setLayout(new MigLayout("", "[:120:350px,grow,center][120,grow,center][120,grow,center][120,grow,center][120,grow,center]", "[30][30,grow][30][30][30,fill][30,fill][30,fill][30][30][30,grow][30,grow][grow,fill][30,grow][30,grow][60]"));
		
		gameDialog = new JLabel("You must find " + Game.numPieces + " parts for " + Game.ourShip.getName() + " in " + Game.Days);
		gameDialog.setFont(new Font("Dialog", Font.BOLD, 16));
		shipWindow.getContentPane().add(gameDialog, "cell 0 14 5 1");
		
		dayLabel = new JLabel("Day: " + Game.currentDay + "/" + Game.Days);
		dayLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(dayLabel, "cell 0 0");
		
		JLabel lblShipName = new JLabel(Game.ourShip.getName());
		lblShipName.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(lblShipName, "cell 1 0");
		
		partLabel = new JLabel(Game.currentPieces + "/" + Game.numPieces + " parts found");
		partLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(partLabel, "cell 2 0");
		
		JLabel lblShieldLevel = new JLabel("Shield Level:");
		lblShieldLevel.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(lblShieldLevel, "flowx,cell 3 0,alignx right");
		
		shieldLevel = new JProgressBar();
		shieldLevel.setMinimum(0);
		shieldLevel.setMaximum(Game.ourShip.getShield());
		shieldLevel.setValue(Game.ourShip.getShield());
		shieldLevel.setForeground(Color.ORANGE);
		shieldLevel.setFont(new Font("Dialog", Font.BOLD, 14));
		shieldLevel.setBackground(Color.GRAY);
		shieldLevel.setStringPainted(true);
		shipWindow.getContentPane().add(shieldLevel, "cell 4 0,grow");
		
		currentMoney = new JLabel("$"+String.valueOf(Game.money));
		currentMoney.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(currentMoney, "cell 0 1");
		
		JButton btnOutpost = new JButton("Outpost");
		btnOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchOutpost();
			}
		});
		btnOutpost.setFont(new Font("Dialog", Font.BOLD, 18));
		btnOutpost.setForeground(SystemColor.text);
		btnOutpost.setBackground(SystemColor.activeCaption);
		shipWindow.getContentPane().add(btnOutpost, "cell 2 1,grow");
		
		JButton btnTravel = new JButton("Travel");
		btnTravel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchTravel();
				
			}
		});
		btnTravel.setFont(new Font("Dialog", Font.BOLD, 18));
		btnTravel.setForeground(SystemColor.text);
		btnTravel.setBackground(SystemColor.activeCaption);
		shipWindow.getContentPane().add(btnTravel, "cell 3 1,grow");
		
		JButton btnEndDay = new JButton("End Day");
		btnEndDay.setFont(new Font("Dialog", Font.BOLD, 18));
		btnEndDay.setForeground(SystemColor.text);
		btnEndDay.setBackground(SystemColor.activeCaption);
		
		shipWindow.getContentPane().add(btnEndDay, "cell 4 1,grow");
		
		JLabel lblName = new JLabel(Game.Crew.get(0).getName());
		lblName.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(lblName, "cell 1 2");
		
		JLabel lblName_1 = new JLabel(Game.Crew.get(1).getName());
		lblName_1.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(lblName_1, "cell 2 2");
		
		JLabel lblName_2 = new JLabel(Game.Crew.get(2).getName());
		lblName_2.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(lblName_2, "cell 3 2");
		
		JLabel lblName_3 = new JLabel(Game.Crew.get(3).getName());
		lblName_3.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(lblName_3, "cell 4 2");
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(lblType, "cell 0 3");
		
		JLabel label_7 = new JLabel(Game.Crew.get(0).getType());
		label_7.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(label_7, "cell 1 3");
		
		JLabel label_8 = new JLabel(Game.Crew.get(1).getType());
		label_8.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(label_8, "cell 2 3");
		
		JLabel label_9 = new JLabel(Game.Crew.get(2).getType());
		label_9.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(label_9, "cell 3 3");
		
		JLabel label_10 = new JLabel(Game.Crew.get(3).getType());
		label_10.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(label_10, "cell 4 3");
		
		JLabel lblHealth = new JLabel("Health");
		lblHealth.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(lblHealth, "cell 0 4");
		
		healthBar1 = new JProgressBar();
		healthBar1.setValue(Game.Crew.get(0).getHealth());
		healthBar1.setMaximum(Game.Crew.get(0).getHealth());
		healthBar1.setStringPainted(true);
		healthBar1.setValue(Game.Crew.get(0).getHealth()); //Should this be coming from Game or is is it ag to just have it in the gui?
		healthBar1.setForeground(Color.RED); //setValue(Game.Crew.get(0).getHealth())
		healthBar1.setBackground(Color.WHITE);
		shipWindow.getContentPane().add(healthBar1, "cell 1 4,grow");
		
		healthBar2 = new JProgressBar();
		healthBar2.setValue(Game.Crew.get(1).getHealth());
		healthBar2.setMaximum(Game.Crew.get(1).getHealth());
		healthBar2.setStringPainted(true);
		healthBar2.setForeground(Color.RED);
		healthBar2.setBackground(Color.WHITE);
		shipWindow.getContentPane().add(healthBar2, "cell 2 4,growx");
		
		healthBar3 = new JProgressBar();
		healthBar3.setValue(Game.Crew.get(2).getHealth());
		healthBar3.setMaximum(Game.Crew.get(2).getHealth());
		healthBar3.setStringPainted(true);
		healthBar3.setForeground(Color.RED);
		healthBar3.setBackground(Color.WHITE);
		shipWindow.getContentPane().add(healthBar3, "cell 3 4,growx");
		
		healthBar4 = new JProgressBar();
		healthBar4.setValue(Game.Crew.get(3).getHealth());
		healthBar4.setMaximum(Game.Crew.get(3).getHealth());
		healthBar4.setStringPainted(true);
		healthBar4.setForeground(Color.RED);
		healthBar4.setBackground(Color.WHITE);
		shipWindow.getContentPane().add(healthBar4, "cell 4 4,growx");
		
		JLabel lblHunger = new JLabel("Hunger");
		lblHunger.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(lblHunger, "cell 0 5");
		
		hungerBar1 = new JProgressBar();
		hungerBar1.setMaximum(Game.Crew.get(0).getHunger());
		hungerBar1.setMinimum(0);
		hungerBar1.setValue(Game.Crew.get(0).getHunger());
		hungerBar1.setStringPainted(true);
		hungerBar1.setForeground(Color.GREEN);
		hungerBar1.setBackground(Color.WHITE);
		shipWindow.getContentPane().add(hungerBar1, "cell 1 5,growx");
		
		hungerBar2 = new JProgressBar();
		hungerBar2.setMaximum(Game.Crew.get(1).getHunger());
		hungerBar2.setMinimum(0);
		hungerBar2.setValue(Game.Crew.get(1).getHunger());
		hungerBar2.setStringPainted(true);
		hungerBar2.setForeground(Color.GREEN);
		hungerBar2.setBackground(Color.WHITE);
		shipWindow.getContentPane().add(hungerBar2, "cell 2 5,growx");
		
		hungerBar3 = new JProgressBar();
		hungerBar3.setMaximum(Game.Crew.get(2).getHunger());
		hungerBar3.setMinimum(0);
		hungerBar3.setValue(Game.Crew.get(2).getHunger());
		hungerBar3.setStringPainted(true);
		hungerBar3.setForeground(Color.GREEN);
		hungerBar3.setBackground(Color.WHITE);
		shipWindow.getContentPane().add(hungerBar3, "cell 3 5,growx");
		
		hungerBar4 = new JProgressBar();
		hungerBar4.setMaximum(Game.Crew.get(3).getHunger());
		hungerBar4.setMinimum(0);
		hungerBar4.setValue(Game.Crew.get(3).getHunger());
		hungerBar4.setStringPainted(true);
		hungerBar4.setForeground(Color.GREEN);
		hungerBar4.setBackground(Color.WHITE);
		shipWindow.getContentPane().add(hungerBar4, "cell 4 5,growx");
		
		JLabel lblFatigue = new JLabel("Fatigue");
		lblFatigue.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(lblFatigue, "cell 0 6");
		
		fatigueBar1 = new JProgressBar();
		fatigueBar1.setMaximum(Game.Crew.get(0).getTired());
		fatigueBar1.setValue(Game.Crew.get(0).getTired());
		fatigueBar1.setStringPainted(true);
		fatigueBar1.setForeground(Color.BLUE);
		fatigueBar1.setBackground(Color.WHITE);
		shipWindow.getContentPane().add(fatigueBar1, "cell 1 6,growx");
		
		fatigueBar2 = new JProgressBar();
		fatigueBar2.setMaximum(Game.Crew.get(1).getTired());
		fatigueBar2.setValue(Game.Crew.get(1).getTired());
		fatigueBar2.setStringPainted(true);
		fatigueBar2.setForeground(Color.BLUE);
		fatigueBar2.setBackground(Color.WHITE);
		shipWindow.getContentPane().add(fatigueBar2, "cell 2 6,growx");
		
		fatigueBar3 = new JProgressBar();
		fatigueBar3.setMaximum(Game.Crew.get(2).getTired());
		fatigueBar3.setValue(Game.Crew.get(2).getTired());
		fatigueBar3.setStringPainted(true);
		fatigueBar3.setForeground(Color.BLUE);
		fatigueBar3.setBackground(Color.WHITE);
		shipWindow.getContentPane().add(fatigueBar3, "cell 3 6,growx");
		
		fatigueBar4 = new JProgressBar();
		fatigueBar4.setMaximum(Game.Crew.get(3).getTired());
		fatigueBar4.setValue(Game.Crew.get(3).getTired());
		fatigueBar4.setStringPainted(true);
		fatigueBar4.setForeground(Color.BLUE);
		fatigueBar4.setBackground(Color.WHITE);
		shipWindow.getContentPane().add(fatigueBar4, "cell 4 6,growx");
		
		JLabel lblSpacePlague = new JLabel("Space Plague");
		lblSpacePlague.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(lblSpacePlague, "cell 0 7");
		
		plagueLabel1 = new JLabel("No");
		plagueLabel1.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(plagueLabel1, "cell 1 7");
		
		plagueLabel2 = new JLabel("No");
		plagueLabel2.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(plagueLabel2, "cell 2 7");
		
		plagueLabel3 = new JLabel("No");
		plagueLabel3.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(plagueLabel3, "cell 3 7");
		
		plagueLabel4 = new JLabel("No");
		plagueLabel4.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(plagueLabel4, "cell 4 7");
		
		JLabel lblActionsRemaining = new JLabel("Actions");
		lblActionsRemaining.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(lblActionsRemaining, "cell 0 8");
		
		actions1 = new JLabel (Game.Crew.get(0).GetActionS());
		actions1.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(actions1, "cell 1 8");
		
		actions2 = new JLabel(Game.Crew.get(1).GetActionS());
		actions2.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(actions2, "cell 2 8");
		
		actions3 = new JLabel(Game.Crew.get(2).GetActionS());
		actions3.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(actions3, "cell 3 8");
		
		actions4 = new JLabel(Game.Crew.get(3).GetActionS());
		actions4.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(actions4, "cell 4 8");
		
		JButton btnSearchPlanet = new JButton("Search Planet");
		crew1Group.add(btnSearchPlanet);
		btnSearchPlanet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.SearchPlanet(0);
			}
		});
		btnSearchPlanet.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(btnSearchPlanet, "cell 1 9,grow");
		
		JButton button = new JButton("Search Planet");
		crew2Group.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.SearchPlanet(1);
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(button, "cell 2 9,grow");
		
		JButton button_1 = new JButton("Search Planet");
		crew3Group.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.SearchPlanet(2);
				
				//CrewUpdater();
			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(button_1, "cell 3 9,grow");
		
		JButton button_2 = new JButton("Search Planet");
		crew4Group.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.SearchPlanet(3);
			}
		});
		button_2.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(button_2, "cell 4 9,grow");
		
		foodInventory = new JComboBox();
		foodInventory.setFont(new Font("Dialog", Font.BOLD, 14));
		foodInventory.setToolTipText("Consume this item to gain x health");
		
		ArrayList<String> FoodNames = new ArrayList<String>();
		for (int i = 0; i < Game.Food.size(); i++) {
			FoodNames.add(Game.Food.get(i).getName());
		}
		
		JLabel lblNewLabel = new JLabel("Food Inventory");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		shipWindow.getContentPane().add(lblNewLabel, "flowy,cell 0 10");
		
		JSeparator separator_1 = new JSeparator();
		shipWindow.getContentPane().add(separator_1, "cell 0 10");
		foodInventory.setModel(new DefaultComboBoxModel(FoodNames.toArray()));
		shipWindow.getContentPane().add(foodInventory, "cell 0 10,grow");
		

		JButton eat1 = new JButton("Eat Food");
		crew1Group.add(eat1);
		eat1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Game.Food.size() > 0) {
					int index = foodInventory.getSelectedIndex();
					System.out.println(index);
					
					Game.UseItems(index, 0, 1);
					hungerBar1.setValue(Game.Crew.get(0).getHunger());
				}
				
				else {
					gameDialog.setText("No items to consume");
					
				}
				
				
			}
		});
		eat1.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(eat1, "cell 1 10,grow");
		
		
		JButton eat2 = new JButton("Eat Food");
		crew2Group.add(eat2);
		eat2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Game.Food.size() > 0) {
					int index = foodInventory.getSelectedIndex();
					System.out.println(index);
					
					Game.UseItems(index, 1, 1);
					hungerBar2.setValue(Game.Crew.get(1).getHunger());
				}
				
				else {
					gameDialog.setText("No items to consume");
					
				}
				
			}
		});
		eat2.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(eat2, "cell 2 10,grow");
		
		JButton eat3 = new JButton("Eat Food");
		crew3Group.add(eat3);
		eat3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Game.Food.size() > 0) {
					int index = foodInventory.getSelectedIndex();
					System.out.println(index);
					
					Game.UseItems(index, 2, 1);
					hungerBar3.setValue(Game.Crew.get(2).getHunger());
				}
				
				else {
					gameDialog.setText("No items to consume");
					
				}
			}
		});
		eat3.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(eat3, "cell 3 10,grow");
		
		JButton eat4 = new JButton("Eat Food");
		crew4Group.add(eat4);
		eat4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Game.Food.size() > 0) {
					int index = foodInventory.getSelectedIndex();
					System.out.println(index);
					
					Game.UseItems(index, 3, 1);
					hungerBar4.setValue(Game.Crew.get(3).getHunger());
				}
				
				else {
					gameDialog.setText("No items to consume");
					
				}
			}
		});
		eat4.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(eat4, "cell 4 10,grow");
		
		
		
		medicalInventory = new JComboBox();
		medicalInventory.setFont(new Font("Dialog", Font.BOLD, 14));
		ArrayList<String> MedicalNames = new ArrayList<String>();
		for (int i = 0; i < Game.Medical.size(); i++) {
			MedicalNames.add(Game.Medical.get(i).getName());
		}
		
		JSeparator separator = new JSeparator();
		shipWindow.getContentPane().add(separator, "flowy,cell 0 11");
		
		JLabel lblNewLabel_1 = new JLabel("Medical Inventory");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		shipWindow.getContentPane().add(lblNewLabel_1, "cell 0 11");
		medicalInventory.setModel(new DefaultComboBoxModel(MedicalNames.toArray()));
		shipWindow.getContentPane().add(medicalInventory, "cell 0 11,growx");
		
		
		JButton btnUseMedical = new JButton("Use Medical");
		crew1Group.add(btnUseMedical);
		btnUseMedical.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Game.Medical.size() > 0) {
					int index = medicalInventory.getSelectedIndex();
					System.out.println(index);
					
					Game.UseItems(index, 0, 2);
					healthBar1.setValue(Game.Crew.get(0).getHealth());
				}
				
				else {
					gameDialog.setText("No items to consume");
					
				}
				
			}
		});
		btnUseMedical.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(btnUseMedical, "cell 1 11,growx");
		
		JButton btnUseMedical_1 = new JButton("Use Medical");
		crew2Group.add(btnUseMedical_1);
		btnUseMedical_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Game.Medical.size() > 0) {
					int index = medicalInventory.getSelectedIndex();
					System.out.println(index);
					
					Game.UseItems(index, 1, 2);
					healthBar2.setValue(Game.Crew.get(1).getHealth());
				}
				
				else {
					gameDialog.setText("No items to consume");
					
				}
			}
		});
		btnUseMedical_1.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(btnUseMedical_1, "cell 2 11,growx");
		
		JButton btnUseMedical_2 = new JButton("Use Medical");
		crew3Group.add(btnUseMedical_2);
		btnUseMedical_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Game.Medical.size() > 0) {
					int index = medicalInventory.getSelectedIndex();
					System.out.println(index);
					
					Game.UseItems(index, 2, 2);
					healthBar3.setValue(Game.Crew.get(2).getHealth());
				}
				
				else {
					gameDialog.setText("No items to consume");
					
				}
			}
		});
		btnUseMedical_2.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(btnUseMedical_2, "cell 3 11,growx");
		
		JButton btnUseMedical_3 = new JButton("Use Medical");
		crew4Group.add(btnUseMedical_3);
		btnUseMedical_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Game.Medical.size() > 0) {
					int index = medicalInventory.getSelectedIndex();
					System.out.println(index);
					
					Game.UseItems(index, 3, 2);
					healthBar4.setValue(Game.Crew.get(3).getHealth());
				}
				
				else {
					gameDialog.setText("No items to consume");
					
				}
			}
		});
		btnUseMedical_3.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(btnUseMedical_3, "cell 4 11,growx");
		
		
		JButton repairShields1 = new JButton("Repair Shields");
		crew1Group.add(repairShields1);
		repairShields1.setFont(new Font("Dialog", Font.BOLD, 18));
		repairShields1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.repairShield(0);
			}
				
		});
		
		shipWindow.getContentPane().add(repairShields1, "cell 1 12,grow");
		
		JButton repairShields2 = new JButton("Repair Shields");
		crew2Group.add(repairShields2);
		repairShields2.setFont(new Font("Dialog", Font.BOLD, 18));
		repairShields2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.repairShield(1);
			}
		});
		shipWindow.getContentPane().add(repairShields2, "cell 2 12,grow");
		
		JButton repairShields3 = new JButton("Repair Shields");
		crew3Group.add(repairShields3);
		repairShields3.setFont(new Font("Dialog", Font.BOLD, 18));
		repairShields3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.repairShield(2);
			}
		});
		shipWindow.getContentPane().add(repairShields3, "cell 3 12,grow");
		
		JButton repairShields4 = new JButton("Repar Shields");
		crew4Group.add(repairShields4);
		repairShields4.setFont(new Font("Dialog", Font.BOLD, 18));
		repairShields4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.repairShield(3);
			}
			
		});
		shipWindow.getContentPane().add(repairShields4, "cell 4 12,grow");
		
		JButton sleep1 = new JButton("Sleep");
		crew1Group.add(sleep1);
		sleep1.setFont(new Font("Dialog", Font.BOLD, 18));
		sleep1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.sleep(0);
			}
		});
		shipWindow.getContentPane().add(sleep1, "cell 1 13,grow");
		
		JButton sleep2 = new JButton("Sleep");
		crew2Group.add(sleep2);
		sleep2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.sleep(1);
			}
		});
		sleep2.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(sleep2, "cell 2 13,grow");
		
		JButton sleep3 = new JButton("Sleep");
		crew3Group.add(sleep3);
		sleep3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.sleep(2);
			}
		});
		sleep3.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(sleep3, "cell 3 13,grow");
		
		JButton sleep4 = new JButton("Sleep");
		crew4Group.add(sleep4);
		sleep4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.sleep(3);
			}
		});
		sleep4.setFont(new Font("Dialog", Font.BOLD, 18));
		shipWindow.getContentPane().add(sleep4, "cell 4 13,grow");
		
		
	
		btnEndDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Game.newDayEvent();
				actions1.setText("2"); actions2.setText("2"); actions3.setText("2"); actions4.setText("2");
				Game.Crew.get(0).setHunger(-20);
				Game.Crew.get(1).setHunger(-20);
				Game.Crew.get(2).setHunger(-20);
				Game.Crew.get(3).setHunger(-20);
				Game.Crew.get(0).setTired(-20); Game.Crew.get(1).setTired(-20); Game.Crew.get(2).setTired(-20); Game.Crew.get(3).setTired(-20);
				Game.newDayEvent();
				
				
				//Random Event()
				//gameDialog.setText("Space Pirates Attack! " + randomItem + " was stolen from the ships inventory");
				//randomEvent.setText("Space Plague! " + Crew Members + " were infected by Space Plague");
				//randomEvent.setText("It was a Stress Free Night");
			
				//if (Game.currentDay > Game.Days) {
//					//End the Game closeWindow()
//				}
			}
		});
	}
	
	public static void CrewUpdater() {
		//end conditions
		Game.endConditions();
		
		//Dead Crew
		for (int i = 0; i < Game.Crew.size(); i++) {
			if (Game.Crew.get(i).getHealth() <= 0) {
				Game.Crew.set(i,new CrewMember(Game.Crew.get(i).getName(), "Dead"));
				}
			if (Game.Crew.get(i).getType() == "Dead") {
				if (i == 0) {
					Enumeration<AbstractButton> enumeration = crew1Group.getElements();
					while (enumeration.hasMoreElements()) {
					    enumeration.nextElement().setEnabled(false);
					}}
				 else if (i == 1){
					Enumeration<AbstractButton> enumeration = crew2Group.getElements();
					while (enumeration.hasMoreElements()) {
					    enumeration.nextElement().setEnabled(false);
					}}
				 else if (i == 2) {
					Enumeration<AbstractButton> enumeration = crew3Group.getElements();
					while (enumeration.hasMoreElements()) {
					    enumeration.nextElement().setEnabled(false);
					}}
				 else if (i == 3) {
					Enumeration<AbstractButton> enumeration = crew4Group.getElements();
					while (enumeration.hasMoreElements()) {
					    enumeration.nextElement().setEnabled(false);
			}
		}
		}
		}
		
		//Food Array
		ArrayList<String> FoodNames = new ArrayList<String>();
		for (int i = 0; i < Game.Food.size(); i++) {
			FoodNames.add(Game.Food.get(i).getName());
		}
		foodInventory.setModel(new DefaultComboBoxModel(FoodNames.toArray()));
		//Medical Array
		ArrayList<String> MedicalNames = new ArrayList<String>();
		for (int i = 0; i < Game.Medical.size(); i++) {
			MedicalNames.add(Game.Medical.get(i).getName());
		}
		medicalInventory.setModel(new DefaultComboBoxModel(MedicalNames.toArray()));
		//Money
		//Outside text
		gameDialog.setText(outsideText);
		actions1.setText(Game.Crew.get(0).GetActionS());
		actions2.setText(Game.Crew.get(1).GetActionS());
		actions3.setText(Game.Crew.get(2).GetActionS());
		actions4.setText(Game.Crew.get(3).GetActionS());
		
		//Space plague
		if (Game.Crew.get(0).getPlague() == true) {
			plagueLabel1.setText("Yes");
		} else {
			plagueLabel1.setText("No");
		}
		if (Game.Crew.get(1).getPlague() == true) {
			plagueLabel2.setText("Yes");
		} else {
			plagueLabel2.setText("No");
		}
		if (Game.Crew.get(2).getPlague() == true) {
			plagueLabel3.setText("Yes");
		} else {
			plagueLabel3.setText("No");
		}
		if (Game.Crew.get(3).getPlague() == true) {
			plagueLabel4.setText("Yes");
		} else {
			plagueLabel4.setText("No");
		}
		
		//Fatigue
		fatigueBar1.setValue(Game.Crew.get(0).getTired());
		fatigueBar2.setValue(Game.Crew.get(1).getTired());
		fatigueBar3.setValue(Game.Crew.get(2).getTired());
		fatigueBar4.setValue(Game.Crew.get(3).getTired());
		
		//health
		healthBar1.setValue(Game.Crew.get(0).getHealth());
		healthBar2.setValue(Game.Crew.get(1).getHealth());
		healthBar3.setValue(Game.Crew.get(2).getHealth());
		healthBar4.setValue(Game.Crew.get(3).getHealth());
		
		//hunger
		hungerBar1.setValue(Game.Crew.get(0).getHunger());
		hungerBar2.setValue(Game.Crew.get(1).getHunger());
		hungerBar3.setValue(Game.Crew.get(2).getHunger());
		hungerBar4.setValue(Game.Crew.get(3).getHunger());
		
		//shield
		shieldLevel.setValue(Game.ourShip.getShield());
		
		//money
		currentMoney.setText("$" + Game.money);
		
		//days
		dayLabel.setText("Day: " + Game.currentDay + "/" + Game.Days);
		
		//Parts
		partLabel.setText(Game.currentPieces + "/" + Game.numPieces + " parts found");
	}
}

