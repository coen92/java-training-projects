package com.coen92.projects.studentdatabaseapp;

import com.coen92.projects.studentdatabaseapp.implement.Student;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter the number of students to add: ");
        int numOfStudents = scanner.nextInt();

        Student[] students = new Student[numOfStudents];

        for(int i=0; i<students.length; i++) {
            students[i] = new Student();
            students[i].enroll();
            students[i].payTuition();
            students[i].showInfo();
        }
    }

}
