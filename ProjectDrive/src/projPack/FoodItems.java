package projPack;
public class FoodItems {
	
	public int foodPrice;
	public int hungerChange;
	public String name;
	
	public FoodItems(int foodName) {
		
		if(foodName == 1) {
			name = "Apple";
			foodPrice = 10;
			hungerChange = 10;
		}
		else if(foodName == 2) {
			name = "Banana";
			foodPrice = 15;
			hungerChange = 15;
		}
		else if(foodName == 3) {
			name = "Muffin";
			foodPrice = 30;
			hungerChange = 25;
		}
		else if(foodName == 4) {
			name = "Burger";
			foodPrice = 40;
			hungerChange = 30;
		}
		else if(foodName == 5) {
			name = "Steak";
			foodPrice = 80;
			hungerChange = 50;
		}
		else if(foodName == 6) {
			name = "Roast Pork";
			foodPrice = 110;
			hungerChange = 100;
		}	
	}
	
	String getName() {
		return name;
	}
	
	double getPrice() {
		return foodPrice;	
	}
	int getChange() {
		return hungerChange;
	}
	
	public String toString() {
		return name;
	}
}
