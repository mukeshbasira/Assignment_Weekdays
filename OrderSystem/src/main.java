import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.google.gson.Gson;

public class main {



	public static void main(String[] args) {
		RestaurantProcessDept RestaurantProcessDept = new RestaurantProcessDept(
				new ArrayList<Meal>(Arrays.asList(new Meal("A", 17, 1), new Meal("M", 29, 2))));

		try (Reader reader = new FileReader("/Users/mukeshbasira/eclipse-workspace/OrderSystem/src/input.txt")) {
			Gson gson = new Gson();
			Order[] orders = gson.fromJson(reader, Order[].class);
			Queue<Order> q = new LinkedList<>(Arrays.asList(orders));
			Queue<Float> totaltime = new LinkedList<>();
			Float extratime = (float) 0.0;
			while (!q.isEmpty()) {
				if (RestaurantProcessDept
						.checkRequiredFreeSlots(q.peek()) > RestaurantProcessDept.cooking_slots_total) {
					RestaurantProcessDept.cancelOrder(q.poll().getOrderId());
				}else {
					extratime = (float) 0.0;
					Queue<Order> currentOrders = new LinkedList<>();
					while (!q.isEmpty()
							&& Restaurant.cooking_slots - RestaurantProcessDept.checkRequiredFreeSlots(q.peek()) > 0) {
						Restaurant.cooking_slots -= RestaurantProcessDept.checkRequiredFreeSlots(q.peek());
						while (!totaltime.isEmpty()) {
							extratime = Math.max(totaltime.poll(), extratime);
						}
						currentOrders.add(q.poll());
					}
					while (!currentOrders.isEmpty()) {
						totaltime.add((RestaurantProcessDept.cookTime(currentOrders.peek())) + extratime);

						RestaurantProcessDept.executeOrder(currentOrders.poll(), extratime);
					}
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Read issue ");
			e.printStackTrace();
		}


	}
}