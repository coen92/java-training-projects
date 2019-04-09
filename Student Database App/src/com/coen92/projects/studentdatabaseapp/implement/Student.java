package com.coen92.projects.studentdatabaseapp.implement;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentId;
    private String courses = "";                 // <------CHANGE TO ARRAY AND CHANGE METHOD enroll()
    private double tuitionBalance = 0;
    private static double costOfCourse = 200;     // <------MAKE A METHOD THAT WILL SET COSTS DEPENDING ON TYPE OF COURSE
    private static int id = 1000;

    public Student() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a student first name:");
        this.firstName = scanner.nextLine();

        System.out.println("Enter a student last name:");
        this.lastName = scanner.nextLine();

        System.out.println("Enter a student class level:");
        this.gradeYear = scanner.nextInt();

        setStudentId();
        showInfo();
    }

    private void setStudentId() {
        id++;
        this.studentId = gradeYear + "" + id;
    }

    public void enroll() {
        boolean test = true;

        do {
            System.out.println("Enter course to enroll (0 to quit):");
            Scanner scanner = new Scanner(System.in);
            String course = scanner.nextLine();

            if (!course.equals("Q")) {
                this.courses += "\n" + course;
                this.tuitionBalance += costOfCourse;
            } else {
                test = false;
            }
        } while(test);

        System.out.println("ENROLLED IN:\n" + this.courses);
        System.out.println("TUITION BALANCE: " + tuitionBalance);
    }

    public void viewBalance() {
        System.out.println("Your balance is: $" + tuitionBalance);
    }

    public void payTuition() {
        System.out.print("Enter amount of your payment: \n$");
        Scanner scanner = new Scanner(System.in);
        int payment = scanner.nextInt();

        tuitionBalance -= payment;
        System.out.println("Payment of $" + payment + " processed");
        viewBalance();
    }

    public void showInfo() {
        System.out.println("Student ID: " + studentId +
                "\nName: " + firstName + " " + lastName +
                "\nGrade level: " + gradeYear +
                "\nCourses enrolled: " + courses +
                "\nCurrent balance: $" + tuitionBalance);
    }

}
