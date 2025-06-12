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
public class SetDebtCharArrayMethod {

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
    public void setDebtCharArrayParsing(Blackhole blackhole) {
        blackhole.consume(parseXml(XML_LONG, blackhole));
    }


    private int parseXml(String requestData, Blackhole blackhole) {

        final char[] requestDataArray = requestData.toCharArray();
        blackhole.consume(findElementValue(requestData, requestDataArray, "ApplicationNumber"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "OwnerCode"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "CreditorVatNumber"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "DebtorVatNumber"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "ContractNumber"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "AccountNumber"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "DebtCode"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "CutOffDate"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "IsOverdueOnCutOffDate"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "IsDenouncedOnCutOffDate"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "IsOverdue"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "IsDenounced"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "IsStateSupported"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "IsStateSubsidised"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "DebtType"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "IsBusinessProduct"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "DebtAmount"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "Currency"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "DebtDate"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "OverdueDays"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "OverdueDate"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "DenouncementDate"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "IsRestructured"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "LastRestructureDate"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "RequestDateTime"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "System"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "IsEligibleForRestructure"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "IsEligibleForWriteOff"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "InterestOverdueAmount"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "IncrementAmount"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "PenaltyAmount"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "IsOCWRestructured"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "OCWRestructureDate"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "IsUpdate"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "DenouncementDateOnCutOffDate"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "DenouncementLegalStatus"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "IsThirdPartySupported"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "DebtAmountInOriginalCurrency"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "ExchangeRate"));
        blackhole.consume(findElementValue(requestData, requestDataArray, "ExchangeRateDate"));

        return 1;
    }


    public static String findElementValue(final String data, final char[] dataArray, final String element2search) {
        final char[] openTag = ("<" + element2search + ">").toCharArray();
        final char[] closeTag = ("</" + element2search + ">").toCharArray();

        final int dataLen = dataArray.length;
        final int openLen = openTag.length;

        int start = -1;

        // Search for opening tag in a case-insensitive way
        for (int i = 0; i <= dataLen - openLen; i++) {
            if (regionMatchesIgnoreCase(dataArray, i, openTag)) {
                start = i + openLen;
                break;
            }
        }

        if (start == -1) return "";

        int end = -1;

        // Search for closing tag in a case-insensitive way
        for (int i = start; i <= dataLen - closeTag.length; i++) {
            if (regionMatchesIgnoreCase(dataArray, i, closeTag)) {
                end = i;
                break;
            }
        }

        if (end == -1) return "";

        return data.substring(start, end).trim();
    }

    private static boolean regionMatchesIgnoreCase(char[] requestData, int offset, char[] elementTag) {
        int len = elementTag.length;
        if (offset + len > requestData.length) return false;

        for (int i = 0; i < len; i++) {

            if (Character.toLowerCase(requestData[offset + i]) != Character.toLowerCase(elementTag[i])) {
                return false;
            }
        }
        return true;
    }
}
