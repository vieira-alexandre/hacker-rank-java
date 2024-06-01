package dev.alexandrevieira.data_structures.c11_sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class StudentComparator {
    static Comparator<Student> compareByNameAndId() {
        return (o1, o2) -> {
            int compareCgpa = Double.compare(o1.getCgpa(), o2.getCgpa());
            if (compareCgpa != 0) return compareCgpa * -1;

            int compareName = o1.getFname().compareTo(o2.getFname());
            if (compareName != 0) return compareName;

            return Integer.compare(o1.getId(), o2.getId());
        };
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<>();
        while (testCases > 0) {
            String[] line = in.nextLine().trim().split(" ");
            int id = Integer.parseInt(line[0]);
            String fname = line[1];
            double cgpa = Double.parseDouble(line[2]);

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        studentList.sort(StudentComparator.compareByNameAndId());

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}