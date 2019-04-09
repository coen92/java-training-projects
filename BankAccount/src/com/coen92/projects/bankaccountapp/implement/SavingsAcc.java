package com.coen92.projects.bankaccountapp.implement;

public class SavingsAcc extends Account {

    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    public SavingsAcc(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;

        setSafetyDepositBox();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - .25;
    }

    private void setSafetyDepositBox() {
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }

    @Override
    public void showInfo() {
        System.out.println("ACCOUNT TYPE: Savings");
        super.showInfo();

        System.out.println("    Your Saving account features:" +
                "\n    - Safety Deposit Box ID: " + safetyDepositBoxID +
                "\n    - Safety Deposit Boxy Key: " + safetyDepositBoxKey
        );
    }
}
