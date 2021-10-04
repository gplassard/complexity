package fr.gplassard.complexity;

import org.openjdk.jmh.annotations.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Fork(value = 1)
@Warmup(time = 2, timeUnit = TimeUnit.SECONDS, iterations = 1)
@Measurement(time = 2, timeUnit = TimeUnit.SECONDS, iterations = 5)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class CollectionsBenchmark {
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    private static final List<Integer> LIST_10 = IntStream.range(0, 10).boxed().collect(Collectors.toList());
    private static final List<Integer> LIST_10_000 = IntStream.range(0, 10_000).boxed().collect(Collectors.toList());
    private static final List<Integer> LIST_10_000_000 = IntStream.range(0, 10_000_000).boxed().collect(Collectors.toList());

    private static final List<Integer> LIST_10_INVERTED = IntStream.range(0, 10).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    private static final List<Integer> LIST_10_000_INVERTED = IntStream.range(0, 10_000).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    private static final List<Integer> LIST_10_000_000_INVERTED = IntStream.range(0, 10_000_000).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

    private static final Set<Integer> SET_10 = IntStream.range(0, 10).boxed().collect(Collectors.toSet());
    private static final Set<Integer> SET_10_000 = IntStream.range(0, 10_000).boxed().collect(Collectors.toSet());
    private static final Set<Integer> SET_10_000_000 = IntStream.range(0, 10_000_000).boxed().collect(Collectors.toSet());

    @Benchmark
    public List<Integer> sortList_10() {
        return LIST_10_INVERTED.stream().sorted().collect(Collectors.toList());
    }
    @Benchmark
    public List<Integer> sortList_10_000() {
        return LIST_10_000_INVERTED.stream().sorted().collect(Collectors.toList());
    }
    @Benchmark
    public List<Integer> sortList_10_000_000() {
        return LIST_10_000_000_INVERTED.stream().sorted().collect(Collectors.toList());
    }


    @Benchmark
    public boolean findInList_10() {
        return LIST_10.contains(-1);
    }
    @Benchmark
    public boolean findInList_10_000() {
        return LIST_10_000.contains(-1);
    }
    @Benchmark
    public boolean findInList_10_000_000() {
        return LIST_10_000_000.contains(-1);
    }


    @Benchmark
    public boolean findInList_10_binary() {
        return Collections.binarySearch(LIST_10, -1) <= 0;
    }
    @Benchmark
    public boolean findInList_10_000_binary() {
        return Collections.binarySearch(LIST_10_000, -1) <= 0;
    }
    @Benchmark
    public boolean findInList_10_000_000_binary() {
        return Collections.binarySearch(LIST_10_000_000, -1) <= 0;
    }


    @Benchmark
    public boolean findInSet_10() {
        return SET_10.contains(-1);
    }
    @Benchmark
    public boolean findInSet_10_000() {
        return SET_10_000.contains(-1);
    }
    @Benchmark
    public boolean findInSet_10_000_000() {
        return SET_10_000_000.contains(-1);
    }
}
