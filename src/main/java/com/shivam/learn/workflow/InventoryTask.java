package com.shivam.learn.workflow;

public class InventoryTask implements Task<InventoryRequest, PricingBuilder> {

    public InventoryTask(TaskFactory<InventoryRequest, PricingBuilder> taskFactory) {
        taskFactory.register(getType(), this);
    }

    @Override
    public String getType() {
        return "INV";
    }

    @Override
    public void execute(InventoryRequest request, PricingBuilder collector) {

        collector.setName(request.getName());
        collector.setAge(request.getAge());
    }
}
