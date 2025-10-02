package edu.neu.csye7374;

public class BulkPurchaseDiscountStrategy implements DiscountStrategy {

    private final double threshold;
    private final double percentage;

    public BulkPurchaseDiscountStrategy(double threshold, double percentage) {
        if (threshold < 0) {
            throw new IllegalArgumentException("Threshold cannot be negative");
        }
        if (percentage < 0.0 || percentage > 1.0) {
            throw new IllegalArgumentException("Percentage must be between 0 and 1 inclusive");
        }
        this.threshold = threshold;
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double originalPrice) {
        if (originalPrice < 0) {
            throw new IllegalArgumentException("Original price cannot be negative");
        }
        if (originalPrice >= threshold) {
            return originalPrice * (1 - percentage);
        }
        return originalPrice;
    }

    @Override
    public String getName() {
        return String.format("Bulk %.0f%% Off over $%.0f", percentage * 100, threshold);
    }
}