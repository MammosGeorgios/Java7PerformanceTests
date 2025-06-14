package gr.mammos.practice.java7performance.scenario.isempty;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Fork(3)
@Threads(4)
@State(Scope.Benchmark)
public class IsEmptyString {


    // Current implementation is similar to this
    public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        }

        if (object instanceof String) {
            return ((String) object).trim().length() == 0;
        }

        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static boolean isEmptyWithoutAlwaysTrimming(Object object) {
        if (object == null) {
            return true;
        }

        if (object instanceof String) {
            return ((String) object).length() == 0  || ((String) object).trim().length() == 0;
        }

        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Benchmark
    public static void nullObject_originalMethod(Blackhole blackhole) {
        blackhole.consume(isEmpty(null));
    }

    @Benchmark
    public static void emptyString_originalMethod(Blackhole blackhole) {
        blackhole.consume(isEmpty(""));
    }

    @Benchmark
    public static void emptyStringWithWhitespace_originalMethod(Blackhole blackhole) {
        blackhole.consume(isEmpty("   "));
    }

    @Benchmark
    public static void notEmptyString_originalMethod(Blackhole blackhole) {
        blackhole.consume(isEmpty(" 1 "));
    }

    @Benchmark
    public static void nullObject_withoutAlwaysTrimmingMethod(Blackhole blackhole) {
        blackhole.consume(isEmpty(null));
    }

    @Benchmark
    public static void emptyString_withoutAlwaysTrimmingMethod(Blackhole blackhole) {
        blackhole.consume(isEmpty(""));
    }

    @Benchmark
    public static void emptyStringWithWhitespace_withoutAlwaysTrimmingMethod(Blackhole blackhole) {
        blackhole.consume(isEmpty("   "));
    }

    @Benchmark
    public static void notEmptyString_withoutAlwaysTrimmingMethod(Blackhole blackhole) {
        blackhole.consume(isEmpty(" 1 "));
    }


}
