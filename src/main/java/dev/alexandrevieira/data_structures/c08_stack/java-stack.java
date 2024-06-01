package dev.alexandrevieira.data_structures.c08_stack;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

class Solution {

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            boolean balanced = true;
            String input = sc.nextLine();
            Stack<Character> tokens = new Stack<>();

            for (char ch : input.toCharArray()) {
                switch (ch) {
                    case '{', '(', '[':
                        tokens.push(ch);
                        break;

                    case '}':
                        try {
                            if (tokens.pop() != '{') balanced = false;
                        } catch (EmptyStackException e) {
                            balanced = false;
                        }
                        break;
                    case ')':
                        try {
                            if (tokens.pop() != '(') balanced = false;
                        } catch (EmptyStackException e) {
                            balanced = false;
                        }
                        break;
                    case ']':
                        try {
                            if (tokens.pop() != '[') balanced = false;
                        } catch (EmptyStackException e) {
                            balanced = false;
                        }
                        break;
                    default:
                        throw new IllegalStateException("unexpected char");
                }
            }

            System.out.println(balanced && tokens.isEmpty());
        }
    }
}