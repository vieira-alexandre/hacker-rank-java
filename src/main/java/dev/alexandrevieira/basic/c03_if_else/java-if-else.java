package dev.alexandrevieira.basic.c03_if_else;

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        if (isOdd(n) || (n >= 6 && n <= 20)) {
            System.out.println("Weird");
            return;
        }

        System.out.println("Not Weird");

        scan.close();
    }

    public static boolean isOdd(int n) {
        return n % 2 != 0;
    }
}
