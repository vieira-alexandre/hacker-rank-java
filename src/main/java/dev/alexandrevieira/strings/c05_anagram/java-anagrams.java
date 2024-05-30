package dev.alexandrevieira.strings.c05_anagram;

import java.util.Scanner;

class Solution {

    static boolean isAnagram(String a, String b) {
        String aLower = a.toLowerCase();
        String bLower = b.toLowerCase();

        if (aLower.length() != bLower.length()) return false;

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < alphabet.length(); i++) {
            int aCount = 0;
            int bCount = 0;

            char c = alphabet.charAt(i);

            for (int j = 0; j < aLower.length(); j++) {
                char cA = aLower.charAt(j);
                char cB = bLower.charAt(j);

                if (cA == c) aCount++;
                if (cB == c) bCount++;
            }

            if (aCount != bCount) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
