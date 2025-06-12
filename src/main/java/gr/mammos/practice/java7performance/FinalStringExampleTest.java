package gr.mammos.practice.java7performance;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

public class FinalStringExampleTest {


//    Benchmark                           Mode  Cnt  Score   Error  Units
//    FinalExample.concatFinalStrings     avgt    5  0,384 ± 0,015  ns/op
//    FinalExample.concatNonFinalStrings  avgt    5  4,335 ± 0,093  ns/op

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1, warmups = 1)
    public static void concatNonFinalStrings(Blackhole blackhole) {
        String x = "x";
        String y = "y";
        blackhole.consume(x + y);
    }


    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1, warmups = 1)
    public static void concatFinalStrings(Blackhole blackhole) {
        final String x = "x";
        final String y = "y";
        blackhole.consume(x + y);
    }
}
