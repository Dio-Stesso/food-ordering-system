package restaurant.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Drink {
    private String name;
    private boolean isIceIncluded;
    private boolean isLemonIncluded;
    private BigDecimal price;

    public Drink(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIceIncluded() {
        return isIceIncluded;
    }

    public void setIceIncluded(boolean iceIncluded) {
        isIceIncluded = iceIncluded;
    }

    public boolean isLemonIncluded() {
        return isLemonIncluded;
    }

    public void setLemonIncluded(boolean lemonIncluded) {
        isLemonIncluded = lemonIncluded;
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
        Drink drink = (Drink) o;
        return isIceIncluded == drink.isIceIncluded
                && isLemonIncluded == drink.isLemonIncluded
                && Objects.equals(name, drink.name)
                && Objects.equals(price, drink.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isIceIncluded, isLemonIncluded, price);
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
