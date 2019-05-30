package projPack;

public class ship {
	public String shipName;
	public int shield_Level = 200;
	public int shield_Mult = 1;

	public ship(String name) {
		shipName = name;
	}
	
	public int getShield() {
		return shield_Level;
	}
	
	public int getS_mult() {
		return shield_Mult;
	}
	
	public void setS_mult(int shield) {
		shield_Mult += shield;
	}

	public int setShield(int num) {
		shield_Level += num;
		if (shield_Level > 200) {
			shield_Level = 200;
		}
		return shield_Level;
	}

	public String getName() {
		return shipName;
	}
	public void setName(String name) {
		shipName = name;
	}


}


