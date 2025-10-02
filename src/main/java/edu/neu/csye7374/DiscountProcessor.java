package edu.neu.csye7374;

/**
 * Coordinates discount calculations by delegating to a provided strategy.
 */
public class DiscountProcessor {

    private DiscountStrategy strategy;

    public DiscountProcessor(DiscountStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(DiscountStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy cannot be null");
        }
        this.strategy = strategy;
    }

    public double apply(double originalPrice) {
        return strategy.applyDiscount(originalPrice);
    }

    public DiscountStrategy getStrategy() {
        return strategy;
    }
}
