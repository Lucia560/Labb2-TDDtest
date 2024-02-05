package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {


    public int Add(String numbers) {

        if (numbers.isEmpty()) {
            return 0;
        }
         else if (numbers.contains(",\n") || numbers.contains("\n,")) {
            throw new IllegalArgumentException("Invalid format.");
        }


        String delimiter = "[,\n]";
         if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = Pattern.quote(numbers.substring(2, delimiterIndex));
            numbers = numbers.substring(delimiterIndex + 1);
        }

         String[] numbersArray = numbers.split(delimiter);
         int sum = 0;
         for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                sum += Integer.parseInt(number.trim());
            }
         } return sum;
    }
}











