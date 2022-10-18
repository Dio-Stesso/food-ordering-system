package restaurant.strategy;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import restaurant.model.Lunch;
import restaurant.storage.Stock;

public class LunchOrderOperation implements OrderOperation<Lunch> {
    @Override
    public Lunch doOrder(Scanner scanner, OrderStrategy orderStrategy) {
        System.out.println(Arrays.stream(Lunch.Cuisines.values())
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
        System.out.println("Specify a cuisine of lunch (enter the name manually)");
        String cuisine = scanner.next();
        List<Lunch> lunches = Stock.getLunches()
                .stream()
                .filter(lunch -> lunch.getCuisine().getName().equals(cuisine))
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
