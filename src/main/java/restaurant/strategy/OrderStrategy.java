package restaurant.strategy;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;
import restaurant.model.Drink;
import restaurant.model.Lunch;
import restaurant.model.Order;

@Getter
@Setter
public class OrderStrategy {
    private BigDecimal generalPrice;
    private String cuisine;

    public OrderStrategy(BigDecimal generalPrice) {
        this.generalPrice = generalPrice;
    }

    public Order startStrategy() {
        System.out.println("Do you wish to order something?");
        System.out.println("Please, specify the answer: Y (yes) or N (no)");
        System.out.println("Would you like to order lunch? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();
        if ("Y".equals(scanner.next())) {
            System.out.println(Arrays.stream(Lunch.Cuisines.values())
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            System.out.println("Specify a cuisine of lunch (enter the name manually)");
            cuisine = scanner.next();
            OrderOperation<Lunch> lunchOrderOperation = new LunchOrderOperation();
            Lunch lunch = lunchOrderOperation.doOrder(scanner, this);
            order.setLunch(lunch);
            System.out.println("What about some kind of drink? (Y/N)");
            if ("Y".equals(scanner.next())) {
                OrderOperation<Drink> drinkOrderOperation = new DrinkOrderOperation();
                Drink drink = drinkOrderOperation.doOrder(scanner, this);
                order.setDrink(drink);
            }
        } else {
            System.out.println("Maybe you would like to order a drink, wouldn't you? (Y/N)");
            if ("Y".equals(scanner.next())) {
                DrinkOrderOperation drinkOrderOperation = new DrinkOrderOperation();
                Drink drink = drinkOrderOperation.doOrder(scanner, this);
                System.out.println("Would you like to add ice(1), lemon(2), or both(3)?");
                System.out.println("Enter another key to reject the choice.");
                int additionalChoice = scanner.nextInt();
                drink = drinkOrderOperation.addGoodsToDrink(drink, additionalChoice);
                order.setDrink(drink);
            }
        }
        return order;
    }

    public void printDetails(Order order) {
        System.out.println("The order is placed. Order details: ");
        Lunch lunch = order.getLunch();
        Drink drink = order.getDrink();
        if (lunch != null) {
            System.out.println(lunch);
        }
        if (drink != null) {
            System.out.println(drink);
        }
        System.out.println("Amount to pay: " + generalPrice);
    }
}
