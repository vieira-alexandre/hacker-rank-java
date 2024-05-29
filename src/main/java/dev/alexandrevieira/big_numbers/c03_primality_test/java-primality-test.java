package dev.alexandrevieira.big_numbers.c03_primality_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger n = new BigInteger(bufferedReader.readLine());

        bufferedReader.close();

        System.out.println(n.isProbablePrime(1) ? "prime" : "not prime");
    }
}
