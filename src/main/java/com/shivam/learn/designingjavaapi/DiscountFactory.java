package com.shivam.learn.designingjavaapi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sksingh created on 11/09/23
 */
public class DiscountFactory {

    private static final Map<String, DiscountStrategy> STRATEGIES = new HashMap<>();
    private static final DiscountStrategy DEFAULT_STRATEGY = () -> 0;

    static {
        STRATEGIES.put("code1", () -> 10);
        STRATEGIES.put("code2", () -> 20);
    }

    public DiscountStrategy getStrategy(String priceCode) {
        if (!STRATEGIES.containsKey(priceCode)) {
            return DEFAULT_STRATEGY;
        }

        return STRATEGIES.get(priceCode);
    }

    interface DiscountStrategy {
        int getDiscount();
    }
}
