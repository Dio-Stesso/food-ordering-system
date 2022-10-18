package restaurant;

import java.math.BigDecimal;
import java.util.List;
import restaurant.model.Dessert;
import restaurant.model.Drink;
import restaurant.model.Lunch;
import restaurant.model.MainCourse;
import restaurant.storage.Stock;

public class DataInitializer {
    public static void init() {
        List<Drink> drinks = List.of(new Drink("Juice", BigDecimal.valueOf(40)),
                new Drink("Compote", BigDecimal.valueOf(20)));

        MainCourse soup = new MainCourse("Soup", BigDecimal.valueOf(65));
        Dessert cheesecake = new Dessert("Cheesecake", BigDecimal.valueOf(25));
        Lunch lunch1 = new Lunch(soup, cheesecake, Lunch.Cuisines.POLISH);

        MainCourse pizza = new MainCourse("Pizza", BigDecimal.valueOf(95));
        Dessert tiramisu = new Dessert("Tiramisu", BigDecimal.valueOf(55));
        Lunch lunch2 = new Lunch(pizza, tiramisu, Lunch.Cuisines.ITALIAN);

        MainCourse peppers = new MainCourse("Chile peppers", BigDecimal.valueOf(76));
        Dessert flan = new Dessert("Flan", BigDecimal.valueOf(43));
        Lunch lunch3 = new Lunch(peppers, flan, Lunch.Cuisines.MEXICAN);

        List<Lunch> lunches = List.of(lunch1, lunch2, lunch3);

        Stock.setDrinks(drinks);
        Stock.setLunches(lunches);
    }
}
