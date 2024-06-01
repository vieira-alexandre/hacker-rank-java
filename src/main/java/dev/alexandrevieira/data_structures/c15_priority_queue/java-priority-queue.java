package dev.alexandrevieira.data_structures.c15_priority_queue;

import java.util.*;
import java.util.stream.Collectors;

class Student {
    private final int id;
    private final String name;
    private final double CGPA;

    Student(int id, String name, double CGPA) {
        this.id = id;
        this.name = name;
        this.CGPA = CGPA;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public double getCGPA() {
        return CGPA;
    }
}

class Priorities {
    private final Comparator<Student> comparator = Comparator.comparing(Student::getCGPA).reversed()
            .thenComparing(Student::getName)
            .thenComparing(Student::getID);

    private final PriorityQueue<Student> queue = new PriorityQueue<>(comparator);

    List<Student> getStudents(final List<String> events) {

        for (String event : events) {
            if (event.startsWith("ENTER")) {
                final String[] split = event.split(" ");
                final Student student = new Student(Integer.parseInt(split[3]), split[1], Double.parseDouble(split[2]));
                queue.add(student);
            } else {
                queue.poll();
            }
        }

        return queue.stream().sorted(comparator).collect(Collectors.toList());
    }
}

class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        final List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        final List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}