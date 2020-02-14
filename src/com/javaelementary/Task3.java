package com.javaelementary;

import java.util.Arrays;
import java.util.Random;

public class Task3 {

    /*
    3*. Написать метод. Входящие параметры: отсортированный массив и число.
    Метод должен вернуть true если это число есть в массиве, используя бинарный поиск.
    */

    private static final int SIZE = 100;

    public static void main(String[] args) {
        int[] arr = new int[SIZE];
        int number = 78;
        createArrayAndInit(arr);
        Arrays.sort(arr);
        binarySearch(arr, number);
    }

    private static boolean binarySearch(int[] arr, int number) {
        int first = 0;
        int last = arr.length - 1;
        while (first <= last) {
            int middle = (first + last) / 2;
            if (arr[middle] == number) {
                System.out.println("The number " + number + " is found by index " + middle);
                return true;
            } else if (arr[middle] < number) {
                first = middle + 1;
            } else if (arr[middle] > number) {
                last = middle - 1;
            }
        }
        System.out.println("The number " + number + " isn't found");
        return false;
    }

    private static void createArrayAndInit(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
    }
}