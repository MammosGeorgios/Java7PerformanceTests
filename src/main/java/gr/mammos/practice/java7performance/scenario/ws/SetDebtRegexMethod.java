package gr.mammos.practice.java7performance.scenario.ws;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 5, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 5, timeUnit = TimeUnit.SECONDS)
@Fork(3)
@Threads(4)
@State(Scope.Benchmark)
public class SetDebtRegexMethod {

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

    @Benchmark
    public void setDebtRegexParsing(Blackhole blackhole) {
        blackhole.consume(parseXml(XML_LONG, blackhole));
    }


    private int parseXml(String requestData, Blackhole blackhole) {

        blackhole.consume(findElementValue(requestData, "ApplicationNumber"));
        blackhole.consume(findElementValue(requestData, "OwnerCode"));
        blackhole.consume(findElementValue(requestData, "CreditorVatNumber"));
        blackhole.consume(findElementValue(requestData, "DebtorVatNumber"));
        blackhole.consume(findElementValue(requestData, "ContractNumber"));
        blackhole.consume(findElementValue(requestData, "AccountNumber"));
        blackhole.consume(findElementValue(requestData, "DebtCode"));
        blackhole.consume(findElementValue(requestData, "CutOffDate"));
        blackhole.consume(findElementValue(requestData, "IsOverdueOnCutOffDate"));
        blackhole.consume(findElementValue(requestData, "IsDenouncedOnCutOffDate"));
        blackhole.consume(findElementValue(requestData, "IsOverdue"));
        blackhole.consume(findElementValue(requestData, "IsDenounced"));
        blackhole.consume(findElementValue(requestData, "IsStateSupported"));
        blackhole.consume(findElementValue(requestData, "IsStateSubsidised"));
        blackhole.consume(findElementValue(requestData, "DebtType"));
        blackhole.consume(findElementValue(requestData, "IsBusinessProduct"));
        blackhole.consume(findElementValue(requestData, "DebtAmount"));
        blackhole.consume(findElementValue(requestData, "Currency"));
        blackhole.consume(findElementValue(requestData, "DebtDate"));
        blackhole.consume(findElementValue(requestData, "OverdueDays"));
        blackhole.consume(findElementValue(requestData, "OverdueDate"));
        blackhole.consume(findElementValue(requestData, "DenouncementDate"));
        blackhole.consume(findElementValue(requestData, "IsRestructured"));
        blackhole.consume(findElementValue(requestData, "LastRestructureDate"));
        blackhole.consume(findElementValue(requestData, "RequestDateTime"));
        blackhole.consume(findElementValue(requestData, "System"));
        blackhole.consume(findElementValue(requestData, "IsEligibleForRestructure"));
        blackhole.consume(findElementValue(requestData, "IsEligibleForWriteOff"));
        blackhole.consume(findElementValue(requestData, "InterestOverdueAmount"));
        blackhole.consume(findElementValue(requestData, "IncrementAmount"));
        blackhole.consume(findElementValue(requestData, "PenaltyAmount"));
        blackhole.consume(findElementValue(requestData, "IsOCWRestructured"));
        blackhole.consume(findElementValue(requestData, "OCWRestructureDate"));
        blackhole.consume(findElementValue(requestData, "IsUpdate"));
        blackhole.consume(findElementValue(requestData, "DenouncementDateOnCutOffDate"));
        blackhole.consume(findElementValue(requestData, "DenouncementLegalStatus"));
        blackhole.consume(findElementValue(requestData, "IsThirdPartySupported"));
        blackhole.consume(findElementValue(requestData, "DebtAmountInOriginalCurrency"));
        blackhole.consume(findElementValue(requestData, "ExchangeRate"));
        blackhole.consume(findElementValue(requestData, "ExchangeRateDate"));

        return 1;
    }

    public static String findElementValue(String xmlString, String element2search) {
        final Pattern pattern = Pattern.compile("<" + element2search + ">(.+?)</" + element2search + ">",
                Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        final Matcher matcher = pattern.matcher(xmlString);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return "";
    }
}
