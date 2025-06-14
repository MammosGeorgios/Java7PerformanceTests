package gr.mammos.practice.java7performance.scenario.random;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 25, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Fork(3)
//@Threads(4)
@State(Scope.Benchmark)
public class IfVsSwitchForLogging {

//    Benchmark                             Mode  Cnt      Score      Error  Units
//    IfVsSwitch.debug_if                   avgt   75      6,557 �    0,112  ns/op
//    IfVsSwitch.debug_loggerDecidingLevel  avgt   75      4,947 �    0,093  ns/op  <---
//    IfVsSwitch.debug_switch               avgt   75      5,691 �    0,092  ns/op
//    IfVsSwitch.error_if                   avgt   75  17622,984 �  513,837  ns/op
//    IfVsSwitch.error_loggerDecidingLevel  avgt   75  18049,649 �  409,562  ns/op
//    IfVsSwitch.error_switch               avgt   75  17913,535 �  511,737  ns/op
//    IfVsSwitch.fatal_if                   avgt   75  21513,035 � 1626,000  ns/op
//    IfVsSwitch.fatal_loggerDecidingLevel  avgt   75  20449,619 � 1076,373  ns/op
//    IfVsSwitch.fatal_switch               avgt   75  18650,337 �  580,087  ns/op  <---
//    IfVsSwitch.info_if                    avgt   75  18426,158 �  789,605  ns/op
//    IfVsSwitch.info_loggerDecidingLevel   avgt   75  17963,823 �  524,879  ns/op  <---
//    IfVsSwitch.info_switch                avgt   75  17992,692 �  431,610  ns/op  <---

    private static final Logger LOG4J_LOGGER = Logger.getLogger(IfVsSwitchForLogging.class);


    private static void logWithIf(Level level, String finalMessage) {
        if (Level.DEBUG.equals(level)) {
            LOG4J_LOGGER.debug(finalMessage);
        } else if (Level.INFO.equals(level)) {
            LOG4J_LOGGER.info(finalMessage);
        } else if (Level.ERROR.equals(level)) {
            LOG4J_LOGGER.error(finalMessage);
        } else if (Level.WARN.equals(level)) {
            LOG4J_LOGGER.warn(finalMessage);
        } else if (Level.FATAL.equals(level)) {
            LOG4J_LOGGER.fatal(finalMessage);
        }
    }

    private static void logWithSwitch(Level level, String finalMessage) {

        switch (level.toInt()) {
            case Level.DEBUG_INT:
                LOG4J_LOGGER.debug(finalMessage);
                return;
            case Level.INFO_INT:
                LOG4J_LOGGER.info(finalMessage);
                return;
            case Level.ERROR_INT:
                LOG4J_LOGGER.error(finalMessage);
                return;
            case Level.WARN_INT:
                LOG4J_LOGGER.warn(finalMessage);
                return;
            case Level.FATAL_INT:
                LOG4J_LOGGER.fatal(finalMessage);
        }

    }

    private static void logWithLoggerDecidingLevel(Level level, String finalMessage) {
        LOG4J_LOGGER.log(level, finalMessage);
    }

    @Benchmark
    public void debug_if() {
        logWithIf(Level.DEBUG, "This is a string message");
    }

    @Benchmark
    public void info_if() {
        logWithIf(Level.INFO, "This is a string message");
    }

    @Benchmark
    public void error_if() {
        logWithIf(Level.ERROR, "This is a string message");
    }

    @Benchmark
    public void fatal_if() {
        logWithIf(Level.FATAL, "This is a string message");
    }


    @Benchmark
    public void debug_switch() {
        logWithSwitch(Level.DEBUG, "This is a string message");
    }

    @Benchmark
    public void info_switch() {
        logWithSwitch(Level.INFO, "This is a string message");
    }

    @Benchmark
    public void error_switch() {
        logWithSwitch(Level.ERROR, "This is a string message");
    }

    @Benchmark
    public void fatal_switch() {
        logWithSwitch(Level.FATAL, "This is a string message");
    }

    @Benchmark
    public void debug_loggerDecidingLevel() {
        logWithLoggerDecidingLevel(Level.DEBUG, "This is a string message");
    }

    @Benchmark
    public void info_loggerDecidingLevel() {
        logWithLoggerDecidingLevel(Level.INFO, "This is a string message");
    }

    @Benchmark
    public void error_loggerDecidingLevel() {
        logWithLoggerDecidingLevel(Level.ERROR, "This is a string message");
    }

    @Benchmark
    public void fatal_loggerDecidingLevel() {
        logWithLoggerDecidingLevel(Level.FATAL, "This is a string message");
    }

}
