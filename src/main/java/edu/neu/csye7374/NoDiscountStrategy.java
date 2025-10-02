package edu.neu.csye7374;

/**
 * Applies no discount; useful as a default baseline strategy.
 */
public class NoDiscountStrategy implements DiscountStrategy {

    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice;
    }

    @Override
    public String getName() {
        return "No Discount";
    }
}
