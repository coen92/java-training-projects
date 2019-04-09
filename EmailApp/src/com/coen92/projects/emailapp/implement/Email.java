package com.coen92.projects.emailapp.implement;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 250;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private final String COMPANY_SUFFIX = "company.com";

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //Calling a method that asks for a department of employee we create email for
        this.department = setDepartment();
        System.out.println("Your department is: " + this.department);

        //Calling a method to generate default password for employee
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your authomatically generated password is: " + this.password);

        //Combine elements to generate email
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.department.toLowerCase()
                + "." + COMPANY_SUFFIX;
        System.out.println("Your email adress is: " + this.email);
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public void changePassword(String password) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your old password to validate: ");
        String validation = scanner.nextLine();

        if(validation.equals(this.password)) {
            this.password = password;
            System.out.println("Password changed successfully...");
        } else {
            System.out.println("Invalid password typed!");
        }
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    private String setDepartment() {
        System.out.println("DEPARTMENT CODES:\n1 for Sales\n2 for Develompemt\n3 for Accounting\n0 for none\n" +
                "Enter department code: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        String department;

        switch(choice) {
            case 1:
                department = "Sales";
                break;
            case 2:
                department = "Development";
                break;
            case 3:
                department = "Accounting";
                break;
            default:
                department = "";
                break;
        }
        return department;
    }

    private String randomPassword(int lenght) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";
        char[] password = new char[lenght];

        for(int i=0; i<lenght; i++) {
            int random = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }
}
