package com.shivam.learn.workflow;

public class DefaultWorkflowExecutor<R, C> implements WorkflowExecutor<R, C> {

    private final TaskFactory<R, C> taskFactory;

    public DefaultWorkflowExecutor(TaskFactory<R, C> taskFactory) {
        this.taskFactory = taskFactory;
    }

    @Override
    public void execute(String taskId, R request, C collector) {
        final Task<R, C> task = taskFactory.getTask(taskId);
        task.execute(request, collector);
    }
}