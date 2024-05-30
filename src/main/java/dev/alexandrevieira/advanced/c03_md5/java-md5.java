package dev.alexandrevieira.advanced.c03_md5;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        MessageDigest digest = MessageDigest.getInstance("MD5");

        byte[] resultBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));


        StringBuilder sb = new StringBuilder();

        for (byte b : resultBytes) {
            sb.append(String.format("%02x", b));
        }

        System.out.println(sb);
    }
}