package edu.neu.csye7374;

/**
 * Applies a percentage based discount, e.g. seasonal promotions.
 */
public class PercentageDiscountStrategy implements DiscountStrategy {

    private final double percentage; // value between 0.0 and 1.0 (e.g. 0.15 for 15%)

    public PercentageDiscountStrategy(double percentage) {
        if (percentage < 0.0 || percentage > 1.0) {
            throw new IllegalArgumentException("Percentage must be between 0 and 1 inclusive");
        }
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double originalPrice) {
        if (originalPrice < 0) {
            throw new IllegalArgumentException("Original price cannot be negative");
        }
        return originalPrice * (1 - percentage);
    }

    @Override
    public String getName() {
        return String.format("%.0f%% Off", percentage * 100);
    }
}