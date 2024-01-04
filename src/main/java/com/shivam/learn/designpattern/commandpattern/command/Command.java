package com.shivam.learn.designpattern.commandpattern.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Command {

    private final String name;
    private final List<String> params;

}
