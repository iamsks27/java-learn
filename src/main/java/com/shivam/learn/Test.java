package com.shivam.learn;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static final String FNI_DESC_PREFIX = "<ul><li>";
    public static final String FNI_DESC_SUFFIX = "</li></ul>";
    public static final String FNI_DESC_DELIMITER = "</li><li>";
    public static final String PHONE_NUMBER_REGEX = "^[1-9](\\d){9}$";

    private static final Set<String> SUPPORTED_DOMAIN;
    private static final Set<String> SUPPORTED_DOMAINS;
    private static final Set<String> PROD_CLUSTER_TYPE;

    static {
        SUPPORTED_DOMAINS = new HashSet<>();
        PROD_CLUSTER_TYPE = new HashSet<>();
        SUPPORTED_DOMAINS.add("gm-drp-godbox.tekioncloud.com");
        SUPPORTED_DOMAINS.add("gm-drp-t3-godbox.tekioncloud.com");
        PROD_CLUSTER_TYPE.add("prod_cloud");
        PROD_CLUSTER_TYPE.add("crb_prod_cloud");
    }

    static {
        SUPPORTED_DOMAIN = new HashSet<>();
        SUPPORTED_DOMAIN.add("gm-drp-godbox.tekioncloud.com");
        SUPPORTED_DOMAIN.add("https://gm-drp-t3-godbox.tekioncloud.com/");
    }

    public static void main(String[] args) throws IOException {
        //        final List<Term> terms = new ArrayList<>();
        //        Term t;
        //        t = new Term("SALES_TAX", 48, 12.0, 1234.23);
        //        terms.add(t);
        //        t = new Term("MONTHLY_USE_TAX", 36, 32.0, 3442.0);
        //        terms.add(t);
        //        t = new Term("CCR_TAX", 39, 98.9, 38340.93);
        //        terms.add(t);
        //        t = new Term("SALES_TAX", 39, 9.9, 340.93);
        //        terms.add(t);

        //        System.out.println(terms);
        //
        //        terms.sort(Comparator.comparing(Term::getTerm));
        //
        //        System.out.println(terms);

        //        final Optional<Term> salesTerm = terms.stream()
        //                                              .filter(term -> "SALES_TAX".equals(term.getType()))
        //                                              .findFirst();
        //
        //        if (salesTerm.isPresent()) {
        //            System.out.println(salesTerm.get());
        //        } else {
        //            System.out.println("sales term not present");
        //        }

        //        BigDecimal bd = BigDecimal.valueOf(1);
        //        BigDecimal bd1 = BigDecimal.ZERO;
        //        if (bd1.compareTo(BigDecimal.ZERO) < 1) {
        //            System.out.println("yes bd is less");
        //        } else {
        //            System.out.println("bd is more");
        //        }

        //        Double x = 2d;
        //        if (x == 0.0d) {
        //            System.out.println(true);
        //        } else {
        //            System.out.println(false);
        //        }
        //        System.out.println(x * -1);
        //        x = -1 * x;
        //        System.out.println(BigDecimal.valueOf(x));

        //        BigDecimal x = BigDecimal.valueOf(10);
        //        BigDecimal y = BigDecimal.valueOf(9);
        //        System.out.println(y.subtract(x));

        //String zipCode = "95101-95103+95106+95108-95113+95115-95136+95138-95139+95141+95148+95150-95161+95164+95170+95172-95173+95190-95194+95196";
        //        String zipCode = "95101,";
        //        String[] zips = zipCode.split("[,+-]");
        //        System.out.println(zips.length);
        //        System.out.println(zips[0]);

        //        final Boolean isTaxable = true;
        //        //for accessory, isTaxable should always be true.
        //        //for onStar(passed as accessories), it can be true or false depend on zipcode
        //        System.out.println(isNull(isTaxable) || isTaxable);

        //        BigDecimal value = new BigDecimal(1.1d);
        //        System.out.println(value);

        //        List<String> descriptions = new ArrayList<>();
        //        descriptions.add("test1");
        //        System.out.println(getFormattedDescription(descriptions));
        //
        //        descriptions.add("test2");
        //        System.out.println(getFormattedDescription(descriptions));
        //
        //        System.out.println(getFormattedDescription(null));

        //        final Map<Object, Object> emptyMap = Collections.emptyMap();
        //        System.out.println(emptyMap.getOrDefault("Hello", "World"));
        //        System.out.println(emptyMap.get(null));

        //        List<String> names = new ArrayList<>();
        //        names.add("shivam");
        //        names.add("kumar");
        //        System.out.println(String.join(", ", names));
        //        System.out.println("".matches(PHONE_NUMBER_REGEX));
        //
        //        Float f = 23.09f;
        //        try {
        //            System.out.println(Long.valueOf(null));
        //        } catch (Exception e) {
        //            System.out.println(getStackTraceString(e));
        //        }

        // System.out.printf("dealerBac: %s,\ntrace: %s%n", "12345", "Hey there is an exception");

        //        printJson(new Person("Shivam", 23));
        //
        //        String origin = "";
        //        String origin1 = null;
        //        String origin2 = "gm-drp-godbox.tekioncloud.com";
        //        String origin3 = "gm-drp";
        //
        //        System.out.println(SUPPORTED_DOMAIN.contains(origin));
        //        System.out.println(SUPPORTED_DOMAIN.contains(origin1));
        //        System.out.println(SUPPORTED_DOMAIN.contains(origin2));
        //        System.out.println(SUPPORTED_DOMAIN.contains(origin3));

        //        System.out.println(isGodModeEnabled(null, "tst_cloud"));
        //        System.out.println(isGodModeEnabled(null, "stage_cloud"));
        //        System.out.println(isGodModeEnabled(null, "preprod_cloud"));
        //        System.out.println(isGodModeEnabled("drpdev.tekion.xyz", "tst_cloud"));
        //        System.out.println(isGodModeEnabled("drpstage.tekion.xyz", "stage_cloud"));
        //        System.out.println(isGodModeEnabled("drppreprod.tekion.xyz", "preprod_cloud"));
        //        System.out.println(isGodModeEnabled(null, "crb_tst_cloud"));
        //        System.out.println(isGodModeEnabled(null, "crb_stage_cloud"));
        //        System.out.println(isGodModeEnabled(null, "crb_preprod_cloud"));
        //        System.out.println(isGodModeEnabled("drpdev.tekion.xyz", "crb_tst_cloud"));
        //        System.out.println(isGodModeEnabled("drpstage.tekion.xyz", "crb_stage_cloud"));
        //        System.out.println(isGodModeEnabled("drppreprod.tekion.xyz", "crb_preprod_cloud"));
        //        System.out.println(isGodModeEnabled("gm-drp-godbox.tekioncloud.com", "prod_cloud"));
        //        System.out.println(isGodModeEnabled("gm-drp-t3-godbox.tekioncloud.com", "prod_cloud"));
        //        System.out.println(isGodModeEnabled("gm-drp.tekioncloud.xyz", "prod_cloud"));
        //        System.out.println(isGodModeEnabled("gm-drp.tekioncloud.com", "prod_cloud"));
        //        System.out.println(isGodModeEnabled("chevy.electric.com", "prod_cloud"));
        //        System.out.println(isGodModeEnabled("gm-drp.tekioncloud.com", null));

        //        System.out.println(formattedZipCode("12345678"));
        //        System.out.println(formattedZipCode("12345"));
        //        System.out.println(formattedZipCode("123"));
        //        System.out.println(formattedZipCode("  "));
        //        System.out.println(formattedZipCode(null));
        //        Long amount = null;
        //        System.out.println(BigDecimal.valueOf(amount));


        //        Object obj = null;
        //        System.out.println("Start converting");
        //        final String s = MAPPER.writeValueAsString(obj);
        //        System.out.println("Done converting, " + s);
        //
        //        System.out.println(BigDecimal.valueOf(0));
        //
        //        long zipCode = 832L;

        //        List<String> list = new CopyOnWriteArrayList<>(); // mutable & thread-safe implementation of List.
        //        list.add("Hello");
        //
        //        List<String> collect = Stream.of("Hello", "World")
        //                .collect(Collectors.toList());
        //
        //        collect.add("Bharat!!!");
        //
        //        System.out.println(collect);


        //        String prefixOne = "My-Random-UUID-PrefixO";
        //        String prefixTwo = "My-Random-UUID-PrefixT";
        //
        //        System.out.println(
        //                UUID.nameUUIDFromBytes(prefixOne.getBytes()).equals(
        //                        UUID.nameUUIDFromBytes(prefixTwo.getBytes()))
        //        );


        //        for (int i = 0; i < 10_000_000; i++) {
        //            UUID uuid_1 = UUID.nameUUIDFromBytes(prefix.getBytes());
        //            UUID uuid_2 = UUID.nameUUIDFromBytes(prefix.getBytes());
        //
        //            if (!uuid_1.equals(uuid_2)) {
        //                System.out.printf("uuid_1 %s doesn't match with uuid_2 %s\n", uuid_1, uuid_2);
        //            }
        //        }
        //
        //        System.out.printf("All the uuids generated using prefix %s are matching", prefix);

//        Optional<Stream<Integer>> intStream = Optional.of(Stream.of(1, 2, 3, 4, 5));
//
//        int sum = 0;
//
//        intStream.ifPresent((numbers) -> numbers.reduce(sum, Integer::sum));
//
//        System.out.println(sum);
//
//        List<Integer> list = new ArrayList<>();
//        intStream.ifPresent(numbers -> list.addAll(numbers.map(i -> i * 2).toList()));
//
//        System.out.println(list);
    }

    private static String formattedZipCode(String zipCode) {
        String formattedZipCode = zipCode;
        if (zipCode != null && !zipCode.isEmpty() && zipCode.length() > 5) {
            formattedZipCode = zipCode.substring(0, 5);
        }
        return formattedZipCode;
    }

    private static String isGodModeEnabled(String origin, String clusterTYpe) {
        boolean disabled = disabledTracing(origin, clusterTYpe);
        return disabled ? "false" : "true";
    }

    private static boolean disabledTracing(String origin, String clusterType) {
        if (clusterType != null) {
            return PROD_CLUSTER_TYPE.contains(clusterType.toLowerCase()) && !SUPPORTED_DOMAINS.contains(origin);
        }
        return true;
    }

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static void printJson(Object param) throws IOException {
        System.out.println(MAPPER.writeValueAsString(param));
    }

    public static String getStackTraceString(Throwable t) {
        StringBuilder sb = new StringBuilder();
        StringWriter out = new StringWriter();
        t.printStackTrace(new PrintWriter(out));
        sb.append(out.toString());
        return sb.toString();
    }

    private static String getFormattedDescription(List<String> descriptions) {
        String formattedDescription = "";
        if (Objects.nonNull(descriptions)) {
            formattedDescription = FNI_DESC_PREFIX + String.join(FNI_DESC_DELIMITER, descriptions) + FNI_DESC_SUFFIX;
        }
        return formattedDescription;
    }

    private static String getOfferType(String name) {
        final String[] names = name.split("\\s+");
        if (names.length > 0) {
            return Arrays.stream(names).map(String::toLowerCase).collect(Collectors.joining("_"));
        }
        return "";
    }
}
