package dev.alexandrevieira.data_structures.c14_bitset;

import java.util.BitSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        StringBuilder sb = new StringBuilder();

        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);

        for (int i = 0; i < m; i++) {
            line = sc.nextLine().split(" ");
            String operation = line[0];
            int o1 = Integer.parseInt(line[1]);
            int o2 = Integer.parseInt(line[2]);

            switch (operation) {
                case "AND" -> {
                    if (o1 == 1) b1.and(b2);
                    else b2.and(b1);
                }
                case "OR" -> {
                    if (o1 == 1) b1.or(b2);
                    else b2.or(b1);
                }
                case "XOR" -> {
                    if (o1 == 1) b1.xor(b2);
                    else b2.xor(b1);
                }
                case "FLIP" -> {
                    if(o1 == 1) b1.flip(o2);
                    else b2.flip(o2);
                }
                case "SET" -> {
                    if(o1 ==1) b1.set(o2, true);
                    else b2.set(o2, true);
                }
                default -> throw new IllegalStateException("invalid operation");
            }
            sb.append(b1.cardinality());
            sb.append(" ");
            sb.append(b2.cardinality());
            sb.append("\n");
        }

        System.out.print(sb);
    }
}