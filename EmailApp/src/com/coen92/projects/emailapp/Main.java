package com.coen92.projects.emailapp;

import com.coen92.projects.emailapp.implement.Email;

public class Main {

    public static void main(String[] args) {

        Email employee01 = new Email("Jack", "Daniels");


        employee01.changePassword("abcdefg");
        employee01.changePassword("12345");
    }
}
