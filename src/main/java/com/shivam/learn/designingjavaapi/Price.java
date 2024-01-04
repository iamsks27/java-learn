package com.shivam.learn.designingjavaapi;

/**
 * @author sksingh created on 28/08/23
 */
public interface Price {

    static Price price(double price) {
        if (price < 0)
            return Malformed.INSTANCE;

        return new Fixed(price);
    }

    class Fixed implements Price {
        private final double price;

        private Fixed(double price) {
            this.price = price;
        }
    }

    class Range implements Price {
        private final double minPrice;
        private final double maxPrice;

        private Range(double minPrice, double maxPrice) {
            this.minPrice = minPrice;
            this.maxPrice = maxPrice;
        }
    }

    enum Malformed implements Price {
        INSTANCE
    }
}
