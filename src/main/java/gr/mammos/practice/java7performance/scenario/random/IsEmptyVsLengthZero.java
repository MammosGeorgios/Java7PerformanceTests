package gr.mammos.practice.java7performance.scenario.random;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 50, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Fork(3)
@State(Scope.Benchmark)
public class IsEmptyVsLengthZero {


    @Benchmark
    public static void isEmpty(Blackhole blackhole) {
        blackhole.consume("Test".isEmpty());
    }

    @Benchmark
    public static void lengthZero(Blackhole blackhole) {
        blackhole.consume("Test".length() == 0);
    }


}
