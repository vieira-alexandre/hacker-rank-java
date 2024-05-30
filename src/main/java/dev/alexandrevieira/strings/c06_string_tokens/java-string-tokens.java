package dev.alexandrevieira.strings.c06_string_tokens;

import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine().trim();

        String regex = "[ !,?._'@]+";

        String[] tokens = s.split(regex);

        if (tokens.length == 1 && tokens[0].isEmpty()) {
            System.out.println(0);
            return;
        }

        System.out.println(tokens.length);

        for (String token : tokens) {
            System.out.println(token);
        }

        scan.close();
    }
}
