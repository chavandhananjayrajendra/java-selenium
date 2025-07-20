package org.example.oops.concepts.account;

public class Account {

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    protected int id;

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    protected double balance;

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void depositMoney(double moneyToBeCredited){
        this.balance +=moneyToBeCredited;
    }

    public void withdrawMoney(double moneyToBeDebited){
        this.balance -= moneyToBeDebited;
    }
    public void transferMoney(double moneyToTransfer,Account accountToTransfer){
        this.balance +=moneyToTransfer;
        this.withdrawMoney(moneyToTransfer);
        accountToTransfer.depositMoney(moneyToTransfer);
    }


}
