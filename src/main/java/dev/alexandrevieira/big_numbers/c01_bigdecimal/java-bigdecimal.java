package dev.alexandrevieira.big_numbers.c01_bigdecimal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        String[] aux = s;

        s = new String[n];
        System.arraycopy(aux, 0, s, 0, n);
        Arrays.sort(s, (s1, s2) -> new BigDecimal(s2).compareTo(new BigDecimal(s1)));


        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}