package com.shivam.learn.reflection.annotation;

import com.shivam.learn.reflection.annotation.annotations.InitializerClass;
import com.shivam.learn.reflection.annotation.annotations.InitializerMethod;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sksingh created on 14/01/24
 */
public class Main {

    public static void main(String[] args) throws Throwable {

        initialize("com.shivam.learn.reflection.annotation.configs");
    }

    private static void initialize(
            String... packages
    ) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, URISyntaxException, IOException, ClassNotFoundException {
        List<Class<?>> classes = getAllClasses(packages);

        for (Class<?> clazz : classes) {
            if (!clazz.isAnnotationPresent(InitializerClass.class)) {
                continue;
            }

            List<Method> methods = getAllInitializingMethod(clazz);
            // Assuming all the classes has NoArgsConstructor
            Object instance = clazz.getDeclaredConstructor().newInstance();

            for (Method method : methods) {
                // Assuming all the methods don't have any arguments
                method.invoke(instance);
            }
        }
    }

    private static List<Method> getAllInitializingMethod(Class<?> clazz) {
        List<Method> initializingMethods = new ArrayList<>();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(InitializerMethod.class)) {
                initializingMethods.add(method);
            }
        }

        return initializingMethods;
    }

    private static List<Class<?>> getAllClasses(
            String... packages
    ) throws URISyntaxException, IOException, ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();

        for (String packageName : packages) {
            String packageRelativePath = packageName.replace(".", "/");

            // Fixme
            URI packageUri = Main.class.getResource(packageRelativePath).toURI();

            if (packageUri.getScheme().equals("file")) {
                Path path = Paths.get(packageUri);
                classes.addAll(getAllPackageClasses(path, packageName));
            } else if (packageUri.getScheme().equals("jar")) {
                FileSystem fileSystem = FileSystems.newFileSystem(packageUri, Collections.EMPTY_MAP);

                Path packageFullPathInJar = fileSystem.getPath(packageRelativePath);
                classes.addAll(getAllPackageClasses(packageFullPathInJar, packageName));

                fileSystem.close();
            }
        }

        return classes;
    }

    private static List<Class<?>> getAllPackageClasses(
            Path packagePath, String packageName
    ) throws IOException, ClassNotFoundException {
        if (!Files.exists(packagePath)) {
            return Collections.emptyList();
        }

        List<Path> files = Files.list(packagePath)
                .filter(Files::isRegularFile)
                .toList();

        List<Class<?>> classes = new ArrayList<>();

        for (Path file : files) {
            String fileName = file.getFileName().toString();

            if (fileName.endsWith(".class")) {
                String classFullName = packageName + "." + fileName.replaceFirst("\\.class$", "");
                Class<?> clazz = Class.forName(classFullName);

                classes.add(clazz);
            }
        }

        return classes;
    }

}
