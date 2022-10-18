package restaurant.model;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Drink {
    private String name;
    private boolean isIceIncluded;
    private boolean isLemonIncluded;
    private BigDecimal price;

    public Drink(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Drink{"
                + "name = '" + name + '\''
                + ", price = " + price
                + ", ice " + (isIceIncluded ? "included" : "not included")
                + ", lemon " + (isLemonIncluded ? "included" : "not included")
                + '}';
    }
}
