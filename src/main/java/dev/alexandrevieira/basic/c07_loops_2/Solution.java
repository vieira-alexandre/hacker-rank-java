package dev.alexandrevieira.basic.c07_loops_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            String line = bufferedReader.readLine().trim();

            List<Integer> list = Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            int a = list.get(0);
            int b = list.get(1);
            int n = list.get(2);

            calculateSeries(a, b, n, sb);
        }

        bufferedReader.close();

        System.out.println(sb);
    }

    public static void calculateSeries(int a, int b, int n, StringBuilder sb) {
        int last = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                int value = a + b;
                sb.append(value);
                last = value;
                continue;
            }

            int pow = (int) Math.pow(2, i);
            int value = last + pow * b;

            sb.append(" ");
            sb.append(value);
            last = value;
        }

        sb.append("\n");
    }
}


