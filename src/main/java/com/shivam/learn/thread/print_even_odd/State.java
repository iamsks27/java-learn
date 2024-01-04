package com.shivam.learn.thread.print_even_odd;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
public class State {

    private PrintType nextPrintType;

    public State(@NonNull PrintType nextPrintType) {
        this.nextPrintType = nextPrintType;
    }
}
