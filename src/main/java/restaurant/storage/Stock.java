package restaurant.storage;

import java.util.List;
import restaurant.model.Drink;
import restaurant.model.Lunch;

public class Stock {
    private static List<Lunch> lunches;
    private static List<Drink> drinks;

    public static List<Lunch> getLunches() {
        return lunches;
    }

    public static void setLunches(List<Lunch> lunches) {
        Stock.lunches = lunches;
    }

    public static List<Drink> getDrinks() {
        return drinks;
    }

    public static void setDrinks(List<Drink> drinks) {
        Stock.drinks = drinks;
    }
}
