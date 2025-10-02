package edu.neu.csye7374;

/**
 * Subtracts a flat amount from the original price without going below zero.
 */
public class FlatAmountDiscountStrategy implements DiscountStrategy {

    private final double amount;

    public FlatAmountDiscountStrategy(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Flat discount cannot be negative");
        }
        this.amount = amount;
    }

    @Override
    public double applyDiscount(double originalPrice) {
        if (originalPrice < 0) {
            throw new IllegalArgumentException("Original price cannot be negative");
        }
        return Math.max(0.0, originalPrice - amount);
    }

    @Override
    public String getName() {
        return String.format("$%.2f Off", amount);
    }
}