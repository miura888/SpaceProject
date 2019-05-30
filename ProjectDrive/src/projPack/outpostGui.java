package projPack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class outpostGui {

	private JFrame outpostWindow;
	private Game manager;
	static JComboBox medSellBox;
	static JComboBox foodSellBox;
	static JLabel outpostMoney;
	static JLabel outpostDialog;
	private JTable table;
	private JTable table_1;
	
	
	public outpostGui(Game incomingManager) {
		manager = incomingManager;
		initialize();
		outpostWindow.setVisible(true);
	}
	public void closeWindow() {
		outpostWindow.dispose();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					outpostGui window = new outpostGui();
					window.outpostWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public outpostGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		outpostWindow = new JFrame();
		outpostWindow.setTitle("Outpost");
		outpostWindow.setBounds(100, 100, 1139, 504);
		outpostWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		outpostWindow.getContentPane().setLayout(new MigLayout("", "[168.00][193.00][66.00][168.00][165.00]", "[64.00][43.00][45.00][35.00][86.00][59.00]"));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Apple: $8"},
				{"Banana: $12"},
				{"Muffin: $24"},
				{"Burger: $32"},
				{"Steak: $64"},
				{"Roast Pork: $88"},
			},
			new String[] {
				"New column"
			}
		));
		outpostWindow.getContentPane().add(table, "cell 3 4,grow");
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Vitamins: $4"},
				{"Pain Killers: $12"},
				{"First Aid Kit: $24"},
				{"Plague Medicine: $24"},
			},
			new String[] {
				"New column"
			}
		));
		outpostWindow.getContentPane().add(table_1, "cell 4 4,grow");
		
		outpostDialog = new JLabel("Buy or Sell Goods");
		outpostWindow.getContentPane().add(outpostDialog, "cell 0 5 5 1,alignx center");
		
		outpostMoney = new JLabel("$ " + Game.money);
		outpostWindow.getContentPane().add(outpostMoney, "cell 0 0");
		
		JLabel lblNewLabel = new JLabel("Welcome to the Outpost");
		outpostWindow.getContentPane().add(lblNewLabel, "cell 1 0 3 1,alignx center,aligny center");
		
		JLabel lblBuy = new JLabel("Buy Food");
		outpostWindow.getContentPane().add(lblBuy, "cell 0 1,alignx center");
		
		JLabel lblSell = new JLabel("Buy Medical");
		outpostWindow.getContentPane().add(lblSell, "cell 1 1,alignx center");
		
		JLabel lblSellFood = new JLabel("Sell Food");
		outpostWindow.getContentPane().add(lblSellFood, "cell 3 1");
		
		JLabel lblSellMedical = new JLabel("Sell Medical");
		outpostWindow.getContentPane().add(lblSellMedical, "cell 4 1");
		
		JComboBox foodBuyBox = new JComboBox();
		foodBuyBox.setModel(new DefaultComboBoxModel(new String[] {"Apple: $10", "Banana: $15", "Muffin: $30", "Burger: $40", "Steak: $80", "Roast Pork: $110"}));
		outpostWindow.getContentPane().add(foodBuyBox, "cell 0 2,growx");
		
		JComboBox medBuyBox = new JComboBox();
		medBuyBox.setModel(new DefaultComboBoxModel(new String[] {"Vitamins: $5", "Pain Killers: $15", "First Aid Kit: $30", "Space Plague Medicine: $30"}));
		outpostWindow.getContentPane().add(medBuyBox, "cell 1 2,growx");
		
		JButton btnBackToShip = new JButton("Back to Ship");
		btnBackToShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeWindow();
				shipGui.CrewUpdater();
			}
		});
		
		foodSellBox = new JComboBox();
		ArrayList<String> FoodNames = new ArrayList<String>();
		for (int i = 0; i < Game.Food.size(); i++) {
			FoodNames.add(Game.Food.get(i).getName());
		}
		foodSellBox.setModel(new DefaultComboBoxModel(FoodNames.toArray()));
		outpostWindow.getContentPane().add(foodSellBox, "cell 3 2,growx");
		
		medSellBox = new JComboBox();
		ArrayList<String> MedicalNames = new ArrayList<String>();
		for (int i = 0; i < Game.Medical.size(); i++) {
			MedicalNames.add(Game.Medical.get(i).getName());
		}
		medSellBox.setModel(new DefaultComboBoxModel(MedicalNames.toArray()));
		outpostWindow.getContentPane().add(medSellBox, "cell 4 2,growx");
		
		JButton foodBuyButton = new JButton("Buy");
		foodBuyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = foodBuyBox.getSelectedIndex();
				FoodItems F = new FoodItems(index+1);
				if (F.getPrice() <= Game.money) {
					Game.Food.add(F);
					Game.money -= F.getPrice();
					outpostDialog.setText(F.getName() + " was added to the inventory");
				}
				outpostUpdater();
			}
		});
		outpostWindow.getContentPane().add(foodBuyButton, "cell 0 3");
		
		JButton medBuyButton = new JButton("Buy");
		medBuyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = medBuyBox.getSelectedIndex();
				MedicalItems M = new MedicalItems(index+1);
				if (M.getPrice() <= Game.money) {
					Game.Medical.add(M);
					Game.money -= M.getPrice();
					outpostDialog.setText(M.getName() + " was added to the inventory");
				}
				outpostUpdater();
			}
		});
		outpostWindow.getContentPane().add(medBuyButton, "cell 1 3");
		
		JButton foodSellButton = new JButton("Sell");
		foodSellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Game.Food.size() > 0) {
					int index = foodSellBox.getSelectedIndex();
					System.out.println(index);
					Game.money += 0.8 * Game.Food.get(index).getPrice();
					outpostDialog.setText(Game.Food.get(index).getName() + " was sold");
					Game.Food.remove(index);
					outpostUpdater();
				} else {
					outpostDialog.setText("No food to sell");
				}
			}
		});
		outpostWindow.getContentPane().add(foodSellButton, "cell 3 3");
		
		JButton medSellButton = new JButton("Sell");
		medSellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Game.Medical.size() > 0) {
					int index = medSellBox.getSelectedIndex();
					System.out.println(index);
					Game.money += 0.8 * Game.Medical.get(index).getPrice();
					outpostDialog.setText(Game.Medical.get(index).getName() + " was sold");
					Game.Medical.remove(index);
					outpostUpdater();
				} else {
					outpostDialog.setText("No Medicine to sell");
				}
			}
		});
		outpostWindow.getContentPane().add(medSellButton, "cell 4 3");
		
		
		outpostWindow.getContentPane().add(btnBackToShip, "cell 0 4");
		
	}
	
	public static void outpostUpdater() {
		//Food Array
		ArrayList<String> FoodNames = new ArrayList<String>();
		for (int i = 0; i < Game.Food.size(); i++) {
			FoodNames.add(Game.Food.get(i).getName());
		}
		foodSellBox.setModel(new DefaultComboBoxModel(FoodNames.toArray()));
		
		//Medical Array
		ArrayList<String> MedicalNames = new ArrayList<String>();
		for (int i = 0; i < Game.Medical.size(); i++) {
			MedicalNames.add(Game.Medical.get(i).getName());
		}
		medSellBox.setModel(new DefaultComboBoxModel(MedicalNames.toArray()));
		
		//money
		outpostMoney.setText("$" + Game.money);
		//outpostDialog.setText()
	}
	

}
