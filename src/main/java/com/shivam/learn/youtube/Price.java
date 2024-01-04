package com.shivam.learn.youtube;

public interface Price {

    static Price price(double price) {
        if (price < 0) {
            return Malformed.INSTANCE;
        }
        return new Fixed(price);
    }

    static Price price(double minPrice, double maxPrice) {
        if (minPrice > maxPrice) {
            return Malformed.INSTANCE;
        }
        return new Range(minPrice, maxPrice);
    }

    class Fixed implements Price {

        private final double price;

        public Fixed(double price) {
            this.price = price;
        }
    }

    class Range implements Price {

        private final double minPrice;
        private final double maxPrice;

        public Range(double minPrice, double maxPrice) {
            this.minPrice = minPrice;
            this.maxPrice = maxPrice;
        }
    }

    enum Malformed implements Price {
        INSTANCE;
    }
}
