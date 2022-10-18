package restaurant.strategy;

import java.util.List;
import java.util.Scanner;
import restaurant.model.Drink;
import restaurant.storage.Stock;

public class DrinkOrderOperation implements OrderOperation<Drink> {
    @Override
    public Drink doOrder(Scanner scanner, OrderStrategy orderStrategy) {
        List<Drink> drinks = Stock.getDrinks();
        for (int i = 1; i <= drinks.size(); i++) {
            System.out.println(drinks.get(i - 1) + " - " + i);
        }
        System.out.println("Specify an appropriate number of the drink.");
        int drinkNumber = scanner.nextInt() - 1;
        Drink drink = drinks.get(drinkNumber);
        orderStrategy.setGeneralPrice(orderStrategy.getGeneralPrice().add(drink.getPrice()));
        return drink;
    }
}
