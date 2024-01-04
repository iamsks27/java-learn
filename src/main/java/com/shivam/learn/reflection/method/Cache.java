package com.shivam.learn.reflection.method;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sksingh created on 04/01/24
 */
public class Cache {

    private Map<String, Integer> nameToId = new HashMap<>();

    public void invalidate() {
        throw new UnsupportedOperationException("This version of cache doesn't support invalidation");
    }

    public void addEntry(String name, Integer id) {
        nameToId.put(name, id);
    }

    public Integer readIdOrThrow(String name) {
        if (nameToId.containsKey(name)) {
            return nameToId.get(name);
        }

        throw new IllegalArgumentException(String.format("Name: %s is not in the cache", name));
    }

    public int getCacheSize() {
        return nameToId.size();
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method cacheSizeMethod = Cache.class.getDeclaredMethod("getCacheSize");

        System.out.println(cacheSizeMethod.getReturnType().equals(int.class));
    }
}
