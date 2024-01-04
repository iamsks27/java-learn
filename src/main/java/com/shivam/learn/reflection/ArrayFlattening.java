package com.shivam.learn.reflection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sksingh created on 19/12/23
 */
public class ArrayFlattening {

    public static void main(String[] args) {
        ArrayFlattening arrayFlattening = new ArrayFlattening();
        String[] res = arrayFlattening
                .concat(String.class, new String[]{"a", "b"}, "c", new String[]{"d", "e"});


        int[] result = arrayFlattening.concat2(int.class, 1, 2, 3, new int[]{4, 5, 6}, 7);

        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(res));
    }

    public <T> T concat(Class<?> type, Object... arguments) {
        if (arguments.length == 0) {
            return null;
        }

        int length = 0;
        for (Object argument : arguments) {
            if (argument.getClass().isArray()) {
                length += Array.getLength(argument);
            } else {
                length += 1;
            }
        }

        Object arr = Array.newInstance(type, length);

        int i = 0;
        for (Object argument : arguments) {
            if (argument.getClass().isArray()) {
                for (int i1 = 0; i1 < Array.getLength(argument); i1++) {
                    Array.set(arr, i++, Array.get(argument, i1));
                }
            } else {
                Array.set(arr, i++, argument);
            }
        }

        return (T) arr;
    }

    public <T> T concat2(Class<?> type, Object... arguments) {
        if (arguments.length == 0) {
            return null;
        }

        List<Object> elems = new ArrayList<>();
        for (Object argument : arguments) {
            if (argument.getClass().isArray()) {
                int len = Array.getLength(argument);

                for (int i = 0; i < len; i++) {
                    elems.add(Array.get(argument, i));
                }
            } else {
                elems.add(argument);
            }
        }

        Object res = Array.newInstance(type, elems.size());

        for (int i = 0; i < elems.size(); i++) {
            Array.set(res, i, elems.get(i));
        }

        return (T) res;
    }

}
