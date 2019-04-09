package com.coen92.projects.bankaccountapp.api;

public interface IBaseRate {

    //Method that returns a base rate for specific account
    default double getBaseRate() {
        return 2.5;
    }
}
