package projPack;
import java.util.Scanner;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Random;

public class Game {
	public static int Days;
	public static int currentDay;
	public static int numPieces;
	public static int currentPieces;
	public static int money = 100;
	public static Boolean piece_flag;
	public static ArrayList<CrewMember> Crew;
	public static ship ourShip;
	public static ArrayList<FoodItems> Food;
	public static ArrayList<MedicalItems> Medical;
	public static Game manager;
	public static double score;
	
	public static void setup() {
		money = 100;
		piece_flag = false;
		currentPieces = 0;
		Crew = new ArrayList<CrewMember>();
		Food = new ArrayList<FoodItems>();
		Medical = new ArrayList<MedicalItems>();
		currentDay = 1;
		FoodItems B = new FoodItems(2);
		Food.add(B);
		FoodItems A = new FoodItems(1);
		Food.add(A);
		MedicalItems X = new MedicalItems(2);
		Medical.add(X);
		MedicalItems Y = new MedicalItems(1);
		Medical.add(Y);
		numPieces = ((2*Days) /3);
		System.out.println(numPieces + " transporter pieces must be collected");
		
		//choose number of crew, types and names
		CrewMember c1 = new CrewMember(welcomeScreen.c1Name, welcomeScreen.c1Type);
		Crew.add(c1);
		CrewMember c2 = new CrewMember(welcomeScreen.c2Name, welcomeScreen.c2Type);
		Crew.add(c2);
		System.out.println(c1.getName() + " " + c2.getType());
		System.out.println(Crew.get(0).getName());
		if (welcomeScreen.c3Type != "None") {
			CrewMember c3 = new CrewMember(welcomeScreen.c3Name, welcomeScreen.c3Type);
			Crew.add(c3);	
		}
		if (welcomeScreen.c4Type != "None") {
			CrewMember c4 = new CrewMember(welcomeScreen.c4Name, welcomeScreen.c4Type);
			Crew.add(c4);	
		}
		
		//name your ship and create Ship class
		
		ourShip = new ship(welcomeScreen.shipName);
		System.out.println(ourShip.getName());
			
	}
	
	//causes either asteroid to happen or nothing
	public static void Asteroid() {
		Random rand1 = new Random();
		int eventnum = rand1.nextInt(3);
		eventnum += 1;
		//Asteroid field occurs
		if (eventnum == 1) {
			shipGui.outsideText = "You encountered an asteroid field on the way to a new Planet.";
			ourShip.setShield(-80);
		} else {
		shipGui.outsideText = "You have have traveled to a New planet";
		}
	}
	
	//Causes one of three things to occur. Alien pirate attack, space plague or nothing.
	public static void newDayEvent() {
		Random rand1 = new Random();
		int eventnum = rand1.nextInt(4);
		eventnum += 1;
		currentDay += 1;
		//reset actions
		for (int i = 0; i < Crew.size(); i++) {
			Crew.get(i).resetActions();
			if (Crew.get(i).getPlague() == true) {
				Crew.get(i).setHealth(-15);
			}
			if (Crew.get(i).getHunger() <= 0) {
				Crew.get(i).setHealth(-10);
			}
			if (Crew.get(i).getTired() <= 0) {
				Crew.get(i).setHealth(-10);
			}
		}
		
		//Alien pirate event occurs
		if (eventnum == 1) {
			
			System.out.println("Alien Pirates attack");
			int size1 = Food.size();
			int size2 = Medical.size();
			if (size1 + size2 == 0) {
				System.out.println("There are no items for the aliens to steal");
				shipGui.outsideText = "There are no items for the aliens to steal";
			} else {
				int eventnum2 = rand1.nextInt(size1+size2);
				if (eventnum2 >= size1) {
					System.out.println("The aliens have stolen: " + Medical.get(eventnum2-size1).getName());
					shipGui.outsideText = "The aliens have stolen: " + Medical.get(eventnum2-size1).getName();
					Medical.remove(eventnum2-size1);
				} else {
					System.out.println("The aliens have stolen: " + Food.get(eventnum2).getName());
					shipGui.outsideText = "The aliens have stolen: " + Food.get(eventnum2).getName();
					Food.remove(eventnum2);
				}
			}
		}
		//space plague event occurs
		else if (eventnum == 2) {
			//shipGui.outsideText = "Outbreak of space plague";
			System.out.println("Outbreak of space plague");
			int count = 0;
			int plagueEvent = rand1.nextInt(Crew.size());
			ArrayList<Integer> C = new ArrayList<Integer>();
			for (int i = 0; i < Crew.size(); i++) {
				if (Crew.get(i).getType() == "Dead") {
					C.add(i);
				}
			}
			while (count == 0 && C.size() < 4) {
				if (Crew.get(plagueEvent).getType() != "Dead") {
					Crew.get(plagueEvent).setPlague(true);
					System.out.println(Crew.get(plagueEvent).getName() + " has caught the Space plague");
					shipGui.outsideText = Crew.get(plagueEvent).getName() + " has caught the Space plague";
					count += 1;
				}
				plagueEvent = rand1.nextInt(Crew.size());
			}
			int morePlague = rand1.nextInt(Crew.size());
			while (morePlague != plagueEvent) {
				if (Crew.get(morePlague).getPlague() == false && Crew.get(morePlague).getType() != "Dead") {
					Crew.get(morePlague).setPlague(true);
					System.out.println(Crew.get(morePlague).getName() + " has caught the Space plague");
					shipGui.outsideText = Crew.get(morePlague).getName() + " and " + shipGui.outsideText;
				}
				morePlague = rand1.nextInt(Crew.size());
			}
		}
		//nothing occurs
		else if (eventnum >= 3) {
			shipGui.outsideText = "Nothing Happens overnight";
		}
		shipGui.CrewUpdater();
	}
	
