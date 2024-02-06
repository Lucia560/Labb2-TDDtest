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


        String delimiter = "[,\n]"; // default delimiter
        if (numbers.startsWith("//")) { // custom delimiter
            int delimiterIndex = numbers.indexOf("\n");
            String delimiterPart = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
            delimiter = parseDelimiter(delimiterPart);
        }


        String[] numbersArray = numbers.split(delimiter);
        List<Integer> negativeNumbers = new ArrayList<>();
        int sum = 0;
        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                int num = Integer.parseInt(number.trim());
                if (num < 0) {
                    negativeNumbers.add(num);
                } else if (num < 1000) {
                    sum += num;
                }
            }
        }
        if (!negativeNumbers.isEmpty()) {
            String negativeNumberString = negativeNumbers.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
            throw new IllegalArgumentException("Negative numbers are not allowed:" + negativeNumberString);
        }

        return sum;
    }

    private String parseDelimiter(String delimiterPart) {
        if (delimiterPart.startsWith("[")) {
            delimiterPart = delimiterPart.substring(1, delimiterPart.length() - 1);
        }
        return Pattern.quote(delimiterPart);
    }

}













