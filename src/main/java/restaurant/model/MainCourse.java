package restaurant.model;

import java.math.BigDecimal;
import java.util.Objects;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MainCourse that = (MainCourse) o;
        return Objects.equals(name, that.name) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "'" + name + "', price = " + price;
    }
}
