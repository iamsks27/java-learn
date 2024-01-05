package com.shivam.learn.lomboktest;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author sksingh created on 05/01/24
 */
@ToString
public class LazyGetter {

    private static final String DELIMITER = ",";

    @Getter(lazy = true)
    private final Map<String, Long> transactions = loadTransactions();

    private Map<String, Long> loadTransactions() {
        final Map<String, Long> cache = new HashMap<>();
        List<String> txnRows = readTxnListFromFile();

        txnRows.forEach(s -> {
            String[] txnIdValueTuple = s.split(DELIMITER);
            cache.put(txnIdValueTuple[0], Long.parseLong(txnIdValueTuple[1]));
        });

        return cache;
    }

    private List<String> readTxnListFromFile() {

        // read large file
        return Stream.of("John,1").collect(Collectors.toList());
    }

    public static void main(String[] args) {
        LazyGetter lg = new LazyGetter();
        // System.out.println(lg.transactions.get("John")); //  error: method get in class AtomicReference<V> cannot be applied to given types
        System.out.println(lg.transactions); // This will be null because it's not yet set.
        System.out.println(lg.getTransactions());
    }
}
