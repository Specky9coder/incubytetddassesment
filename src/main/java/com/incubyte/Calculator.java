package com.incubyte;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Calculator {
    private int callCount = 0;

    public int add(String numbers) {
        callCount++;

        if (numbers == null || numbers.isEmpty()) return 0;

        String delimitersRegex = ",|\n"; // default


        if (numbers.startsWith("//")) {

            int delimiterEndIndex = numbers.indexOf("\n");

            String delimiterPart = numbers.substring(2, delimiterEndIndex);

            // single-char custom delimiter
            if (delimiterPart.startsWith("[")) {

                Matcher m = Pattern.compile("\\[(.*?)]").matcher(delimiterPart);


                List<String> delimiters = new ArrayList<>();

                while (m.find()) {

                    delimiters.add(Pattern.quote(m.group(1))); // escape regex chars

                }
                delimitersRegex = String.join("|", delimiters);
            } else {

                // Single-char delimiter

                delimitersRegex = Pattern.quote(delimiterPart);

            }
            numbers = numbers.substring(delimiterEndIndex + 1);

        }

        String[] tokens = numbers.split(delimitersRegex);

        List<Integer> negatives = new ArrayList<>();

        int sum = 0;


        for (String token : tokens) {
            if (token.isEmpty()) continue;

            int n = Integer.parseInt(token);

            if (n < 0) negatives.add(n);

            if (n <= 1000) sum += n;
        }

        if (!negatives.isEmpty()) {

            throw new IllegalArgumentException("negatives not allowed: " + negatives);

        }
        return sum;

    }

    public int getCalledCount() {
        return callCount;
    }
}
