package restaurant.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Dessert {
    private String name;
    private BigDecimal price;

    public Dessert(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
        Dessert dessert = (Dessert) o;
        return Objects.equals(name, dessert.name)
                && Objects.equals(price, dessert.price);
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
