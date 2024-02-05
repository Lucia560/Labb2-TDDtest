package org.example;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    String numbers;

    public int Add(String numbers) {

        // empty or null
        if (numbers.isEmpty() || numbers == null) {
            return 0;
        }
        //correct input format, new line
        if (numbers.contains(",\n") || numbers.contains("\n,")) {
            throw new IllegalArgumentException("Invalid format.");
        }

        String[] numbersAllowed = numbers.split(",|\\n");

        // unknown amount  of numbers, change to List<>
        List<Integer> numberList = new ArrayList<>();

        for (String num : numbersAllowed) {
            if (!num.trim().isEmpty()) { // dont parse empty strings
                numberList.add(Integer.parseInt(num.trim())); // add to the List
            }
        }

        int sum = 0;
        for (int number : numberList) {
            sum += number;
        }
        return sum;

    }
}
