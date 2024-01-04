package com.shivam.learn;

public class Term {

    private final String type;
    private final int term;
    private final double amountDiff;
    private final double monthlyPayment;

    public Term(String type, int term, double amountDiff, double monthlyPayment) {
        this.type = type;
        this.term = term;
        this.amountDiff = amountDiff;
        this.monthlyPayment = monthlyPayment;
    }

    public String getType() {
        return type;
    }

    public int getTerm() {
        return term;
    }

    @Override
    public String toString() {
        return "{\"term\": " + term + ", \"amountDiff\": " + amountDiff + ", \"monthlyPayment\": " + monthlyPayment + "}";
    }
}
