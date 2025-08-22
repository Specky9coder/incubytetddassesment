package com.incubyte;

public class Calculator {
    private int callCount = 0;

    public int add(String numbers) {
        callCount++;

        if (numbers == null || numbers.isEmpty()) return 0;

        String delimitersRegex = ",|\n"; // default
        String payload = numbers;

        if (numbers.startsWith("//")) {

            int nl = numbers.indexOf('\n');
            String header = numbers.substring(2, nl);
            payload = numbers.substring(nl + 1);

            // single-char custom delimiter
            if (!header.isEmpty()) {
                String escaped = java.util.regex.Pattern.quote(header);
                delimitersRegex = delimitersRegex + "|" + escaped;
            }
        }

        String[] parts = payload.split(delimitersRegex);
        int sum = 0;
        for (String p : parts) {
            if (!p.isEmpty()) sum += Integer.parseInt(p);
        }
        return sum;

    }

    public int getCalledCount() {
        return callCount;
    }
}
