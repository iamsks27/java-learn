package com.shivam.learn.reflection.repeatableannotation.loaders;

import static com.shivam.learn.reflection.repeatableannotation.annotations.Annotations.ExecuteOnSchedule;
import static com.shivam.learn.reflection.repeatableannotation.annotations.Annotations.ScheduledExecutorClass;

/**
 * @author sksingh created on 14/01/24
 */
@ScheduledExecutorClass
public class Cache {

    @ExecuteOnSchedule(periodSeconds = 5)
    @ExecuteOnSchedule(delaySeconds = 10, periodSeconds = 1)
    public static void reloadCache() {
        System.out.println("Reloading cache...");
    }
}
