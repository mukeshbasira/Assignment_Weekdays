import java.util.ArrayList;

public class Restaurant {
	final int cooking_slots_total = 7;
	static int cooking_slots = 7;
	final static int time_to_cover_1km = 8;
	final static float not_delivered_constraint = (float) 150.0;
	ArrayList<Meal> mealsOfferedByRest;


	public Restaurant(ArrayList<Meal> mealsOfferedByRest) {
		super();
		this.mealsOfferedByRest = mealsOfferedByRest;
	}

}
