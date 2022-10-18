package restaurant.model;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainCourse {
    private String name;
    private BigDecimal price;

    public MainCourse(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "'" + name + "', price = " + price;
    }
}
