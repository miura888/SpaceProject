package projPack;

public class CrewMember {

	public String crewName;
	public String crewtype;
	public int health;
	public int hunger;
	public int repairRate;
	public int searchRate;
	public Integer actions = 2;
	public int tired;
	public boolean plague = false;
	public int maxHealth;
	public int maxHunger;

	public CrewMember(String name,String type) {

		crewName = name;
		tired = 100;
		hunger = 100;
		maxHunger = 100;
		if (type == "Pilot") {
			crewtype = "Pilot";
			health = 100;
			maxHealth = 100;
			repairRate = 80;
			searchRate = 5;
			

		} else if (type == "Engineer") {
			crewtype = "Engineer";
			health = 80;
			maxHealth = 80;
			repairRate = 100;
			searchRate = 5;
			
		} else if (type == "Guard") {
			crewtype = "Guard";
			health = 90;
			maxHealth = 90;
			repairRate = 50;
			searchRate = 6;
			
		} else if (type == "Medic") {
			crewtype = "Medic";
			health = 100;
			maxHealth = 100;
			repairRate = 40;
			searchRate = 6;
			
		} else if (type == "Merchant") {
			crewtype = "Merchant";
			health = 80;
			maxHealth = 80;
			repairRate = 40;
			searchRate = 7;
			
		} else if (type == "GOAT") {
			crewtype = "Goat";
			health = 100;
			maxHealth = 100;
			repairRate = 40;
			searchRate = 8;
			
		}
		else if (type == "Dead") {
			crewtype = "Dead";
			hunger = 0;
			tired = 0;
			repairRate = 0;
			searchRate = 0;
			maxHealth = 0;
			maxHunger = 0;
			actions = 0;
			health = 0;
			
		}
	}

	public boolean getPlague() {
		return plague;
	}

	public void setPlague(boolean act) {
		plague = act;
	}

	public String getName() {
		return crewName;
	}

	public String getType() {
		return crewtype;
	}
	
	public String setType(String newType) {
		return crewtype = newType;
		
	}

	public int getHunger() {
		return hunger;
	}
	
	public void setHunger(int hunger_p) {
		hunger += hunger_p;
		if (hunger > maxHunger) {
			hunger = maxHunger;
		}
	}

	public int getTired() {
		return tired;
	}
	public void setTired(int tiredChange) {
		tired += tiredChange;
	}
	
	public void sleep() {
		tired = 100;
	}

	public int getRepair() {
		return repairRate;
	}

	public int getSearch() {
		return searchRate;
	}

	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health_p) {
		health += health_p;
		if (health > maxHealth) {
			health = maxHealth;
		}
	}
	
	public int getMax() {
		return maxHealth;
	}
	
	public Integer getAction() {
		return actions;
	}
	
	public void resetActions() {
		actions = 2;
	}
	
	public void useAction() {
		actions -= 1;
	}
	
	public String GetActionS() {
		return actions.toString();
	}
}
