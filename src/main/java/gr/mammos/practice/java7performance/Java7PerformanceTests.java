package gr.mammos.practice.java7performance;

import gr.mammos.practice.java7performance.scenario.random.Int2DArraySum;
import gr.mammos.practice.java7performance.scenario.random.Short2DArraySum;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Java7PerformanceTests {
    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("java.version"));


        Options opt = new OptionsBuilder()
//                .include("." + FinalStringExampleTest.class.getSimpleName() + ".*")
//                .include("." + WebServiceRegexTest.class.getSimpleName() + ".*")
//                .include("." + SetDebtRegexMethod.class.getSimpleName() + ".*")
//                .include("." + SetDebtStringMethod.class.getSimpleName() + ".*")
//                .include("." + SetDebtCharArrayMethod.class.getSimpleName() + ".*")
//                .include("." + IsEmptyVsLengthZero.class.getSimpleName() + ".*")
//                .include("." + StringConcatForLogging.class.getSimpleName() + ".*")
//                .include("." + IfVsSwitchForLogging.class.getSimpleName() + ".*")
//                .include("." + Short2DArraySum.class.getSimpleName() + ".*")
                .include("." + Int2DArraySum.class.getSimpleName() + ".*")
//                .jvmArgs("-Xms1024m", "-Xmx2048m", "-XX:MaxDirectMemorySize=512M")
                .build();

        new Runner(opt).run();
    }

}
