package restaurant.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restaurant.DataInitializer;
import restaurant.model.Drink;

class DrinkOrderOperationTest {
    private static DrinkOrderOperation orderOperation;
    private static OrderStrategy orderStrategy;
    private Drink expectedDrink;

    @BeforeAll
    public static void init() {
        DataInitializer.init();
        orderOperation = new DrinkOrderOperation();
        orderStrategy = new OrderStrategy(BigDecimal.valueOf(0));
    }

    @BeforeEach
    void setUp() {
        expectedDrink = new Drink("Juice", BigDecimal.valueOf(40));
    }

    @Test
    void shouldSetAppropriateDrinkToOrder() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);
        Drink actualDrink = orderOperation.doOrder(scanner, orderStrategy);

        assertEquals(expectedDrink, actualDrink, "The drink should match the menu lunch.");
    }

    @Test
    void shouldIncludeIce() {
        Drink expectedDrink = new Drink("Juice", BigDecimal.valueOf(40));
        expectedDrink.setIceIncluded(true);

        Drink actualDrink = orderOperation.addGoodsToDrink(expectedDrink, 1);

        assertEquals(expectedDrink, actualDrink, "The drink should include ice.");
    }

    @Test
    void shouldIncludeLemon() {
        Drink expectedDrink = new Drink("Juice", BigDecimal.valueOf(40));
        expectedDrink.setLemonIncluded(true);

        Drink actualDrink = orderOperation.addGoodsToDrink(expectedDrink, 2);

        assertEquals(expectedDrink, actualDrink, "The drink should include lemon.");
    }

    @Test
    void shouldIncludeAllGoods() {
        Drink expectedDrink = new Drink("Juice", BigDecimal.valueOf(40));
        expectedDrink.setIceIncluded(true);
        expectedDrink.setLemonIncluded(true);

        Drink actualDrink = orderOperation.addGoodsToDrink(expectedDrink, 3);

        assertEquals(expectedDrink, actualDrink, "The drink should include all goods.");
    }
}