	public static void checkStatus(int index) {
		//checks that health is higher than zero and if not removes from crew
		if (Crew.get(index).getHealth() <= 0) {
			System.out.println(Crew.get(index).getName() + " has died");
			Crew.remove(index);
		}
	}
	
	public static void UseItems(int I_index, int C_index, int choice) {
		//uses one of the items and 
		if (Crew.get(C_index).getAction() <= 0) {
			shipGui.outsideText = Crew.get(C_index).getName() + " does not have any actions left";
		}
		
		else {
			Crew.get(C_index).useAction();
			if (choice == 1) {
				//Use food
				Crew.get(C_index).setHunger(Food.get(I_index).getChange());
				shipGui.outsideText = Crew.get(C_index).getName() + " has eaten: " + Food.get(I_index).getName();
				Food.remove(I_index);
			} else {
				if (Medical.get(I_index).getName() == "Space Plague Medicine") {
					Crew.get(C_index).setPlague(false);
				}
				//use medical
				Crew.get(C_index).setHealth(Medical.get(I_index).getChange());
				shipGui.outsideText = Crew.get(C_index).getName() + " has used: " + Medical.get(I_index).getName();
				Medical.remove(I_index);
			}
		}
		shipGui.CrewUpdater();
	}
	
	public static void SearchPlanet(int index) {
		//Searches the planet for items
		if (Crew.get(index).getAction() <= 0) {
			shipGui.outsideText = Game.Crew.get(index).getName() + " does not have any actions";
		} else {
		Crew.get(index).useAction();
		shipGui.outsideText = "You are searching the planet";
		Random planet = new Random();
		int item;
		if (piece_flag == true) {
			item = planet.nextInt(4);
		} 
		
		else {
			item = planet.nextInt(Crew.get(index).getSearch());
		}
		
		item += 1;

		if (item >= 5) {
			shipGui.outsideText = "Congratulations! You have found a transporter piece";
			System.out.println("Congratulations! You have found a transporter piece");
			score += 25;
			currentPieces += 1;
			piece_flag = true;
		}
		
		else if (item == 1) {
			int n1 = planet.nextInt(6);
			n1 += 1;
			FoodItems F = new FoodItems(n1);
			shipGui.outsideText = "You have found a: " + F.getName();
			System.out.println("You have found a: " + F.getName());
			Food.add(F);
		}
		
		else if (item == 2) {
			int n2 = planet.nextInt(4);
			n2 += 1;
			MedicalItems M = new MedicalItems(n2);
			shipGui.outsideText = "You have found a: " + M.getName();
			System.out.println("You have found a: " + M.getName());
			Medical.add(M);
		}
		
		else if (item == 3) {
			shipGui.outsideText = "You have found 20 credits";
			System.out.println("You have found 20 credits");
			money += 20;
		}
		
		else if (item == 4) {
			shipGui.outsideText = "Too bad. You didn't find anything";
			System.out.println("Too bad. You didn't find anything");
		}
		
		
	}
	shipGui.CrewUpdater();
	}
	
