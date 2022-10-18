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
            System.out.println(i + " - " + drinks.get(i - 1));
        }
        System.out.println("Specify an appropriate number of the drink.");
        int drinkNumber = scanner.nextInt() - 1;
        Drink drink = drinks.get(drinkNumber);
        System.out.println("Would you like to add ice(1), lemon(2), or both(3)?");
        switch (scanner.nextInt()) {
            case 1:
                drink.setIceIncluded(true);
                break;
            case 2:
                drink.setLemonIncluded(true);
                break;
            case 3:
                drink.setIceIncluded(true);
                drink.setLemonIncluded(true);
                break;
            default:
                break;
        }
        orderStrategy.setGeneralPrice(orderStrategy.getGeneralPrice().add(drink.getPrice()));
        return drink;
    }
}
