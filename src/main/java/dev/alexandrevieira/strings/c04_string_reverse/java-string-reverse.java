package dev.alexandrevieira.strings.c04_string_reverse;

import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        boolean equals = true;

        for (int i = 0, k = A.length() - 1; i < A.length(); i++, k--) {
            if (A.charAt(i) != A.charAt(k)) {
                equals = false;
                break;
            }
        }

        System.out.println(equals ? "Yes" : "No");
    }
}



