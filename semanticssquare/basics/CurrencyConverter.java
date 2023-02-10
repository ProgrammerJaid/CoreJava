package com.semanticssquare.basics;
public class CurrencyConverter {
 
   double[] exchangeRates= new double[]{63.0, 3.0, 3.0, 595.5, 18.0, 107.0, 2.0};
   
    double getExchangeRate(int countryIndex) {

            return exchangeRates[countryIndex];

        }

        double computeTransferAmount(int countryIndex, double amount) {

            return amount * getExchangeRate(countryIndex);

        }
}