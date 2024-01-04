package com.shivam.learn.workflow;

public class Main {

    public static void main(String[] args) {
        final TaskFactory taskFactory = Common.TASK_FACTORY;
        final WorkflowExecutor<InventoryRequest, PricingBuilder> invWFE = new DefaultWorkflowExecutor<>(taskFactory);
        final InventoryTask inventoryTask = new InventoryTask(taskFactory);

        final PricingBuilder invColl = new PricingBuilder();
        invWFE.execute(inventoryTask.getType(), new InventoryRequest("INV", "1"), invColl);

        System.out.println(invColl);

        System.out.println("------------------------");
        final WorkflowExecutor<ConfigRequest, PricingBuilder> configWFE = new DefaultWorkflowExecutor<>(
                Common.TASK_FACTORY);
        final ConfigTask configTask = new ConfigTask(taskFactory);

        final PricingBuilder configColl = new PricingBuilder();
        configWFE.execute(configTask.getType(), new ConfigRequest("CONF", "0"), configColl);

        System.out.println(configColl);
    }
}
