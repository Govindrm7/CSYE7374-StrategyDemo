package edu.neu.csye7374;

import java.util.Arrays;
import java.util.List;

public class DiscountDemo {

    public static void demo() {
        double originalPrice = 250.0;
        List<DiscountStrategy> strategies = Arrays.asList(
                new NoDiscountStrategy(),
                new PercentageDiscountStrategy(0.15),
                new FlatAmountDiscountStrategy(30.0),
                new BulkPurchaseDiscountStrategy(200.0, 0.20));

        System.out.printf("Original price: $%.2f%n%n", originalPrice);

        DiscountProcessor processor = new DiscountProcessor(strategies.get(0));

        for (DiscountStrategy strategy : strategies) {
            processor.setStrategy(strategy);
            double finalPrice = processor.apply(originalPrice);
            System.out.printf("Strategy: %-25s -> Final price: $%.2f%n",
                    strategy.getName(), finalPrice);
        }
    }
}
