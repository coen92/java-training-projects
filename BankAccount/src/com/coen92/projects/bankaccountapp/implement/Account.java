package com.coen92.projects.bankaccountapp.implement;

import com.coen92.projects.bankaccountapp.api.IBaseRate;

public abstract class Account implements IBaseRate {

    private String name;
    private String socialSecuirtyNumber;
    protected String accountNumber;
    private double balance;
    protected double rate;

    private static int index = 10000;

    public Account(String name, String sSN, double initDeposit) {

        this.name = name;
        this.socialSecuirtyNumber = sSN;
        this.balance = initDeposit;

        this.accountNumber = setAccountNumber();

        setRate();
    }

    public abstract void setRate();

    private String setAccountNumber() {
        String lastTwoOfSSN = socialSecuirtyNumber.substring(socialSecuirtyNumber.length()-2);
        int uniqueId = index;
        index++;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3)); //Math.random returns double value >= 0.0 && < 1.0
        return lastTwoOfSSN + uniqueId + randomNumber;
    }

    public void compound() {
        double accruedInterest = balance * (rate/100);
        System.out.println("Accrued interest: $" + accruedInterest);
        balance += accruedInterest;
        printBalance();
    }

    public boolean deposit(double amount) {
        if(amount >= 0) {
            balance += amount;
            System.out.println("Depositing $" + amount);
            printBalance();
            return true;
        } else {
            System.out.println("Invalid value!");
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if(amount >= 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawing $" + amount);
            printBalance();
            return true;
        } else {
            System.out.println("Insuficcient credit!");
            return false;
        }
    }

    public void transfer(String toWhere, double amount) {
        if(withdraw(amount)) {
            withdraw(amount);
            System.out.println("Transfering $" + amount + " to " + toWhere);
            printBalance();
        }
    }

    private void printBalance() {
        System.out.println("Your balance is now: $" + balance);
    }

    public void showInfo() {
        System.out.println(
                "NAME: " + name +
                "\nACCOUNT NUMBER: " + accountNumber +
                "\nBALANCE: " + balance +
                "\nRATE: " + rate +"%"
        );
    }
}
