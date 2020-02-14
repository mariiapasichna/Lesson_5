package com.javaelementary;

import java.util.Deque;
import java.util.LinkedList;

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
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < robotRoute.length(); i++) {
            char ch = robotRoute.charAt(i);
            if (deque.isEmpty()) {
                deque.addFirst(ch);
            } else {
                switch (ch) {
                    case 'R':
                        if (deque.peekFirst() == 'L') {
                            deque.pollFirst();
                        } else if (deque.peekLast() == 'L') {
                            deque.pollLast();
                        } else {
                            deque.addFirst(ch);
                        }
                        break;
                    case 'L':
                        if (deque.peekFirst() == 'R') {
                            deque.pollFirst();
                        } else if (deque.peekLast() == 'R') {
                            deque.pollLast();
                        } else {
                            deque.addFirst(ch);
                        }
                        break;
                    case 'U':
                        if (deque.peekFirst() == 'D') {
                            deque.pollFirst();
                        } else if (deque.peekLast() == 'D') {
                            deque.pollLast();
                        } else {
                            deque.addFirst(ch);
                        }
                        break;
                    case 'D':
                        if (deque.peekFirst() == 'U') {
                            deque.pollFirst();
                        } else if (deque.peekLast() == 'U') {
                            deque.pollLast();
                        } else {
                            deque.addFirst(ch);
                        }
                        break;
                    default:
                        throw new RuntimeException("Unexpected char: " + ch);
                }
            }
        }
        return deque.isEmpty();
    }
}