package dev.alexandrevieira.data_structures.c07_map_phone_book;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(sc.nextLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            int phone = Integer.parseInt(sc.nextLine());
            map.put(name, phone);
        }

        while (sc.hasNext()) {
            String name = sc.nextLine();

            Integer phone = map.get(name);

            if (phone == null) {
                sb.append("Not found\n");
                continue;
            }

            sb.append(name);
            sb.append("=");
            sb.append(phone);

            sb.append("\n");
        }

        System.out.println(sb);
    }
}