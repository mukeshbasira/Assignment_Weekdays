import java.util.ArrayList;

public class Order {
	private int orderId;
	private float distance;
	private ArrayList<String> meals;

	public Order(int orderId, ArrayList<String> meals, float distance) {
		super();
		this.orderId = orderId;
		this.meals = meals;
		this.distance = distance;
	}
	public ArrayList<String> getMeals() {
		return meals;
	}

	public void setMeals(ArrayList<String> meals) {
		this.meals = meals;
	}


	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}



}
