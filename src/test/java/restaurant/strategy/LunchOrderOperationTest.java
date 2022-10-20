package restaurant.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import restaurant.DataInitializer;
import restaurant.model.Dessert;
import restaurant.model.Lunch;
import restaurant.model.MainCourse;

class LunchOrderOperationTest {
    private static OrderOperation<Lunch> orderOperation;
    private static OrderStrategy orderStrategy;

    @BeforeAll
    public static void init() {
        DataInitializer.init();
        orderOperation = new LunchOrderOperation();
        orderStrategy = new OrderStrategy(BigDecimal.valueOf(0));
    }

    @Test
    public void shouldSetAppropriateLunchToOrder() {
        MainCourse soup = new MainCourse("Soup", BigDecimal.valueOf(65));
        Dessert cheesecake = new Dessert("Cheesecake", BigDecimal.valueOf(25));
        Lunch expectedLunch = new Lunch(soup, cheesecake, Lunch.Cuisines.POLISH);

        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        orderStrategy.setCuisine("Polish");

        Scanner scanner = new Scanner(System.in);
        Lunch actualLunch = orderOperation.doOrder(scanner, orderStrategy);

        assertEquals(expectedLunch, actualLunch, "Lunch should match the menu lunch.");
    }
}
