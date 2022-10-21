package restaurant.model;

public class Order {
    private Lunch lunch;
    private Drink drink;

    public Lunch getLunch() {
        return lunch;
    }

    public void setLunch(Lunch lunch) {
        this.lunch = lunch;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "Order{"
                + "lunch=" + lunch
                + ", drink=" + drink
                + '}';
    }
}
