package com.shivam.learn.exception;

/**
 * @author sksingh created on 16/02/24
 */
public class Test {

    public static void main(String[] args) throws Exception {
        try {
            throw new NullPointerException("NPE occurred");
        } catch (NullPointerException e) {
            System.out.println("NPE");
            throw new RuntimeException("Runtime exception happened");
        } catch (Exception e) {
            System.out.println("Exception");
            throw new Exception("Exception");
        }
    }
}
