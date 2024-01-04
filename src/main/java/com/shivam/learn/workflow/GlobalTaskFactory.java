package com.shivam.learn.workflow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GlobalTaskFactory<R, C> implements TaskFactory<R, C> {

    private final Map<String, Task<R, C>> tasks = new HashMap<>();

    @Override
    public Task<R, C> getTask(String taskId) {
        if (tasks.containsKey(taskId)) {
            return tasks.get(taskId);
        } else {
            throw new RuntimeException(String.format("no task found of type %s", taskId));
        }
    }

    @Override
    public void register(String type, Task<R, C> task) {
        if (Objects.nonNull(type) && Objects.nonNull(task)) {
            tasks.put(type, task);
        }
    }
}