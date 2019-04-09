package com.coen92.projects.bankaccountapp.implement;

public class CheckingAcc extends Account {

    private int debitCardNumber;
    private int debitCardPin;

    public CheckingAcc(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "2" + accountNumber;

        setDebitCard();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() * .15;
    }

    private void setDebitCard() {
        debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
        debitCardPin = (int) (Math.random() * Math.pow(10, 4));
    }

    @Override
    public void showInfo() {
        System.out.println("ACCOUNT TYPE: Checking");
        super.showInfo();

        System.out.println("    Your Checking account features:" +
                "\n    - Debit Card number: " + debitCardNumber +
                "\n    - Debit Card pin: " + debitCardPin
        );
    }
}
