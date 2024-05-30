package dev.alexandrevieira.basic.c06_loops_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        bufferedReader.close();

        StringBuilder sb = new StringBuilder();


        for (int i = 1; i <= 10; i++) {
            sb.append(n);
            sb.append(" x ");
            sb.append(i);
            sb.append(" = ");
            sb.append(n * i);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

