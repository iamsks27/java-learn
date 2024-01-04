package com.shivam.learn.workflow;

public interface Task<R, C> {

    String getType();

    void execute(R request, C collector);
}