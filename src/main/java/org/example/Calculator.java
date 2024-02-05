package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {


    public int Add(String numbers) {

        if (numbers.isEmpty()) {
            return 0;
        } else if (numbers.contains(",\n") || numbers.contains("\n,")) {
            throw new IllegalArgumentException("Invalid format.");
        }


        String delimiter = "[,\n]";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = Pattern.quote(numbers.substring(2, delimiterIndex));
            numbers = numbers.substring(delimiterIndex + 1);
        }

        String[] numbersArray = numbers.split(delimiter);
        List<Integer> negativeNumbers = new ArrayList<>();
        int sum = 0;
        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                int num = Integer.parseInt(number.trim());
                if (num < 0) {
                    negativeNumbers.add(num);
                } else {
                    sum += num;
                }
            }
        }
        if (!negativeNumbers.isEmpty()) {
            String negativeNumberString = negativeNumbers.stream()
                    .map(n -> n.toString())
                    .collect(Collectors.joining(", "));
            throw new IllegalArgumentException("Negative numbers are not allowed:" + negativeNumberString);
        }

        return sum;
    }
}















