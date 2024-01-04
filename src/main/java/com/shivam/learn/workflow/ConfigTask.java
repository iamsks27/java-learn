package com.shivam.learn.workflow;

public class ConfigTask implements Task<ConfigRequest, PricingBuilder> {

    public ConfigTask(TaskFactory<ConfigRequest, PricingBuilder> taskFactory) {
        taskFactory.register(getType(), this);
    }

    @Override
    public String getType() {
       return  "CONFIG";
    }

    @Override
    public void execute(ConfigRequest request, PricingBuilder collector) {
        collector.setAge(request.getAge());
        collector.setName(request.getName());
    }
}
