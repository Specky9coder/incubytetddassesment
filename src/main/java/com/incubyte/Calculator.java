package com.incubyte;

public class Calculator {


    public int add(String numbers) {

        if (numbers == null || numbers.isEmpty()) return 0;
        return Integer.parseInt(numbers);

    }

}
