package com.shivam.learn.reflection.repeatableannotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author sksingh created on 14/01/24
 */
public class Exercise {

    enum Role {
        CLERK,
        MANAGER,
        SUPPORT_ENGINEER
    }

    enum OperationType {
        READ,
        WRITE,
        DELETE
    }

    @Target(ElementType.TYPE)
    @Repeatable(PermissionsContainer.class)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Permissions {

        Role role();

        OperationType[] allowed();
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface MethodOperations {

        OperationType[] value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface PermissionsContainer {

        Permissions[] value();
    }

    public class User {

        private final String name;
        private final Role role;

        public User(String name, Role role) {
            this.name = name;
            this.role = role;
        }

        public Role getRole() {
            return role;
        }
    }

    /**
     * Checks that the logged-in user in the callerObject has the right permissions to perform the operations
     * in the caller method.
     * Throws PermissionException if the user is not authorized to perform those operations based on the user's
     * role
     */
    public static void checkPermissions(Object callerObject, String callerMethodName) throws Throwable {
        // DO NOT MODIFY THIS METHOD
        User user = getLoggedInUser(callerObject);
        Method callingMethod = getCallingMethod(callerObject, callerMethodName);
        Permissions[] allPermissions = getClassAnnotatedPermissions(callerObject);
        MethodOperations methodOperations = getCallerMethodOperations(callingMethod);

        OperationType[] methodOperationTypes = methodOperations.value();

        List<OperationType> userAllowedOperations = findUserAllowedOperations(allPermissions, user);

        for (OperationType methodOperationsTypes : methodOperationTypes) {
            if (!userAllowedOperations.contains(methodOperationsTypes)) {
                throw new RuntimeException("User is not allowed to perform the operation");
            }
        }
    }

    /**
     * Returns a List of all OperationTypes that the logged-in user is allowed to perform
     * If the user has no permissions in the allPermissions, an empty list should be returned
     */
    static List<OperationType> findUserAllowedOperations(Permissions[] allPermissions, User user) {
        /**
         * Complete the code here
         */
        for (Permissions permissions : allPermissions) {
            if (permissions.role().equals(user.getRole())) {
                return Arrays.asList(permissions.allowed());
            }
        }

        return Collections.emptyList();
    }

    /**
     * Returns all the Permissions annotations the callerObject's class is annotated with
     */
    static Permissions[] getClassAnnotatedPermissions(Object callerObject) {
        /**
         * Complete the code here
         */

        return callerObject.getClass().getAnnotationsByType(Permissions.class);
    }

    /**
     * Returns the MethodOperations annotation that the callerMethod is annotated with
     */
    static MethodOperations getCallerMethodOperations(Method callerMethod) {
        /**
         * Complete the code here
         */
        return callerMethod.getAnnotation(MethodOperations.class);
    }

    //********************* Helper Methods ******************************/

    /**
     * Returns the User object representing the logged-in user
     */
    private static User getLoggedInUser(Object callerObject) throws NoSuchFieldException, IllegalAccessException {
        // DO NOT MODIFY THIS METHOD
        Class<?> callerClass = callerObject.getClass();
        Permissions[] annotationsByType = callerClass.getAnnotationsByType(Permissions.class);

        Field userField = callerClass.getDeclaredField("user");

        userField.setAccessible(true);

        if (!userField.getType().equals(User.class)) {
            throw new IllegalStateException("The caller object must have a user field of type User");
        }

        return (User) userField.get(callerObject);
    }

    /**
     * Returns the Method object of the callerObject's class corresponding to the methodName
     */
    private static Method getCallingMethod(Object callerObject, String methodName) {
        // DO NOT MODIFY THIS METHOD
        return Arrays.stream(callerObject.getClass().getDeclaredMethods())
                .filter(method -> method.getName().equals(methodName))
                .findFirst()
                .orElseThrow(()
                                     -> new IllegalStateException(
                        String.format("The passed method name :%s does not exist", methodName)));
    }
}
