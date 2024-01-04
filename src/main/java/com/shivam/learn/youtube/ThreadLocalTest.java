package com.shivam.learn.youtube;


import java.text.SimpleDateFormat;
import java.util.Date;


class ThreadSafeFormatterJava8Syntax {

    // using factory method withInitial & lambdas
    public static ThreadLocal<SimpleDateFormat> df = ThreadLocal //
                                                                 .withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
}

class ThreadSafeFormatter {

    public static ThreadLocal<SimpleDateFormat> dateFormatter = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // called once for each thread
            return new SimpleDateFormat("yyyy-MM-dd");
        }

        @Override
        public SimpleDateFormat get() {
            // 1st call = initialValue(), subsequent calls will return same initialized value
            return super.get();
        }
    };
}


public class ThreadLocalTest {

    public static void main(String[] args) {
        // Do something
    }

    private String birthDate(int userId) {
        Date birthDate = birthDateFromDB(userId);
        // each thread will have its own copy
        final SimpleDateFormat df = ThreadSafeFormatter.dateFormatter.get();
        return df.format(birthDate);
    }

    private Date birthDateFromDB(int userId) {
        return new Date(); // sending dummy date
    }
}
