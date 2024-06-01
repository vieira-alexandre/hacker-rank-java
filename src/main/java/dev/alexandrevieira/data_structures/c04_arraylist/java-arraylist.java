package dev.alexandrevieira.data_structures.c04_arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(sc.nextLine());

        List<List<Integer>> data = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            List<Integer> values = new ArrayList<>(d);

            for (int j = 0; j < d; j++) {
                values.add(sc.nextInt());
            }

            data.add(i, values);
        }

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            List<Integer> list = data.get(x - 1);

            if (list.size() < y) {
                sb.append("ERROR!\n");
            } else {
                sb.append(list.get(y - 1));
                sb.append("\n");
            }

        }

        System.out.println(sb);
        sc.close();
    }
}
