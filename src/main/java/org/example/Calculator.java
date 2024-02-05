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
        //max 2 numbers
        String[] numbersAllowed = numbers.split(",");
        if (numbersAllowed.length > 2) {
            throw new RuntimeException("Max 2 numbers allowed");
        }
        int sum = 0;
        for (String num : numbersAllowed) {
            if (!num.trim().isEmpty()) { // dont parse empty strings
                sum += Integer.parseInt(num.trim());
            }
        }
        return sum;

    }
}
