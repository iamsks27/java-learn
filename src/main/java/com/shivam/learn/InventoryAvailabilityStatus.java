package com.shivam.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum InventoryStatus {

    Flt_Intrans("IN TRANSIT", ""),
    Rtl_Intrans("IN TRANSIT", ""),
    Fleet_Demo("AVAILABLE NOW", "DEMO"),
    Retail_Demo("AVAILABLE NOW", "DEMO"),
    RtlStkCTP("AVAILABLE NOW", "DEMO"),
    RtlStkDrvEd("AVAILABLE NOW", "DEMO"),
    Dlr_Flt_Grd("AVAILABLE NOW", ""),
    Dlr_Rtl_Grd("AVAILABLE NOW", "");

    private final String description;
    private final String tag;

    private static List<String> statusesAllowed = new ArrayList<>();
    private static List<String> availableStatus = new ArrayList<>();

    InventoryStatus(String s, String s1) {
        this.description = s;
        this.tag = s1;
    }


    public static List<String> allowedStatusList() {
        if (statusesAllowed.isEmpty()) {
            statusesAllowed = Stream
                    .of(InventoryStatus.values())
                    .map(Enum::name)
                    .collect(Collectors.toList());
        }
        return statusesAllowed;
    }

    public static List<String> availableStatuses() {
        if (availableStatus.isEmpty()) {
            availableStatus = Stream
                    .of(InventoryStatus.values())
                    .filter(status -> "AVAILABLE NOW".equals(status.description))
                    .map(Enum::name)
                    .collect(Collectors.toList());
        }
        return availableStatus;
    }

    public static String getInventoryAvailabilityStatusDesc(String status) {
        for (InventoryStatus invStatus : InventoryStatus.values()) {
            if (invStatus.name().equals(status)) {
                return invStatus.description;
            }
        }
        return null;
    }

    public static String getInventoryAvailabilityStatusTag(String status) {
        for (InventoryStatus invStatus : InventoryStatus.values()) {
            if (invStatus.name().equals(status)) {
                return invStatus.tag;
            }
        }
        return null;
    }
}

public class InventoryAvailabilityStatus {

    public static void main(String[] args) {
        System.out.println(InventoryStatus.availableStatuses());
        System.out.println(InventoryStatus.allowedStatusList());
        String[] names = new String[8];
        int i = 0;
        for (final InventoryStatus value : InventoryStatus.values()) {
            names[i++] = value.name();
        }
        Arrays.sort(names);
        for (final String name : names) {
            System.out.print(name + ", ");
        }
    }
}