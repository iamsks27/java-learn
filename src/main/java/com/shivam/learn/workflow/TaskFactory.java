package com.shivam.learn.workflow;

public interface TaskFactory<R, C> {

    Task<R, C> getTask(String taskId);

    void register(String type, Task<R, C> task);
}
