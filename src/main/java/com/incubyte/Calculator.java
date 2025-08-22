package com.incubyte;

public class Calculator {


    public int add(String numbers) {

        if (numbers == null || numbers.isEmpty()) return 0;
        String[] parts = numbers.split(",");
        int sum = 0;
        for (String p : parts) {
            if (!p.isEmpty()) sum += Integer.parseInt(p);
        }
        return sum;

    }

}
