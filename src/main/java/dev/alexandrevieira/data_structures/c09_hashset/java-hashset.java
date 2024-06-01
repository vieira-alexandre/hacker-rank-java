package dev.alexandrevieira.data_structures.c09_hashset;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        s.close();

        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            set.add(pair_left[i] + " " + pair_right[i]);
            sb.append(set.size());
            sb.append("\n");
        }

        System.out.print(sb);

    }
}