
public class Meal {

	private String mealName;
	private float mealTime;
	private int mealSlots;
	public Meal(String mealName, float mealTime, int mealSlots) {
		super();
		this.mealName = mealName;
		this.mealTime = mealTime;
		this.mealSlots = mealSlots;
	}


	public String getMealName() {
		return mealName;
	}

	public float getMealTime() {
		return mealTime;
	}

	public int getMealSlots() {
		return mealSlots;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public void setMealTime(float mealTime) {
		this.mealTime = mealTime;
	}

	public void setMealSlots(int mealSlots) {
		this.mealSlots = mealSlots;
	}


}
