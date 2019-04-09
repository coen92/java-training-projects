package com.coen92.projects.bankaccountapp;

import com.coen92.projects.bankaccountapp.implement.Account;
import com.coen92.projects.bankaccountapp.implement.CheckingAcc;
import com.coen92.projects.bankaccountapp.implement.SavingsAcc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static String file = "NewBankAccounts.csv";

    public static void main(String[] args) {

        List<Account> accounts = new LinkedList<Account>();


        //Read a CSV File then create new accounts based on that data
        List<String[]> newAccountHolders = com.coen92.projects.bankaccountapp.utilities.CSV.read(file);

        for(int i=0; i<newAccountHolders.size(); i++) {

            String[] accountHolder = newAccountHolders.get(i);
            String name = accountHolder[0];
            String socialSecurityNumber = accountHolder[1];
            String accountType = accountHolder[2];
            double balance = Double.parseDouble(accountHolder[3]);

            //System.out.println(Arrays.toString(accountHolder));
            System.out.println("NAME: " + name +
                    "\nSECURITY NUMBER: " + socialSecurityNumber +
                    "\nACCOUNT TYPE: " + accountType +
                    "\nBALANCE: $" + balance +"\n");

            if(accountType.equals("Savings")) {
                accounts.add(new SavingsAcc(name, socialSecurityNumber, balance));

            } else if (accountType.equals("Checking")) {
                accounts.add(new CheckingAcc(name, socialSecurityNumber, balance));

            } else {
                System.out.println("ERROR READING ACCOUNT TYPE...");
            }
        }
    }
}
