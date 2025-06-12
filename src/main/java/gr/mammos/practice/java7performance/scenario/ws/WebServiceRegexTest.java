package gr.mammos.practice.java7performance.scenario.ws;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Fork(3)
@State(Scope.Thread)
public class WebServiceRegexTest {

    private static final String SYSTEM_PROPERTY = "System";
    private static final String APPLICATION_NUMBER_PROPERTY = "ApplicationNumber";
    private static final String IS_UPDATE_PROPERTY = "IsUpdate";


    public static String findElementValue_defaultMethod(String xmlString, String element2search) {
        final Pattern pattern = Pattern.compile("<" + element2search + ">(.+?)</" + element2search + ">",
                Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        final Matcher matcher = pattern.matcher(xmlString);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return "";
    }

    // Seems to be abotu the same, no point in changing
    public static String findElementValue_nonRelactantRegexModifier(String xmlString, String element2search) {
        final Pattern pattern = Pattern.compile("<" + element2search + ">(.*?)</" + element2search + ">",
                Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        final Matcher matcher = pattern.matcher(xmlString);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return "";
    }


    // Let's compare performance gains if we use a hashmap to store the patterns. However, Matcher is not thread safe.
    static final Map<String, Pattern> patternMap = new ConcurrentHashMap<>();
    static {
        patternMap.put(APPLICATION_NUMBER_PROPERTY, getPattern(APPLICATION_NUMBER_PROPERTY));
        patternMap.put(SYSTEM_PROPERTY, getPattern(SYSTEM_PROPERTY));
        patternMap.put(IS_UPDATE_PROPERTY, getPattern(IS_UPDATE_PROPERTY));
    }

    private static Pattern getPattern(String element2search) {
        return Pattern.compile("<" + element2search + ">(.+?)</" + element2search + ">",
                Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
    }

    public static String findElementValue_withMap(String xmlString, String element2search) {
        final Pattern pattern = patternMap.get(element2search);
        final Matcher matcher = pattern.matcher(xmlString);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return "";
    }

    @Benchmark
    public static void default_short_system(Blackhole blackhole) {
        blackhole.consume(findElementValue_defaultMethod(XML_SHORT, SYSTEM_PROPERTY));
    }

    @Benchmark
    public static void default_short_applicationNumber(Blackhole blackhole) {
        blackhole.consume(findElementValue_defaultMethod(XML_SHORT, APPLICATION_NUMBER_PROPERTY));
    }

    @Benchmark
    public static void default_shortInverted_system(Blackhole blackhole) {
        blackhole.consume(findElementValue_defaultMethod(XML_SHORT_INVERTED, SYSTEM_PROPERTY));
    }

    @Benchmark
    public static void default_shortInverted_applicationNumber(Blackhole blackhole) {
        blackhole.consume(findElementValue_defaultMethod(XML_SHORT_INVERTED, APPLICATION_NUMBER_PROPERTY));
    }

    @Benchmark
    public static void default_long_system(Blackhole blackhole) {
        blackhole.consume(findElementValue_defaultMethod(XML_LONG, SYSTEM_PROPERTY));
    }

    @Benchmark
    public static void default_long_isUpdate(Blackhole blackhole) {
        blackhole.consume(findElementValue_defaultMethod(XML_LONG, IS_UPDATE_PROPERTY));
    }

    @Benchmark
    public static void nonRelactantRegexModifier_short_system(Blackhole blackhole) {
        blackhole.consume(findElementValue_nonRelactantRegexModifier(XML_SHORT, SYSTEM_PROPERTY));
    }

    @Benchmark
    public static void nonRelactantRegexModifier_short_applicationNumber(Blackhole blackhole) {
        blackhole.consume(findElementValue_nonRelactantRegexModifier(XML_SHORT, APPLICATION_NUMBER_PROPERTY));
    }

    @Benchmark
    public static void nonRelactantRegexModifier_shortInverted_system(Blackhole blackhole) {
        blackhole.consume(findElementValue_nonRelactantRegexModifier(XML_SHORT_INVERTED, SYSTEM_PROPERTY));
    }

    @Benchmark
    public static void nonRelactantRegexModifier_shortInverted_applicationNumber(Blackhole blackhole) {
        blackhole.consume(findElementValue_nonRelactantRegexModifier(XML_SHORT_INVERTED, APPLICATION_NUMBER_PROPERTY));
    }

    @Benchmark
    public static void nonRelactantRegexModifier_long_system(Blackhole blackhole) {
        blackhole.consume(findElementValue_nonRelactantRegexModifier(XML_LONG, SYSTEM_PROPERTY));
    }

    @Benchmark
    public static void nonRelactantRegexModifier_long_isUpdate(Blackhole blackhole) {
        blackhole.consume(findElementValue_nonRelactantRegexModifier(XML_LONG, IS_UPDATE_PROPERTY));
    }


    @Benchmark
    public static void map_short_system(Blackhole blackhole) {
        blackhole.consume(findElementValue_withMap(XML_SHORT, SYSTEM_PROPERTY));
    }

    @Benchmark
    public static void map_short_applicationNumber(Blackhole blackhole) {
        blackhole.consume(findElementValue_withMap(XML_SHORT, APPLICATION_NUMBER_PROPERTY));
    }

    @Benchmark
    public static void map_shortInverted_system(Blackhole blackhole) {
        blackhole.consume(findElementValue_withMap(XML_SHORT_INVERTED, SYSTEM_PROPERTY));
    }

    @Benchmark
    public static void map_shortInverted_applicationNumber(Blackhole blackhole) {
        blackhole.consume(findElementValue_withMap(XML_SHORT_INVERTED, APPLICATION_NUMBER_PROPERTY));
    }


    @Benchmark
    public static void map_long_system(Blackhole blackhole) {
        blackhole.consume(findElementValue_withMap(XML_LONG, SYSTEM_PROPERTY));
    }

    @Benchmark
    public static void map_long_isUpdate(Blackhole blackhole) {
        blackhole.consume(findElementValue_withMap(XML_LONG, IS_UPDATE_PROPERTY));
    }




    public static final String XML_SHORT = "<System>1</System><ApplicationNumber>100103</ApplicationNumber>";
    public static final String XML_SHORT_INVERTED = "<ApplicationNumber>100103</ApplicationNumber><System>1</System>";
    public static final String XML_LONG = "<System>1</System>" +
            "<ApplicationNumber>100000</ApplicationNumber>"+
            "<DebtorVatNumber>011111111</DebtorVatNumber>"+
            "<CreditorVatNumber>02222222</CreditorVatNumber>" +
            "<OwnerCode>PIR</OwnerCode>" +
            "<ContractNumber>ΔΑΝΕΙΑ ΠΛΗΜΜΥΡΟΠΑΘΩΝ</ContractNumber>" +
            "<AccountNumber>ΦΟΡΟΛΟΓΙΚΗ ΔΙΟΙΚΗΣΗ - Δ.Ο.Υ.</AccountNumber>" +
            "<DebtCode>059/2017/110/ΠΕΕ ΑΚ/3002/COR- 059007542</DebtCode>" +
            "<CutOffDate xsi:nil=true xmlns:xsi=http://www.w3.org/2001/XMLSchema-instance/>" +
            "<IsOverdueOnCutOffDate>false</IsOverdueOnCutOffDate>" +
            "<IsDenouncedOnCutOffDate>false</IsDenouncedOnCutOffDate>" +
            "<DenouncementDateOnCutOffDate xsi:nil=true xmlns:xsi=http://www.w3.org/2001/XMLSchema-instance/>" +
            "<IsOverdue>1</IsOverdue>" +
            "<OverdueDate>2020-05-27T11:05:00</OverdueDate>" +
            "<OverdueDays>1132</OverdueDays>" +
            "<IsDenounced>false</IsDenounced>" +
            "<DenouncementLegalStatus>Οφειλή Ενταγμένη Σε Πρόγραμμα Πλειστηριασμού</DenouncementLegalStatus>" +
            "<DenouncementDate xsi:nil=true xmlns:xsi=http://www.w3.org/2001/XMLSchema-instance/>" +
            "<IsRestructured>false</IsRestructured>" +
            "<LastRestructureDate xsi:nil=true xmlns:xsi=http://www.w3.org/2001/XMLSchema-instance/>" +
            "<IsStateSupported>false</IsStateSupported>" +
            "<IsStateSubsidised>false</IsStateSubsidised>" +
            "<IsThirdPartySupported>false</IsThirdPartySupported>" +
            "<IsOCWRestructured>false</IsOCWRestructured>" +
            "<OCWRestructureDate xsi:nil=true xmlns:xsi=http://www.w3.org/2001/XMLSchema-instance/>" +
            "<DebtType>16</DebtType>" +
            "<DebtAmount>99990000.15</DebtAmount>" +
            "<InterestOverdueAmount>0</InterestOverdueAmount>" +
            "<IncrementAmount>3102.45</IncrementAmount>" +
            "<PenaltyAmount>0</PenaltyAmount>" +
            "<DebtDate>2020-05-27T11:05:00</DebtDate>" +
            "<Currency>EUR</Currency>" +
            "<DebtAmountInOriginalCurrency xsi:nil=true xmlns:xsi=http://www.w3.org/2001/XMLSchema-instance/>" +
            "<ExchangeRate xsi:nil=true xmlns:xsi=http://www.w3.org/2001/XMLSchema-instance/>" +
            "<ExchangeRateDate xsi:nil=true xmlns:xsi=http://www.w3.org/2001/XMLSchema-instance/>" +
            "<IsBusinessProduct>1</IsBusinessProduct>" +
            "<IsEligibleForRestructure>false</IsEligibleForRestructure>" +
            "<IsEligibleForWriteOff>true</IsEligibleForWriteOff>" +
            "<IsUpdate>false</IsUpdate>" +
            "<RequestDateTime>%s</RequestDateTime>";

}
