package asm02.models;

import java.util.Scanner;

public class Account {
    private String accountNumber;
    private Double balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public boolean isPremium(){
        if (this.balance >= 10000000){
            return true;
        }
        return false;
    }
    @Override
    /*public  String toString(){
        return this.accountNumber+" |\t\t\t"+String.format("%,d",this.balance)+"d";
    }*/
    public  String toString(){
        return this.accountNumber+" |\t\t\t"+this.balance+"d";
    }
}
