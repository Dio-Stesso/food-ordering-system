package restaurant.strategy;

import java.util.Scanner;

public interface OrderOperation<T> {
    T doOrder(Scanner scanner, OrderStrategy orderStrategy);
}
