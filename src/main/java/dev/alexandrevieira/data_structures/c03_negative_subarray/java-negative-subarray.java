package dev.alexandrevieira.data_structures.c03_negative_subarray;

import java.io.IOException;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        int count = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {
                if (isSubArrayNegative(i, j + 1, arr))
                    count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isSubArrayNegative(int start, int end, int[] arr) {
        int sum = 0;

        for (int i = start; i < end; i++) {
            sum += arr[i];
        }

        return sum < 0;
    }
}
