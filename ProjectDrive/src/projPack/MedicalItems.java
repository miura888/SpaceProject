package projPack;

public class MedicalItems {
	
	public String medicineName;
	public double medicinePrice;
	public int healthChange;
	
	public MedicalItems(int number) {
		if(number == 1) {
			medicineName = "Vitamins";
			medicinePrice = 5;
			healthChange = 5;
		}
		else if(number == 2) {
			medicineName = "Pain Killers";
			medicinePrice = 15;
			healthChange = 15;
		}
		else if(number == 3) {
			medicineName = "First Aid Kit";
			medicinePrice = 30;
			healthChange = 25;
		
		}
		else if(number == 4) {
			medicineName = "Space Plague Medicine";
			medicinePrice = 30;
			healthChange = 10;
			//Change Space Plague Boolean
		}	
	}
	
	String getName() {
		return medicineName;
	}
	double getPrice() {
		return medicinePrice;	
	}
	int getChange() {
		return healthChange;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
