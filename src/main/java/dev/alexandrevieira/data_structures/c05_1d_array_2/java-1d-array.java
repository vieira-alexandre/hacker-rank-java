package dev.alexandrevieira.data_structures.c05_1d_array_2;

import java.util.Scanner;


class Solution {

    public static boolean canWin(final int leap, final int[] game) {
        return canWin(leap, game, 0);
    }

    public static boolean canWin(final int leap, final int[] game, final int i) {
        if (i < 0 || game[i] == 1)
            return false;

        if (i + 1 >= game.length || i + leap >= game.length)
            return true;

        game[i] = 1;

        return canWin(leap, game, i + leap) || canWin(leap, game, i + 1) || canWin(leap, game, i - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            final int n = scan.nextInt();
            final int leap = scan.nextInt();

            final int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}