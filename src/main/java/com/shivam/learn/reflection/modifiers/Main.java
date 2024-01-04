package com.shivam.learn.reflection.modifiers;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author sksingh created on 04/01/24
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        // runAuction();
        // printClassModifier(Auction.class);
        // printClassModifier(Bid.class);
        // printClassModifier(Bid.Builder.class);
        // printClassModifier(Class.forName("com.shivam.learn.reflection.modifiers.Bid$Builder$BidImpl"));
        printMethodModifiers(Auction.class.getDeclaredMethods());
        printFieldsModifiers(Auction.class.getDeclaredFields());
    }

    private static void printFieldsModifiers(Field[] fields) {
        for (Field field : fields) {
            int modifiers = field.getModifiers();

            System.out.printf("Field \"%s\" access modifier is %s", field.getName(), getAccessModifierName(modifiers));

            if (Modifier.isStatic(modifiers)) {
                System.out.println("The field is static");
            }

            if (Modifier.isVolatile(modifiers)) {
                System.out.println("The field is volatile");
            }

            if (Modifier.isTransient(modifiers)) {
                System.out.println("The field is transient");
            }

            if (Modifier.isFinal(modifiers)) {
                System.out.println("The field is final");
            }
        }
    }

    private static void printMethodModifiers(Method[] methods) {
        for (Method method : methods) {
            int modifiers = method.getModifiers();

            System.out.printf("%s() access modifier is %s%n", method.getName(), getAccessModifierName(modifiers));

            if (Modifier.isSynchronized(modifiers)) {
                System.out.println("This method is synchronised");
            } else {
                System.out.println("This method is not synchronised");
            }

            System.out.println();
        }
    }

    private static void printClassModifier(Class<?> clazz) {
        int modifiers = clazz.getModifiers();
        System.out.printf("Class %s access modifier is %s%n", clazz.getSimpleName(), getAccessModifierName(modifiers));

        if (Modifier.isAbstract(modifiers)) {
            System.out.println("This class is abstract");
        }

        if (Modifier.isInterface(modifiers)) {
            System.out.println("This class is interface");
        }

        if (Modifier.isStatic(modifiers)) {
            System.out.println("This class is static");
        }
    }

    private static String getAccessModifierName(int modifier) {
        if (Modifier.isPublic(modifier)) {
            return "public";
        } else if (Modifier.isPrivate(modifier)) {
            return "private";
        } else if (Modifier.isProtected(modifier)) {
            return "protected";
        } else {
            return "package-private";
        }
    }

    public static void runAuction() {
        Auction auction = new Auction();
        auction.startAuction();

        Bid bid1 = Bid.builder()
                .setBidderName("Company1")
                .setPrice(10)
                .build();
        auction.addBid(bid1);

        Bid bid2 = Bid.builder()
                .setBidderName("Company2")
                .setPrice(12)
                .build();
        auction.addBid(bid2);

        auction.stopAuction();

        System.out.println(auction.getAllBids());
        System.out.println("Highest bid: " + auction.getHighestBid().get());
    }
}
