package gr.mammos.practice.java7performance.scenario.random;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 25, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Fork(3)
//@Threads(4)
@State(Scope.Benchmark)
public class StringConcatForLogging {


//    Benchmark        @Threads(4)                                Mode  Cnt     Score    Error  Units
//    StringConcatForLogging.concat                               avgt   75   973,296 �  4,346  ns/op
//    StringConcatForLogging.concatWithFinalStrings               avgt   75  1059,428 � 13,137  ns/op
//    StringConcatForLogging.plusOperator                         avgt   75   626,875 �  5,871  ns/op   <---
//    StringConcatForLogging.plusOperatorWithFinalStrings         avgt   75   688,821 �  5,556  ns/op
//    StringConcatForLogging.stringBuffer                         avgt   75   621,987 �  3,946  ns/op
//    StringConcatForLogging.stringBufferWithInitialCapacity128   avgt   75   688,224 �  3,843  ns/op
//    StringConcatForLogging.stringBufferWithInitialCapacity512   avgt   75   769,368 �  5,375  ns/op
//    StringConcatForLogging.stringBuilder                        avgt   75   614,262 �  3,448  ns/op   <---
//    StringConcatForLogging.stringBuilderWithInitialCapacity128  avgt   75   677,824 �  3,412  ns/op
//    StringConcatForLogging.stringBuilderWithInitialCapacity512  avgt   75   680,797 �  3,717  ns/op


//    Benchmark        No @Threads                                Mode  Cnt    Score    Error  Units
//    StringConcatForLogging.concat                               avgt   75  386,207 �  1,865  ns/op
//    StringConcatForLogging.concatWithFinalStrings               avgt   75  422,533 �  1,905  ns/op
//    StringConcatForLogging.plusOperator                         avgt   75  292,480 �  2,347  ns/op    <---
//    StringConcatForLogging.plusOperatorWithFinalStrings         avgt   75  351,010 � 18,930  ns/op
//    StringConcatForLogging.stringBuffer                         avgt   75  320,026 � 16,437  ns/op
//    StringConcatForLogging.stringBufferWithInitialCapacity128   avgt   75  327,689 � 12,804  ns/op
//    StringConcatForLogging.stringBufferWithInitialCapacity512   avgt   75  372,565 � 19,373  ns/op
//    StringConcatForLogging.stringBuilder                        avgt   75  295,428 �  3,058  ns/op    <---
//    StringConcatForLogging.stringBuilderWithInitialCapacity128  avgt   75  306,589 �  7,260  ns/op
//    StringConcatForLogging.stringBuilderWithInitialCapacity512  avgt   75  305,180 � 14,942  ns/op

    private static final String THREAD = "Thread: ";
    private static final String CLASS = "\tClass: ";
    private static final String METHOD = "\tMethod: ";
    private static final String MESSAGE = "\tMessage: ";

    private static String plusOperator(String className, String methodName, String message) {
        return "Thread: " + currentThread().getName() + "\tClass: " + className + "\tMethod: " + methodName + "\tMessage: " + message;
    }

