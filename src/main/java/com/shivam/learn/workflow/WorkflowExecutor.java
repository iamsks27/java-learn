package com.shivam.learn.workflow;

public interface WorkflowExecutor<R, C> {

    void execute(String taskId, R request, C collector);
}