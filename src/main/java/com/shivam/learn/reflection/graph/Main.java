package com.shivam.learn.reflection.graph;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.shivam.learn.reflection.graph.annotations.Annotations.*;

/**
 * @author sksingh created on 14/01/24
 */
public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        /*
        BestGamesFinder bgf = new BestGamesFinder();

        List<String> bestGamesInDescendingOrder = execute(bgf);

        System.out.println(bestGamesInDescendingOrder);

        */


        SqlQueryBuilder sqlQB = new SqlQueryBuilder(
                List.of("1", "2", "3"),
                10,
                "Movies",
                List.of("Id, Name")
        );

        String finalQuery = execute(sqlQB);

        System.out.println(finalQuery);
    }

    @SuppressWarnings("unchecked")
    private static <T> T execute(Object instance) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = instance.getClass();

        Map<String, Method> operationToMethod = getOperationToMethod(clazz);
        Map<String, Field> inputToField = getInputToField(clazz);
        Method finalResultMethod = findFinalResultMethod(clazz);

        return (T) executeWithDependencies(instance, finalResultMethod, operationToMethod, inputToField);
    }

    private static Object executeWithDependencies(
            Object instance,
            Method currentMethod,
            Map<String, Method> operationToMethod,
            Map<String, Field> inputToField
    ) throws InvocationTargetException, IllegalAccessException {
        List<Object> parameters = new ArrayList<>(currentMethod.getParameterCount());

        for (Parameter parameter : currentMethod.getParameters()) {
            Object value = null;
            if (parameter.isAnnotationPresent(DependsOn.class)) {
                String operation = parameter.getAnnotation(DependsOn.class).value();
                Method method = operationToMethod.get(operation);

                value = executeWithDependencies(instance, method, operationToMethod, inputToField);
            } else if (parameter.isAnnotationPresent(Input.class)) {
                String fieldName = parameter.getAnnotation(Input.class).value();
                Field field = inputToField.get(fieldName);

                field.setAccessible(true);

                value = field.get(instance);
            }
            parameters.add(value);
        }

        return currentMethod.invoke(instance, parameters.toArray());
    }

    private static Map<String, Method> getOperationToMethod(Class<?> clazz) {
        Map<String, Method> operationNameToMethod = new HashMap<>();

        for (Method method : clazz.getDeclaredMethods()) {
            if (!method.isAnnotationPresent(Operation.class)) {
                continue;
            }

            Operation operation = method.getAnnotation(Operation.class);
            operationNameToMethod.put(operation.value(), method);
        }

        return operationNameToMethod;
    }

    private static Map<String, Field> getInputToField(Class<?> clazz) {
        Map<String, Field> inputToField = new HashMap<>();
        for (Field field : clazz.getDeclaredFields()) {
            if (!field.isAnnotationPresent(Input.class)) {
                continue;
            }

            Input input = field.getAnnotation(Input.class);
            inputToField.put(input.value(), field);
        }

        return inputToField;
    }

    private static Method findFinalResultMethod(Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(FinalResult.class)) {
                return method;
            }
        }

        throw new RuntimeException("No method found with FinalResult annotation");
    }
}
