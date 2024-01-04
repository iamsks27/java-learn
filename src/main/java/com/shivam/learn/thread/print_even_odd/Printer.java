package com.shivam.learn.thread.print_even_odd;

import lombok.NonNull;
import lombok.SneakyThrows;

public class Printer implements Runnable {

    private int currentValue;
    private final int maxValue;
    private final State state;
    private final PrintType currentPrintType;
    private final PrintType nextPrintType;
    private final int step;

    public Printer(int currentValue, int maxValue, @NonNull State state, @NonNull PrintType currentPrintType,
            @NonNull PrintType nextPrintType, int step) {
        this.currentValue = currentValue;
        this.maxValue = maxValue;
        this.state = state;
        this.currentPrintType = currentPrintType;
        this.nextPrintType = nextPrintType;
        this.step = step;
    }


    @SneakyThrows
    @Override
    public void run() {
        while (currentValue <= maxValue) {
            synchronized (state) {
                if (this.currentPrintType != state.getNextPrintType()) {
                    state.wait();
                }
                System.out.println(currentPrintType + " " + currentValue);
                currentValue += step;
                state.setNextPrintType(this.nextPrintType);
                state.notifyAll();
            }
        }
    }
}