    private static String stringBuffer(String className, String methodName, String message) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Thread: ")
                .append(currentThread().getName())
                .append("\tClass:")
                .append(className)
                .append("\tMethod:")
                .append(methodName)
                .append("\tMessage:")
                .append(message);
        return buffer.toString();
    }

    private static String stringBufferWithInitialCapacity128(String className, String methodName, String message) {
        StringBuffer buffer = new StringBuffer(128);
        buffer.append("Thread: ")
                .append(currentThread().getName())
                .append("\tClass:")
                .append(className)
                .append("\tMethod:")
                .append(methodName)
                .append("\tMessage:")
                .append(message);
        return buffer.toString();
    }

    private static String stringBufferWithInitialCapacity512(String className, String methodName, String message) {
        StringBuffer buffer = new StringBuffer(512);
        buffer.append("Thread: ")
                .append(currentThread().getName())
                .append("\tClass:")
                .append(className)
                .append("\tMethod:")
                .append(methodName)
                .append("\tMessage:")
                .append(message);
        return buffer.toString();
    }

    private static String stringBuilder(String className, String methodName, String message) {
        StringBuilder builder = new StringBuilder();
        builder.append("Thread: ")
                .append(currentThread().getName())
                .append("\tClass:")
                .append(className)
                .append("\tMethod:")
                .append(methodName)
                .append("\tMessage:")
                .append(message);
        return builder.toString();
    }

    private static String stringBuilderWithInitialCapacity128(String className, String methodName, String message) {
        StringBuilder builder = new StringBuilder(128);
        builder.append("Thread: ")
                .append(currentThread().getName())
                .append("\tClass:")
                .append(className)
                .append("\tMethod:")
                .append(methodName)
                .append("\tMessage:")
                .append(message);
        return builder.toString();
    }

    private static String stringBuilderWithInitialCapacity512(String className, String methodName, String message) {
        StringBuilder builder = new StringBuilder(412);
        builder.append("Thread: ")
                .append(currentThread().getName())
                .append("\tClass:")
                .append(className)
                .append("\tMethod:")
                .append(methodName)
                .append("\tMessage:")
                .append(message);
        return builder.toString();
    }

    private static String concat(String className, String methodName, String message) {
        return "Thread: ".concat(currentThread().getName())
                .concat("\tClass:")
                .concat(className)
                .concat("\tMethod:")
                .concat(methodName)
                .concat("\tMessage:")
                .concat(message);
    }

    private static String plusOperatorWithFinalStrings(final String className, final String methodName, final String message) {
        return THREAD + currentThread().getName() + CLASS + className + METHOD + methodName + MESSAGE + message;

    }

    private static String concatWithFinalStrings(final String className, final String methodName, final String message) {
        return THREAD.concat(currentThread().getName())
                .concat(CLASS)
                .concat(className)
                .concat(METHOD)
                .concat(methodName)
                .concat(MESSAGE)
                .concat(message);
    }


    @Benchmark
    public static void plusOperator(Blackhole blackhole) {
        blackhole.consume(
                plusOperator("MyClassName", "MyMethodName", "MyMessage")
        );
    }

    @Benchmark
    public static void stringBuffer(Blackhole blackhole) {
        blackhole.consume(
                stringBuffer("MyClassName", "MyMethodName", "MyMessage")
        );
    }

    @Benchmark
    public static void stringBufferWithInitialCapacity128(Blackhole blackhole) {
        blackhole.consume(
                stringBufferWithInitialCapacity128("MyClassName", "MyMethodName", "MyMessage")
        );
    }

    @Benchmark
    public static void stringBufferWithInitialCapacity512(Blackhole blackhole) {
        blackhole.consume(
                stringBufferWithInitialCapacity512("MyClassName", "MyMethodName", "MyMessage")
        );
    }


    @Benchmark
    public static void stringBuilder(Blackhole blackhole) {
        blackhole.consume(
                stringBuilder("MyClassName", "MyMethodName", "MyMessage")
        );
    }

    @Benchmark
    public static void stringBuilderWithInitialCapacity128(Blackhole blackhole) {
        blackhole.consume(
                stringBuilderWithInitialCapacity128("MyClassName", "MyMethodName", "MyMessage")
        );
    }

    @Benchmark
    public static void stringBuilderWithInitialCapacity512(Blackhole blackhole) {
        blackhole.consume(
                stringBuilderWithInitialCapacity512("MyClassName", "MyMethodName", "MyMessage")
        );
    }


    @Benchmark
    public static void plusOperatorWithFinalStrings(Blackhole blackhole) {
        blackhole.consume(
                plusOperatorWithFinalStrings("MyClassName", "MyMethodName", "MyMessage")
        );
    }

    @Benchmark
    public static void concat(Blackhole blackhole) {
        blackhole.consume(
                concat("MyClassName", "MyMethodName", "MyMessage")
        );
    }

    @Benchmark
    public static void concatWithFinalStrings(Blackhole blackhole) {
        blackhole.consume(
                concatWithFinalStrings("MyClassName", "MyMethodName", "MyMessage")
        );
    }


}
