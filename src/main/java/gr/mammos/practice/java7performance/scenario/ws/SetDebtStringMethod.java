package gr.mammos.practice.java7performance.scenario.ws;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 5, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 5, timeUnit = TimeUnit.SECONDS)
@Fork(3)
@Threads(4)
@State(Scope.Benchmark)
public class SetDebtStringMethod {

    public static final String XML_LONG = "<System>1</System>" +
            "<ApplicationNumber>100000</ApplicationNumber>" +
            "<DebtorVatNumber>011111111</DebtorVatNumber>" +
            "<CreditorVatNumber>02222222</CreditorVatNumber>" +
            "<OwnerCode>OWNER</OwnerCode>" +
            "<ContractNumber>ΔΑΝΕΙΑ ΠΛΗΜΜΥΡΟΠΑΘΩΝ</ContractNumber>" +
            "<AccountNumber>ΦΟΡΟΛΟΓΙΚΗ ΔΙΟΙΚΗΣΗ - Δ.Ο.Υ.</AccountNumber>" +
            "<DebtCode>AAA/BBBB/CCC/DDD EE/XXX/COR- XXXXXXXX</DebtCode>" +
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
            "<RequestDateTime>2025-06-13T20:00:00</RequestDateTime>";

    @Benchmark
    public void setDebtStringParsing(Blackhole blackhole) {
        blackhole.consume(parseXml(XML_LONG, blackhole));
    }


    private int parseXml(String requestData, Blackhole blackhole) {

        final String requestDataLowercase = requestData.toLowerCase();
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "ApplicationNumber"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "OwnerCode"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "CreditorVatNumber"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "DebtorVatNumber"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "ContractNumber"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "AccountNumber"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "DebtCode"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "CutOffDate"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "IsOverdueOnCutOffDate"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "IsDenouncedOnCutOffDate"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "IsOverdue"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "IsDenounced"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "IsStateSupported"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "IsStateSubsidised"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "DebtType"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "IsBusinessProduct"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "DebtAmount"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "Currency"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "DebtDate"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "OverdueDays"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "OverdueDate"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "DenouncementDate"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "IsRestructured"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "LastRestructureDate"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "RequestDateTime"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "System"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "IsEligibleForRestructure"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "IsEligibleForWriteOff"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "InterestOverdueAmount"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "IncrementAmount"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "PenaltyAmount"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "IsOCWRestructured"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "OCWRestructureDate"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "IsUpdate"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "DenouncementDateOnCutOffDate"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "DenouncementLegalStatus"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "IsThirdPartySupported"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "DebtAmountInOriginalCurrency"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "ExchangeRate"));
        blackhole.consume(findElementValue(requestData, requestDataLowercase, "ExchangeRateDate"));

        return 1;
    }

    /**
     * With a prepared lowerCase string, we avoid using PatternMatching. We still need the original String otherwise, we will convert received data to lowerCase as well, which we want to avoid
     */
    public static String findElementValue(final String originalData, final String lowerCaseData, final String element2search) {
        final String openTag = "<" + element2search.toLowerCase() + ">";
        final String closeTag = "</" + element2search.toLowerCase() + ">";

        int start = lowerCaseData.indexOf(openTag);
        if (start == -1) return "";

        start += openTag.length();
        int end = lowerCaseData.indexOf(closeTag, start);
        if (end == -1) return "";

        return originalData.substring(start, end).trim(); // Use original string for actual content
    }
}
