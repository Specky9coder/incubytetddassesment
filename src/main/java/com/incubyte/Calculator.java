package com.incubyte;

public class Calculator {
    private int callCount = 0;

    public int add(String numbers) {
        callCount++;

        if (numbers == null || numbers.isEmpty()) return 0;
        String[] parts = numbers.split(",|\n");
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
