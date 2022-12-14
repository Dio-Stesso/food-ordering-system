package restaurant.model;

import java.util.Objects;

public class Lunch {
    private MainCourse mainCourse;
    private Dessert dessert;
    private Cuisines cuisine;

    public Lunch(MainCourse mainCourse, Dessert dessert, Cuisines cuisine) {
        this.mainCourse = mainCourse;
        this.dessert = dessert;
        this.cuisine = cuisine;
    }

    public MainCourse getMainCourse() {
        return mainCourse;
    }

    public void setMainCourse(MainCourse mainCourse) {
        this.mainCourse = mainCourse;
    }

    public Dessert getDessert() {
        return dessert;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public Cuisines getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisines cuisine) {
        this.cuisine = cuisine;
    }

    public enum Cuisines {
        POLISH("Polish"),
        MEXICAN("Mexican"),
        ITALIAN("Italian");

        private final String name;
        Cuisines(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lunch lunch = (Lunch) o;
        return Objects.equals(mainCourse, lunch.mainCourse)
                && Objects.equals(dessert, lunch.dessert)
                && cuisine == lunch.cuisine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainCourse, dessert, cuisine);
    }

    @Override
    public String toString() {
        return "Lunch{"
                + "Main course = " + mainCourse
                + ", dessert = " + dessert
                + ", cuisine = " + cuisine
                + '}';
    }
}
