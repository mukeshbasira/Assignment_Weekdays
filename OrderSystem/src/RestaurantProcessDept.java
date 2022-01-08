import java.util.ArrayList;

public class RestaurantProcessDept
extends Restaurant {

	public RestaurantProcessDept(ArrayList<Meal> mealsOfferedByRest) {
		super(mealsOfferedByRest);
	}

	public int checkRequiredFreeSlots(Order order) {
		int slots = 0;
		for (String meal : order.getMeals()) {
			for (Meal meal2 : mealsOfferedByRest) {
				if (meal.compareTo(meal2.getMealName()) == 0) {
					slots += meal2.getMealSlots();

				}
			}

		}
		return slots;

	}

	public void cancelOrder(final int orderId) {
		System.out.println("order" + orderId + " is denied because the restaurant cannot accommodate it.");
	}

	public void executeOrder(Order order, Float extratime) {

		calTime(order, extratime);
		Restaurant.cooking_slots += checkRequiredFreeSlots(order);

	}

	private float addDeiveryTime(float f) {
		return (f * Restaurant.time_to_cover_1km);
	}

	public void calTime(Order order, Float extratime)
	{
		float time = cookTime(order) + extratime;

		time += addDeiveryTime(order.getDistance());

		if (timeConstraintPassed(time)) {

			System.out.println("Order" + order.getOrderId() + "  will get delivered in " + time + " minutes");
		} else {
			System.out.println(
					"Order" + order.getOrderId() + "  cancelled as can not delivered in  " + time + " minutes");
		}
	}

	public float cookTime(Order order)
	{ float time = 0;
	for (String meal : order.getMeals()) {

		for (Meal meal2 : mealsOfferedByRest) {
			if (meal.compareTo(meal2.getMealName()) == 0) {
				time += meal2.getMealTime();
			}

		}
	}
	return time;
	}
	public Boolean timeConstraintPassed(float time) {
		if (not_delivered_constraint - time < 0) {
			return false;
		}
		return true;
	}

}
