package dev.alexandrevieira.data_structures.c02_2d_array;

import java.io.*;


class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = 6;

        int[][] arr = new int[size][size];

        for (int i = 0; i < size; i++) {

            String[] items = br.readLine().split(" ");

            for (int j = 0; j < size; j++) {
                arr[i][j] = Integer.parseInt(items[j]);
            }

        }

        br.close();

        int biggestHourGlass = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1) continue;
                int hourGlassValue = getHourGlassValue(i, j, arr);
                if (hourGlassValue > biggestHourGlass) biggestHourGlass = hourGlassValue;
            }
        }

        System.out.println(biggestHourGlass);
    }

    private static int getHourGlassValue(int y, int x, int[][] arr) {
        int sum = 0;

        sum += arr[x - 1][y - 1];
        sum += arr[x - 1][y];
        sum += arr[x - 1][y + 1];

        sum += arr[x][y];

        sum += arr[x + 1][y - 1];
        sum += arr[x + 1][y];
        sum += arr[x + 1][y + 1];

        return sum;
    }
}