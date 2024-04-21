package com.mycompany.currencyconverter;
import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Double> exchangeRates = createExchangeRates(); // Replace with real-time API call

        // Display available currencies
        System.out.println("Available Currencies:");
        for (String currency : exchangeRates.keySet()) {
            System.out.println(currency);
        }

        // Get user input for base and target currencies
        String baseCurrency, targetCurrency;
        do {
            System.out.print("Enter the base currency: ");
            baseCurrency = scanner.nextLine().toUpperCase();
        } while (!exchangeRates.containsKey(baseCurrency));

        do {
            System.out.print("Enter the target currency: ");
            targetCurrency = scanner.nextLine().toUpperCase();
        } while (!exchangeRates.containsKey(targetCurrency) || baseCurrency.equals(targetCurrency));

        // Get amount to convert
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        // Perform conversion (assuming exchangeRates is a valid HashMap)
        double conversionRate = exchangeRates.get(targetCurrency);
        double convertedAmount = amount * conversionRate;

        // Display result
        System.out.printf("%.2f %s is equivalent to %.2f %s\n", amount, baseCurrency, convertedAmount, targetCurrency);

        scanner.close();
    }

    // Replace this with a method to fetch real-time exchange rates from an API
    private static HashMap<String, Double> createExchangeRates() {
        HashMap<String, Double> rates = new HashMap<>();
        rates.put("USD", 1.0); // Assuming USD as base currency
        rates.put("EUR", 0.92); // Placeholder exchange rate (replace with API data)
        rates.put("GBP", 0.82); // Placeholder exchange rate (replace with API data)
        return rates;
    }
}
