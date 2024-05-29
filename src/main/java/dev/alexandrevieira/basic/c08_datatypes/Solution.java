package dev.alexandrevieira.basic.c08_datatypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String line = bufferedReader.readLine().trim();

            try {
                long n = Long.parseLong(line);
                sb.append(n);
                sb.append(" can be fitted in:\n");

                if (n >= Byte.MIN_VALUE && n <= Byte.MAX_VALUE) {
                    sb.append("* byte\n");
                }

                if (n >= Short.MIN_VALUE && n <= Short.MAX_VALUE) {
                    sb.append("* short\n");
                }

                if (n >= Integer.MIN_VALUE && n <= Integer.MAX_VALUE) {
                    sb.append("* int\n");
                }

                sb.append("* long\n");
            } catch (NumberFormatException ignored) {
                sb.append(line);
                sb.append(" can't be fitted anywhere.\n");
            }
        }

        bufferedReader.close();

        System.out.println(sb);
    }
}
