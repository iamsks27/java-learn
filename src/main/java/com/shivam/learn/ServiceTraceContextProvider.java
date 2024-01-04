package com.shivam.learn;

public class ServiceTraceContextProvider {

    private final static ThreadLocal<ServiceTraceContext> SERVICE_TRACE_CONTEXT = new ThreadLocal<>();


    public static void main(String[] args) {
        final Thread t1 = new Thread(() -> {
            final ServiceTraceContext context = new ServiceTraceContext();
            final ServiceTrace trace = new ServiceTrace("SER1", "REQ-T1", "RES-T1");
            context.add("SER1", trace);

            SERVICE_TRACE_CONTEXT.set(context);

            System.out.println(SERVICE_TRACE_CONTEXT.get());
        });

        final Thread t2 = new Thread(() -> {
            final ServiceTraceContext context = new ServiceTraceContext();
            final ServiceTrace trace = new ServiceTrace("SER1", "REQ-T2", "RES-T2");
            context.add("SER1", trace);

            SERVICE_TRACE_CONTEXT.set(context);

            System.out.println(SERVICE_TRACE_CONTEXT.get());
        });

        t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }

}
