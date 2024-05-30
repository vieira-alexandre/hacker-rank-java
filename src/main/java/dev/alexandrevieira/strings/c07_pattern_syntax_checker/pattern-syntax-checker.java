package dev.alexandrevieira.strings.c07_pattern_syntax_checker;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String string = scan.nextLine().trim();

            try {
                Pattern.compile(string);
                System.out.println("Valid");
            } catch (PatternSyntaxException ignored) {
                System.out.println("Invalid");
            }
        }

        scan.close();
    }
}



