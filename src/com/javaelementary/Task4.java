package com.javaelementary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task4 {

    /*
    4*. Написать рекурсивный(!!!) метод который выводит все перестановки строки.
    Например для строки abc: abc, acb, bac, bca, cab, cba
    */

    public static void main(String[] args) {
        String s = "abcc";
        char[] arr = new char[s.length()];
        s.getChars(0, s.length(), arr, arr[0]);
        System.out.println("All combinations of string \"" + s + "\": " + getCombinations(arr));
        System.out.println("Combinations of string \"" + s + "\" without duplicates: " + getCombinationsAndRemoveDuplicates(arr));
    }

    public static Set<String> getCombinationsAndRemoveDuplicates(char[] arr) {
        Set<String> filteredCombinations = new HashSet<>();
        for (StringBuilder sb : getCombinations(arr)) {
            filteredCombinations.add(sb.toString());
        }
        return filteredCombinations;
    }

    public static List<StringBuilder> getCombinations(char[] arr) {
        List<StringBuilder> combinations = new ArrayList<>();
        if (arr.length == 2) {
            StringBuilder sb1 = new StringBuilder();
            sb1.append(arr[0]);
            sb1.append(arr[1]);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(arr[1]);
            sb2.append(arr[0]);
            return Arrays.asList(sb1, sb2);
        } else {
            for (int i = 0; i < arr.length; i++) {
                for (StringBuilder sb : getCombinations(excludingElements(arr, i))) {
                    combinations.add(sb.insert(0, arr[i]));
                }
            }
        }
        return combinations;
    }

    private static char[] excludingElements(char[] arr, int i) {
        char[] result = new char[arr.length - 1];
        int k = 0;
        for (int j = 0; j < arr.length; j++) {
            if (j != i) {
                result[k] = arr[j];
                k++;
            }
        }
        return result;
    }
}