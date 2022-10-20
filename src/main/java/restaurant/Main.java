package restaurant;

import java.math.BigDecimal;
import restaurant.model.Order;
import restaurant.strategy.OrderStrategy;

public class Main {
    public static void main(String[] args) {
        DataInitializer.init();
        OrderStrategy orderStrategy = new OrderStrategy(BigDecimal.valueOf(0));
        Order order = orderStrategy.startStrategy();
        orderStrategy.printDetails(order);
    }
}
