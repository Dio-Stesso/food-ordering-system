package restaurant.strategy;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import restaurant.model.Lunch;
import restaurant.storage.Stock;

public class LunchOrderOperation implements OrderOperation<Lunch> {
    @Override
    public Lunch doOrder(Scanner scanner, OrderStrategy orderStrategy) {
        List<Lunch> lunches = Stock.getLunches()
                .stream()
                .filter(lunch -> lunch.getCuisine().getName().equals(orderStrategy.getCuisine()))
                .toList();
        for (int i = 1; i <= lunches.size(); i++) {
            System.out.println(i + " - " + lunches.get(i - 1));
        }
        System.out.println("Specify an appropriate number of lunch.");
        int lunchNumber = scanner.nextInt() - 1;
        Lunch lunch = lunches.get(lunchNumber);
        BigDecimal newPrice = orderStrategy.getGeneralPrice()
                .add(lunch.getMainCourse().getPrice())
                .add(lunch.getDessert().getPrice());
        orderStrategy.setGeneralPrice(newPrice);
        return lunch;
    }
}
