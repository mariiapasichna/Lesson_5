package com.javaelementary;

import java.util.ArrayList;
import java.util.List;

public class Task2 {

    /*
    2. Написать метод который проверяет число простое или нет. Если нет вывести все его делители.
    */

    public static void main(String[] args) {
        System.out.println(isPrime(153));
    }

    private static boolean isPrime(int number) {
        List<Integer> divisors = new ArrayList<>();
        if (number == 2) {
            return true;
        } else if (number % 2 == 0) {
            while (number % 2 == 0 && number != 2) {
                number /= 2;
                divisors.add(2);
            }
            foundAndPrintDivisors(number, divisors);
            return false;
        } else {
            for (int i = 3; i * i <= number; i += 2) {
                if (number % i == 0) {
                    foundAndPrintDivisors(number, divisors);
                    return false;
                }
            }
            return true;
        }
    }

    private static void foundAndPrintDivisors(int number, List<Integer> divisors) {
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                while (number % i == 0 && number != i) {
                    number /= i;
                    divisors.add(i);
                }
            }
        }
        divisors.add(number);
        System.out.println("Divisors of number: " + divisors);
    }
}