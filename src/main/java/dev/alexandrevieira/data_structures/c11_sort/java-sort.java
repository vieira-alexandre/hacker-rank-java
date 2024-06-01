package dev.alexandrevieira.data_structures.c11_sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
    public static final Comparator<Student> COMPARATOR = Comparator.comparing(Student::getCgpa).reversed()
            .thenComparing(Student::getFname)
            .thenComparing(Student::getId);

    private final int id;
    private final String fname;
    private final double cgpa;

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

        studentList.sort(Student.COMPARATOR);

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}