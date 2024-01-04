package com.shivam.learn.workflow;

public interface TaskType<E extends Enum<E>> {

    String name();
}