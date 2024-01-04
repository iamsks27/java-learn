package com.shivam.learn.thread.print_even_odd;

public class Runner {

    public static void main(String[] args) {
        final State state = new State(PrintType.ODD);
        final Printer oddPrinter = new Printer(1, 100, state, PrintType.ODD, PrintType.EVEN, 2);
        final Printer evenPrinter = new Printer(2, 100, state, PrintType.EVEN, PrintType.ODD, 2);

        final Thread t1 = new Thread(oddPrinter);
        final Thread t2 = new Thread(evenPrinter);
        t1.start();
        t2.start();
    }

}
