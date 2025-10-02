package edu.neu.csye7374;

/**
 * Strategy contract for computing a discounted price based on the original amount.
 */
public interface DiscountStrategy {

    /**
     * Calculate the discounted price for the provided amount.
     *
     * @param originalPrice price before any discounts are applied
     * @return price after the discount rules are applied
     */
    double applyDiscount(double originalPrice);

    /**
     * @return human readable name for logging/demo output
     */
    String getName();
}
