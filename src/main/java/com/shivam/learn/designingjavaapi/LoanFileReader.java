package com.shivam.learn.designingjavaapi;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author sksingh created on 28/08/23
 */
public class LoanFileReader {

    public static <R> R withFile(String filename, ThrowingFunction<FileInputStream, R> fn) throws IOException {
        try (FileInputStream file = new FileInputStream(filename)) {
            return fn.apply(file);
        }
    }
}
