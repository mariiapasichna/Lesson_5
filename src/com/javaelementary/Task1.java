package com.javaelementary;

public class Task1 {

    /*
    1. Есть поле из клеток посредине которого находится робот. Робот умеет выполнять 4 команды: двигаться на 1 клетку
    в сторону: R (right), L (left), U (up), and D (down).
    Задана строка из движений робота например "UUDLDR". Написать метод который вернет true если робот вернется в ту же клетку
    с которой начал.
    Input: "UD"
    Output: true
    Input: "LL"
    Output: false
    */

    public static void main(String[] args) {
        System.out.println(backHome("UUDLDR"));
    }

    private static boolean backHome(String robotRoute) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < robotRoute.length(); i++) {
            char ch = robotRoute.charAt(i);
            switch (ch) {
                case 'R':
                    y++;
                    break;
                case 'L':
                    y--;
                    break;
                case 'U':
                    x++;
                    break;
                case 'D':
                    x--;
                    break;
                default:
                    throw new RuntimeException("Unexpected char: " + ch);
            }
        }
        return x == 0 && y == 0;
    }
}