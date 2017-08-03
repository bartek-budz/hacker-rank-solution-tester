package com.bb.hackerRank.solutionTester;

import java.io.InputStream;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CurrencyFormatterSolution {
    private static final Map<String, Locale> LOCALE_BY_COUNTRY =
            Stream.of(
                    new Object[]{"US", Locale.US},
                    new Object[]{"India", Locale.forLanguageTag("en-IN")},
                    new Object[]{"China", Locale.CHINA},
                    new Object[]{"France", Locale.FRANCE}
            ).collect(Collectors.toMap(country -> (String) country[0], locale -> (Locale) locale[1], (v1, v2) -> v1, LinkedHashMap::new));

    public static void main(String[] args) {
        double payment = getPayment(System.in);
        String results = produceResults(payment);
        System.out.print(results);
    }

    private static double getPayment(InputStream in) {
        return new Scanner(in).nextDouble();
    }

    private static String produceResults(double payment) {
        return LOCALE_BY_COUNTRY.entrySet().stream()
                .map(entry -> formatPayment(entry.getKey(), payment, entry.getValue()))
                .reduce("", String::concat);
    }

    private static String formatPayment(String country, double payment, Locale locale) {
        return String.format("%s: %s\n", country, NumberFormat.getCurrencyInstance(locale).format(payment));
    }
}

