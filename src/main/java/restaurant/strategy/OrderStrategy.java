package restaurant.strategy;

import java.math.BigDecimal;
import java.util.Scanner;
import restaurant.model.Drink;
import restaurant.model.Lunch;
import restaurant.model.Order;

public class OrderStrategy {
    private BigDecimal generalPrice;

    public OrderStrategy(BigDecimal generalPrice) {
        this.generalPrice = generalPrice;
    }

    public BigDecimal getGeneralPrice() {
        return generalPrice;
    }

    public void setGeneralPrice(BigDecimal generalPrice) {
        this.generalPrice = generalPrice;
    }

    public void startStrategy() {
        Order order = new Order();
        System.out.println("Do you wish to order something?");
        System.out.println("Please, specify the answer: Y (yes) or N (no)");
        System.out.println("Would you like to order lunch? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        if ("Y".equals(scanner.next())) {
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
            System.out.println("Maybe you would like to order a drink, wouldn't you?");
            if ("Y".equals(scanner.next())) {
                OrderOperation<Drink> drinkOrderOperation = new DrinkOrderOperation();
                Drink drink = drinkOrderOperation.doOrder(scanner, this);
                order.setDrink(drink);
            }
        }
        printDetails(order);
    }

    private void printDetails(Order order) {
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
