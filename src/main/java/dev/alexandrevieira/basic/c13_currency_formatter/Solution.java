package dev.alexandrevieira.basic.c13_currency_formatter;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();


        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);

        Locale indiaLocale = new Locale("en", "IN");
        Currency indiaRupee = Currency.getInstance("INR");
        NumberFormat indiaFormatter = NumberFormat.getCurrencyInstance(indiaLocale);
        indiaFormatter.setCurrency(indiaRupee);
        String india = indiaFormatter.format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
