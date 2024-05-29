package dev.alexandrevieira.strings.c01_strings_introduction;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        System.out.println(A.length() + B.length());

        String aIsGreater = A.compareTo(B) > 0 ? "Yes" : "No";
        System.out.println(aIsGreater);

        String aUpperCase = String.valueOf(A.charAt(0)).toUpperCase();
        String bUpperCase = String.valueOf(B.charAt(0)).toUpperCase();

        System.out.println(aUpperCase + A.substring(1) + " " + bUpperCase + B.substring(1));
    }
}



