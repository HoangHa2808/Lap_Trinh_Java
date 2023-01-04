package asm02.models;

import asm03.models.LoansAccount;
import asm03.models.SavingsAccount;
import asm03.models.Transaction;
import asm03.models.Utils;
import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Account {
    private String accountNumber;
    private Double balance;

    List<Transaction> transactions = new ArrayList<>();
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Account() {
        this.accountNumber = "";
        this.balance = 0.0;
    }

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

    public double getTransactionFee(){
        double fee = 0.05;
        if (isPremium())
        {
            fee = 0.01;
        }
        return fee;
    }

    public void logHistory(String soTK, double amount){
        Transaction trans = new Transaction();
        trans.setAccountNumber(soTK);
        trans.setAmount(amount);
        trans.setTime(Utils.getDateTime());
        trans.setStatus(true);
        transactions.add(trans);
    }

    public void printHistory(){
        for (Transaction tr:getTransactions()){
            if (tr.getStatus()){
                //System.out.println(tr.getAccountNumber()+ "\t|\t"+Utils.fomatBalance(tr.getAmount())+"\t\t\t\t\t|\t"+tr.getTime());
                System.out.printf("%6s",tr.getAccountNumber());
                System.out.printf("\t|\t%15s",Utils.fomatBalance(tr.getAmount()));
                System.out.printf("\t|%28s%n",tr.getTime());
            }
        }
    }
    public abstract String loaiTK();

    @Override
    public  String toString(){
        return this.accountNumber+" |\t\t\t"+this.balance+"d";
    }
}
