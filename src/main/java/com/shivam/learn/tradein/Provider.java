package com.shivam.learn.tradein;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Provider {

    KBB("KBB"),
    BB("BB");

    private final String name;
}