	public static void NewPlanet(int index1, int index2) {
		//finds out which crew member will pilot with chosen crew member and flies to new planet
		System.out.println(Crew.get(index1).getName() + " pilots the ship to a new planet with the help of " + Crew.get(index2).getName());
		Crew.get(index1).useAction();
		Crew.get(index2).useAction();
		piece_flag = false;
		Asteroid();
		shipGui.CrewUpdater();
		}
	
	public static void repairShield(int C_index) {
		if (Crew.get(C_index).getAction() <= 0) {
			shipGui.outsideText = Game.Crew.get(C_index).getName() + " does not have any actions";
		} else {
		Crew.get(C_index).useAction();
		ourShip.setShield(Crew.get(C_index).getRepair());
		shipGui.outsideText = Crew.get(C_index).getName() + " has repaired the shields";
		}
		shipGui.CrewUpdater();
	}
	
	public static void sleep(int C_index) {
		if (Crew.get(C_index).getAction() <= 0) {
			shipGui.outsideText = Game.Crew.get(C_index).getName() + " does not have any actions";
		} else {
		Crew.get(C_index).sleep();
		Crew.get(C_index).useAction();
		shipGui.outsideText = Crew.get(C_index).getName() + " has slept";
		}
		shipGui.CrewUpdater();
	}
	
	public static void endConditions() {
		int count = 0;
		score = money + (25*currentPieces) - (10*currentDay);
		
		System.out.println("The score is: " + score);
		for (int i = 0; i < Crew.size(); i++) {
			if (Crew.get(i).getType() == "Dead") {
				count += 1;
			}
		}
		
		if (currentDay > Days) {
			shipGui.closeWindow();
			manager.launchEnd();
			endScreenGui.endMessage1.setText("Game over. You took too long");
			endScreenGui.endMessage2.setText(currentPieces + "/" + numPieces + " parts were found for " + ourShip.getName());
			endScreenGui.endMessage3.setText("You achieved a Score of: " + score + " in " + Days + " Days");
			
		} else if (currentPieces == numPieces) {
			shipGui.closeWindow();
			manager.launchEnd();
			endScreenGui.endMessage1.setText("Congratulations!!! You found all the transporter pieces in time");
			endScreenGui.endMessage2.setText("All " + currentPieces + " parts were found for " + ourShip.getName());
			score += 100;
			endScreenGui.endMessage3.setText("You achieved a Score of: " + score + " in " + Days + " Days");
			
		} else if (count == 4) {
			shipGui.closeWindow();
			manager.launchEnd();
			endScreenGui.endMessage1.setText("Game Over. All of your crew members have died");
			endScreenGui.endMessage2.setText(currentPieces + "/" + numPieces + " parts were found for " + ourShip.getName());
			endScreenGui.endMessage3.setText("You achieved a Score of: " + score + " in " + Days + " Days");
			
		} else if (ourShip.getShield() <= 0) {
			shipGui.closeWindow();
			manager.launchEnd();
			endScreenGui.endMessage1.setText("Game Over. Your ship has been destroyed");
			endScreenGui.endMessage2.setText(currentPieces + "/" + numPieces + " parts were found for " + ourShip.getName());
			endScreenGui.endMessage3.setText("You achieved a Score of: " + score + " in " + Days + " Days");
		}
		
	}

public void launchWelcome() {
	welcomeScreen welcomeWindow = new welcomeScreen(this);
		}

public void launchShip() {
	shipGui shipWindow = new shipGui(this);
	shipGui.outsideText  = "You must find " + Game.numPieces + " parts for " + Game.ourShip.getName() + " in " + Game.Days + " Days. Good Luck!";
	shipGui.CrewUpdater();
	
		}
public void launchTravel() {
	travelGui travelWindow = new travelGui(this);
}
public void launchOutpost() {
	outpostGui outpostWindow = new outpostGui(this);
}
public void launchEnd() {
	endScreenGui endWindow = new endScreenGui(this);
}
	public static void main(String[] args) {
		
		manager = new Game();
		manager.launchWelcome();
	}
}
