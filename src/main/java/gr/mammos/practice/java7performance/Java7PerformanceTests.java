package gr.mammos.practice.java7performance;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Java7PerformanceTests {
    public static void main(String[] args) throws RunnerException{
        System.out.println(System.getProperty("java.version"));

        Options opt = new OptionsBuilder()
                .include("." + FinalStringExampleTest.class.getSimpleName() + ".*")
                .build();

        new Runner(opt).run();
    }

}
