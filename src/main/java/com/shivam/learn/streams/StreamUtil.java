package com.shivam.learn.streams;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author sksingh created on 06/02/24
 */
public class StreamUtil {

    public static <T> Stream<IndexedValue<T>> withIndices(List<T> list) {
        return IntStream.range(0, list.size())
                .mapToObj(idx -> new IndexedValue<>(idx, list.get(idx)));
    }

    public static <T1, T2, R> Stream<R> zip(
            List<T1> list1, List<T2> list2,
            BiFunction<? super T1, ? super T2, ? extends R> mapper
    ) {
        int size = list1.size();

        if (list2.size() != size) {
            throw new IllegalArgumentException("Different list sizes");
        }

        return IntStream.range(0, size)
                .mapToObj(idx -> mapper.apply(list1.get(idx), list2.get(idx)));
    }


    public static <T> Stream<Supplier<Stream<T>>> streamOfStreamSuppliers(List<List<T>> input) {
        return input.stream()
                .map(list -> list::stream);
    }
}
