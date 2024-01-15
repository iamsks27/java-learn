package com.shivam.learn.reflection.repeatableannotation.annotations;

import java.lang.annotation.*;

/**
 * @author sksingh created on 14/01/24
 */
public class Annotations {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ScanPackage {

        String[] value();
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ScheduledExecutorClass {

    }

    @Repeatable(ExecutionSchedules.class)
    @Target(ElementType.METHOD)
    public @interface ExecuteOnSchedule {

        int delaySeconds() default 0;

        int periodSeconds();
    }

    // Container annotation
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ExecutionSchedules {

        // This is mandatory field, as compiler will replace all repeatable annotations with container annotation
        ExecuteOnSchedule[] value();
    }
}
