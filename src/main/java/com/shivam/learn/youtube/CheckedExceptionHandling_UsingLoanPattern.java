package com.shivam.learn.youtube;

import java.io.*;

public class CheckedExceptionHandling_UsingLoanPattern {

    private static final int BUFFER_SIZE = 4096;

    //    public byte[] readFile(String fileName) throws IOException {
    //        try (FileInputStream file = new FileInputStream(fileName)) {
    //            byte[] buffer = new byte[4096];
    //            final ByteArrayOutputStream out = new ByteArrayOutputStream(buffer.length);
    //            int n = 0;
    //            while ((n = file.read(buffer)) > 0) {
    //                out.write(buffer, 0, n);
    //            }
    //            return out.toByteArray();
    //        }
    //    }

    public byte[] readFileUsingLoanPattern(String fileName) throws IOException {
        return withFile(fileName, file -> {
            byte[] buffer = new byte[4096];
            final ByteArrayOutputStream out = new ByteArrayOutputStream(buffer.length);
            int n = 0;
            while ((n = file.read(buffer)) > 0) {
                out.write(buffer, 0, n);
            }
            return out.toByteArray();
        });
    }

    static <T> T withFile(String fileName, ThrowingFunction<FileInputStream, T> consumer) throws IOException {
        try (FileInputStream file = new FileInputStream(fileName)) {
            return consumer.apply(file);
        }
    }

    static void copy(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src); //
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buff = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buff)) >= 0) {
                out.write(buff, 0, n);
            }
        }
    }
}

@FunctionalInterface
interface ThrowingFunction<T, R> {

    R apply(T t) throws IOException;
}
