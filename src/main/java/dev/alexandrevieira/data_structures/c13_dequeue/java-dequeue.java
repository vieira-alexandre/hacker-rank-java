package dev.alexandrevieira.data_structures.c13_dequeue;

import java.util.*;

class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new LinkedList<>();
        int n = in.nextInt();
        int m = in.nextInt();

        Set<Integer> set = new HashSet<>();
        int max = 0;


        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            deque.addLast(num);
            set.add(num);

            if (deque.size() == m) {
                int size = set.size();
                if (size > max) max = size;

                int first = deque.removeFirst();

                if (!deque.contains(first))
                    set.remove(first);
            }

            if (max == m) break;
        }

        System.out.println(max);
    }
}