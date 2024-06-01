package dev.alexandrevieira.data_structures.c06_list;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String ignored = sc.nextLine();

        List<Integer> list = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int q = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < q; i++) {
            String op = sc.nextLine().trim();
            String params = sc.nextLine();

            if (op.equals("Insert")) {
                List<Integer> parsedParams = Arrays.stream(params.split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                int index = parsedParams.get(0);
                int element = parsedParams.get(1);
                list.add(index, element);
            } else {
                list.remove(Integer.parseInt(params));
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));

            if (i + 1 != list.size())
                sb.append(" ");
        }

        System.out.println(sb);
    }
}