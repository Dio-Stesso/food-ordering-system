package restaurant.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lunch {
    private MainCourse mainCourse;
    private Dessert dessert;
    private Cuisines cuisine;

    public Lunch(MainCourse mainCourse, Dessert dessert, Cuisines cuisine) {
        this.mainCourse = mainCourse;
        this.dessert = dessert;
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
    public String toString() {
        return "Lunch{"
                + "Main course = " + mainCourse
                + ", dessert = " + dessert
                + ", cuisine = " + cuisine
                + '}';
    }
}
