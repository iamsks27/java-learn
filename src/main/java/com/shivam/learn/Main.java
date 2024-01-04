package com.shivam.learn;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

class Year {

    Integer yearId;

    public Year(Integer yearId) {
        this.yearId = yearId;
    }

    public Integer getYearId() {
        return yearId;
    }

    public void setYearId(Integer yearId) {
        this.yearId = yearId;
    }
}

public class Main {

    private static final ObjectMapper MAPPER = newDefaultMapper();

    public static ObjectMapper newDefaultMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    public static void main(String[] args) {
//        System.out.println("Testing...");
//
//        List<String> sourcePricings = null;
//        for (final String sourcePricing : sourcePricings) {
//            System.out.println("Yes");
//        }

//        String d1 = "02/13/2019 07:24:50";
//        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
//        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MMMM yyyy");
//        String format = dtf2.format(LocalDate.parse(d1, dtf1));
//        System.out.println(format);

//        String collect = Stream.of("Shivam", "", null)
//                               .filter(name -> name != null && !name.isEmpty())
//                               .collect(Collectors.joining(" "));
//
//        System.out.println(collect);
//        System.out.println(collect.length());

//        List<Year> years = new ArrayList<>();
//        years.add(new Year(10));
//        years.add(new Year(11));
//        years.add(new Year(1));
//        years.add(new Year(5));
//        years.add(new Year(15));
//
//        List<Integer> yearId = years.stream()
//                                     .map(Year::getYearId)
//                                     .sorted(Comparator.reverseOrder())
//                                     .collect(Collectors.toList());

//        final int expected = 50;
//        System.out.println(expected);
//        System.out.println(yearId);

//        final Map<String, String> map = new HashMap<>();
//        map.put("name", "shivam");
//        System.out.println(map.get(null));

//        Student s1 = new Student("shivam", "29");
//        Student s2 = new Student("priyanka", "25");
//
//        final Map<String, Student> sMap = new HashMap<>();
//        sMap.put("shivam", s1);
//        sMap.put("priyanka", s2);
//
////        sMap.get("shivam")
////            .setAge("30");
//
//
//        System.out.println(toJson(sMap));

//        int[] arr = null;
//
//        Long cents = 10000L;
//
//        System.out.println(Double.valueOf(cents));

//       BigDecimal d = BigDecimal.valueOf(0.000129);
//
//        System.out.println(d.doubleValue());

//        System.out.println(getCountryCode("05125050303"));
//        System.out.println(getPhoneNumber("05125050303"));
//        System.out.println(getCountryCode("5125050303"));
//        System.out.println(getPhoneNumber("5125050303"));
//        System.out.println(getCountryCode("+15125050303"));
//        System.out.println(getPhoneNumber("+15125050303"));
//        System.out.println(getCountryCode("+915125050303"));
//        System.out.println(getPhoneNumber("+915125050303"));
//        System.out.println(getCountryCode(null));
//        System.out.println(getPhoneNumber(null));
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
                                                             .withZone(ZoneId.from(ZoneOffset.UTC));
        final String date = formatter.format(Instant.now());
        System.out.println(date);
    }

    public static String toJson(Object obj) {
        String json = "";
        if (obj != null) {
            try {
                json = MAPPER.writeValueAsString(obj);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return json;
    }

    static class Student {

        String name;
        String age;

        public Student(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" + "name='" + name + '\'' + ", age='" + age + '\'' + '}';
        }
    }

    private static String getCountryCode(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            final int phoneLength = phoneNumber.length();
            if (phoneLength == 10) {
                return ""; //Check if we have to throw an exception
            } else if (phoneLength >= 10) {
                return phoneNumber.substring(0, phoneLength - 10);
            } else {
                System.out.println("Wrong phone number");
            }
        }
        return null;
    }

    private static String getPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            final int phoneLength = phoneNumber.length();
            if (phoneLength == 10) {
                return phoneNumber; //check if we have to throw an exception
            } else if (phoneLength >= 10) {
                return phoneNumber.substring(phoneLength - 10);
            } else {
                System.out.println("Wrong phone number");
            }
        }
        return null;
    }
}
