package gr.mammos.practice.java7performance.scenario.random;

import org.openjdk.jmh.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 25, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Fork(3)
//@Threads(4)
@State(Scope.Benchmark)
public class Int2DArraySum {

    private static final int ARRAY_SIZE = 5000;
    private static int[][] doubleArray = new int[ARRAY_SIZE][ARRAY_SIZE];
    private static long EXPECTED_SUM;

    @Setup(Level.Trial)
    public static void setup() {
        Random random = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = 0; j < ARRAY_SIZE; j++) {
                doubleArray[i][j] = random.nextInt(100);
            }
        }
        EXPECTED_SUM = 0;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = 0; j < ARRAY_SIZE; j++) {
                EXPECTED_SUM += doubleArray[i][j];
            }
        }
    }

    @Benchmark
    public long sum_i_j() {

        long sum = 0;

        for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = 0; j < ARRAY_SIZE; j++) {
                sum += doubleArray[i][j];
            }
        }

        if (sum != EXPECTED_SUM) {
            throw new AssertionError("Expected sum of doubles " + EXPECTED_SUM + " but got " + sum);
        }
        return sum;
    }

    @Benchmark
    public long sum_j_i() {

        long sum = 0;

        for (int j = 0; j < ARRAY_SIZE; j++) {
            for (int i = 0; i < ARRAY_SIZE; i++) {
                sum += doubleArray[i][j];
            }
        }

        if (sum != EXPECTED_SUM) {
            throw new AssertionError("Expected sum of doubles " + EXPECTED_SUM + " but got " + sum);
        }
        return sum;
    }

    @Benchmark
    public long sum_i_j_unrolled_08() {

        long sum = 0;
        final int leftOvers = ARRAY_SIZE % 8;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = 0; j < ARRAY_SIZE - leftOvers; j += 8) {
                sum += doubleArray[i][j];
                sum += doubleArray[i][j + 1];
                sum += doubleArray[i][j + 2];
                sum += doubleArray[i][j + 3];
                sum += doubleArray[i][j + 4];
                sum += doubleArray[i][j + 5];
                sum += doubleArray[i][j + 6];
                sum += doubleArray[i][j + 7];
            }

            for (int l = ARRAY_SIZE - leftOvers; l < ARRAY_SIZE; l++) {
                sum += doubleArray[i][l];
            }
        }

        if (sum != EXPECTED_SUM) {
            throw new AssertionError("Expected sum of doubles " + EXPECTED_SUM + " but got " + sum);
        }
        return sum;
    }


    @Benchmark
    public long sum_i_j_unrolled_02() {

        long sum = 0;

        for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = 0; j < ARRAY_SIZE; j += 2) {
                sum += doubleArray[i][j];
                sum += doubleArray[i][j + 1];
            }

        }

        if (sum != EXPECTED_SUM) {
            throw new AssertionError("Expected sum of doubles " + EXPECTED_SUM + " but got " + sum);
        }
        return sum;
    }

    @Benchmark
    public long sum_i_j_unrolled_04() {

        long sum = 0;
        final int leftOvers = ARRAY_SIZE % 4;

        for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = 0; j < ARRAY_SIZE - leftOvers; j += 4) {
                sum += doubleArray[i][j];
                sum += doubleArray[i][j + 1];
                sum += doubleArray[i][j + 2];
                sum += doubleArray[i][j + 3];
            }

            for (int l = ARRAY_SIZE - leftOvers; l < ARRAY_SIZE; l++) {
                sum += doubleArray[i][l];
            }

        }

        if (sum != EXPECTED_SUM) {
            throw new AssertionError("Expected sum of doubles " + EXPECTED_SUM + " but got " + sum);
        }
        return sum;
    }

    @Benchmark
    public long sum_i_j_unrolled_06() {

        long sum = 0;
        final int leftOvers = ARRAY_SIZE % 6;

        for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = 0; j < ARRAY_SIZE - leftOvers; j += 6) {
                sum += doubleArray[i][j];
                sum += doubleArray[i][j + 1];
                sum += doubleArray[i][j + 2];
                sum += doubleArray[i][j + 3];
                sum += doubleArray[i][j + 4];
                sum += doubleArray[i][j + 5];
            }


            for (int l = ARRAY_SIZE - leftOvers; l < ARRAY_SIZE; l++) {
                sum += doubleArray[i][l];
            }
        }

        if (sum != EXPECTED_SUM) {
            throw new AssertionError("Expected sum of doubles " + EXPECTED_SUM + " but got " + sum);
        }
        return sum;
    }


    @Benchmark
    public long sum_i_j_unrolled_16() {

        long sum = 0;
        final int leftOvers = ARRAY_SIZE % 16;

        for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = 0; j < ARRAY_SIZE - leftOvers; j += 16) {
                sum += doubleArray[i][j];
                sum += doubleArray[i][j + 1];
                sum += doubleArray[i][j + 2];
                sum += doubleArray[i][j + 3];
                sum += doubleArray[i][j + 4];
                sum += doubleArray[i][j + 5];
                sum += doubleArray[i][j + 6];
                sum += doubleArray[i][j + 7];
                sum += doubleArray[i][j + 8];
                sum += doubleArray[i][j + 9];
                sum += doubleArray[i][j + 10];
                sum += doubleArray[i][j + 11];
                sum += doubleArray[i][j + 12];
                sum += doubleArray[i][j + 13];
                sum += doubleArray[i][j + 14];
                sum += doubleArray[i][j + 15];
            }
            for (int l = ARRAY_SIZE - leftOvers; l < ARRAY_SIZE; l++) {
                sum += doubleArray[i][l];
            }
        }

        if (sum != EXPECTED_SUM) {
            throw new AssertionError("Expected sum of doubles " + EXPECTED_SUM + " but got " + sum);
        }
        return sum;
    }

    @Benchmark
    public long sum_i_j_unrolled_24() {

        long sum = 0;
        final int leftOvers = ARRAY_SIZE % 24;

        for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = 0; j < ARRAY_SIZE - leftOvers; j += 24) {
                sum += doubleArray[i][j];
                sum += doubleArray[i][j + 1];
                sum += doubleArray[i][j + 2];
                sum += doubleArray[i][j + 3];
                sum += doubleArray[i][j + 4];
                sum += doubleArray[i][j + 5];
                sum += doubleArray[i][j + 6];
                sum += doubleArray[i][j + 7];
                sum += doubleArray[i][j + 8];
                sum += doubleArray[i][j + 9];
                sum += doubleArray[i][j + 10];
                sum += doubleArray[i][j + 11];
                sum += doubleArray[i][j + 12];
                sum += doubleArray[i][j + 13];
                sum += doubleArray[i][j + 14];
                sum += doubleArray[i][j + 15];
                sum += doubleArray[i][j + 16];
                sum += doubleArray[i][j + 17];
                sum += doubleArray[i][j + 18];
                sum += doubleArray[i][j + 19];
                sum += doubleArray[i][j + 20];
                sum += doubleArray[i][j + 21];
                sum += doubleArray[i][j + 22];
                sum += doubleArray[i][j + 23];
            }


            for (int l = ARRAY_SIZE - leftOvers; l < ARRAY_SIZE; l++) {
                sum += doubleArray[i][l];
            }
        }

        if (sum != EXPECTED_SUM) {
            throw new AssertionError("Expected sum of doubles " + EXPECTED_SUM + " but got " + sum);
        }
        return sum;
    }


    @Benchmark
    public long sum_i_j_unrolled_32() {

        long sum = 0;
        final int leftOvers = ARRAY_SIZE % 32;

        for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = 0; j < ARRAY_SIZE - leftOvers; j += 32) {
                sum += doubleArray[i][j];
                sum += doubleArray[i][j + 1];
                sum += doubleArray[i][j + 2];
                sum += doubleArray[i][j + 3];
                sum += doubleArray[i][j + 4];
                sum += doubleArray[i][j + 5];
                sum += doubleArray[i][j + 6];
                sum += doubleArray[i][j + 7];
                sum += doubleArray[i][j + 8];
                sum += doubleArray[i][j + 9];
                sum += doubleArray[i][j + 10];
                sum += doubleArray[i][j + 11];
                sum += doubleArray[i][j + 12];
                sum += doubleArray[i][j + 13];
                sum += doubleArray[i][j + 14];
                sum += doubleArray[i][j + 15];
                sum += doubleArray[i][j + 16];
                sum += doubleArray[i][j + 17];
                sum += doubleArray[i][j + 18];
                sum += doubleArray[i][j + 19];
                sum += doubleArray[i][j + 20];
                sum += doubleArray[i][j + 21];
                sum += doubleArray[i][j + 22];
                sum += doubleArray[i][j + 23];
                sum += doubleArray[i][j + 24];
                sum += doubleArray[i][j + 25];
                sum += doubleArray[i][j + 26];
                sum += doubleArray[i][j + 27];
                sum += doubleArray[i][j + 28];
                sum += doubleArray[i][j + 29];
                sum += doubleArray[i][j + 30];
                sum += doubleArray[i][j + 31];
            }


            for (int l = ARRAY_SIZE - leftOvers; l < ARRAY_SIZE; l++) {
                sum += doubleArray[i][l];
            }

        }

        if (sum != EXPECTED_SUM) {
            throw new AssertionError("Expected sum of doubles " + EXPECTED_SUM + " but got " + sum);
        }
        return sum;
    }

    @Benchmark
    public long sum_i_j_unrolled_48() {

        long sum = 0;
        final int leftOvers = ARRAY_SIZE % 48;

        for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = 0; j < ARRAY_SIZE - leftOvers; j += 48) {
                sum += doubleArray[i][j];
                sum += doubleArray[i][j + 1];
                sum += doubleArray[i][j + 2];
                sum += doubleArray[i][j + 3];
                sum += doubleArray[i][j + 4];
                sum += doubleArray[i][j + 5];
                sum += doubleArray[i][j + 6];
                sum += doubleArray[i][j + 7];
                sum += doubleArray[i][j + 8];
                sum += doubleArray[i][j + 9];
                sum += doubleArray[i][j + 10];
                sum += doubleArray[i][j + 11];
                sum += doubleArray[i][j + 12];
                sum += doubleArray[i][j + 13];
                sum += doubleArray[i][j + 14];
                sum += doubleArray[i][j + 15];
                sum += doubleArray[i][j + 16];
                sum += doubleArray[i][j + 17];
                sum += doubleArray[i][j + 18];
                sum += doubleArray[i][j + 19];
                sum += doubleArray[i][j + 20];
                sum += doubleArray[i][j + 21];
                sum += doubleArray[i][j + 22];
                sum += doubleArray[i][j + 23];
                sum += doubleArray[i][j + 24];
                sum += doubleArray[i][j + 25];
                sum += doubleArray[i][j + 26];
                sum += doubleArray[i][j + 27];
                sum += doubleArray[i][j + 28];
                sum += doubleArray[i][j + 29];
                sum += doubleArray[i][j + 30];
                sum += doubleArray[i][j + 31];
                sum += doubleArray[i][j + 32];
                sum += doubleArray[i][j + 33];
                sum += doubleArray[i][j + 34];
                sum += doubleArray[i][j + 35];
                sum += doubleArray[i][j + 36];
                sum += doubleArray[i][j + 37];
                sum += doubleArray[i][j + 38];
                sum += doubleArray[i][j + 39];
                sum += doubleArray[i][j + 40];
                sum += doubleArray[i][j + 41];
                sum += doubleArray[i][j + 42];
                sum += doubleArray[i][j + 43];
                sum += doubleArray[i][j + 44];
                sum += doubleArray[i][j + 45];
                sum += doubleArray[i][j + 46];
                sum += doubleArray[i][j + 47];
            }


            for (int l = ARRAY_SIZE - leftOvers; l < ARRAY_SIZE; l++) {
                sum += doubleArray[i][l];
            }

        }

        if (sum != EXPECTED_SUM) {
            throw new AssertionError("Expected sum of doubles " + EXPECTED_SUM + " but got " + sum);
        }
        return sum;
    }


    @Benchmark
    public long sum_i_j_unrolled_64() {

        long sum = 0;
        final int leftOvers = ARRAY_SIZE % 64;

        for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = 0; j < ARRAY_SIZE - leftOvers; j += 64) {
                sum += doubleArray[i][j];
                sum += doubleArray[i][j + 1];
                sum += doubleArray[i][j + 2];
                sum += doubleArray[i][j + 3];
                sum += doubleArray[i][j + 4];
                sum += doubleArray[i][j + 5];
                sum += doubleArray[i][j + 6];
                sum += doubleArray[i][j + 7];
                sum += doubleArray[i][j + 8];
                sum += doubleArray[i][j + 9];
                sum += doubleArray[i][j + 10];
                sum += doubleArray[i][j + 11];
                sum += doubleArray[i][j + 12];
                sum += doubleArray[i][j + 13];
                sum += doubleArray[i][j + 14];
                sum += doubleArray[i][j + 15];
                sum += doubleArray[i][j + 16];
                sum += doubleArray[i][j + 17];
                sum += doubleArray[i][j + 18];
                sum += doubleArray[i][j + 19];
                sum += doubleArray[i][j + 20];
                sum += doubleArray[i][j + 21];
                sum += doubleArray[i][j + 22];
                sum += doubleArray[i][j + 23];
                sum += doubleArray[i][j + 24];
                sum += doubleArray[i][j + 25];
                sum += doubleArray[i][j + 26];
                sum += doubleArray[i][j + 27];
                sum += doubleArray[i][j + 28];
                sum += doubleArray[i][j + 29];
                sum += doubleArray[i][j + 30];
                sum += doubleArray[i][j + 31];
                sum += doubleArray[i][j + 32];
                sum += doubleArray[i][j + 33];
                sum += doubleArray[i][j + 34];
                sum += doubleArray[i][j + 35];
                sum += doubleArray[i][j + 36];
                sum += doubleArray[i][j + 37];
                sum += doubleArray[i][j + 38];
                sum += doubleArray[i][j + 39];
                sum += doubleArray[i][j + 40];
                sum += doubleArray[i][j + 41];
                sum += doubleArray[i][j + 42];
                sum += doubleArray[i][j + 43];
                sum += doubleArray[i][j + 44];
                sum += doubleArray[i][j + 45];
                sum += doubleArray[i][j + 46];
                sum += doubleArray[i][j + 47];
                sum += doubleArray[i][j + 48];
                sum += doubleArray[i][j + 49];
                sum += doubleArray[i][j + 50];
                sum += doubleArray[i][j + 51];
                sum += doubleArray[i][j + 52];
                sum += doubleArray[i][j + 53];
                sum += doubleArray[i][j + 54];
                sum += doubleArray[i][j + 55];
                sum += doubleArray[i][j + 56];
                sum += doubleArray[i][j + 57];
                sum += doubleArray[i][j + 58];
                sum += doubleArray[i][j + 59];
                sum += doubleArray[i][j + 60];
                sum += doubleArray[i][j + 61];
                sum += doubleArray[i][j + 62];
                sum += doubleArray[i][j + 63];
            }


            for (int l = ARRAY_SIZE - leftOvers; l < ARRAY_SIZE; l++) {
                sum += doubleArray[i][l];
            }

        }

        if (sum != EXPECTED_SUM) {
            throw new AssertionError("Expected sum of doubles " + EXPECTED_SUM + " but got " + sum);
        }
        return sum;
    }
}
