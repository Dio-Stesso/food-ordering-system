package restaurant.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private Lunch lunch;
    private Drink drink;

    @Override
    public String toString() {
        return "Order{"
                + "lunch=" + lunch
                + ", drink=" + drink
                + '}';
    }
}
