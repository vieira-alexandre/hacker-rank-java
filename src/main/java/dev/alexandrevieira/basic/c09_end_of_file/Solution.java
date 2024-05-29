package dev.alexandrevieira.basic.c09_end_of_file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        StringBuilder sb = new StringBuilder();

        int count = 0;

        String line = bufferedReader.readLine();

        do {
            sb.append(++count);
            sb.append(" ");
            sb.append(line);
            sb.append("\n");

            line = bufferedReader.readLine();
        }while (line != null);

        bufferedReader.close();

        System.out.println(sb);
    }
}
