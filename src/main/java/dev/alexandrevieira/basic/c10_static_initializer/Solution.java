package dev.alexandrevieira.basic.c10_static_initializer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static final BufferedReader READER;
    private static final int B;
    private static final int H;
    private static final boolean flag;

    static {
        READER = new BufferedReader(new InputStreamReader(System.in));

        try {
            B = Integer.parseInt(READER.readLine());
            H = Integer.parseInt(READER.readLine());
            flag = B > 0 && H > 0;

            if (!flag) System.out.println("java.lang.Exception: Breadth and height must be positive");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }

    }//end of main

}//end of class

