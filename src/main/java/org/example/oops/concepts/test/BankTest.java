package org.example.oops.concepts.test;

import org.example.oops.concepts.account.Account;

import java.sql.SQLOutput;

public class BankTest {
    public static void main(String[] args) {
        Account a1 = new Account(1,1000);
        Account a2 = new Account(2,2000);
        a1.depositMoney(1000);
        System.out.println("A1 balance is "+ a1.getBalance());

        a2.withdrawMoney(1000);
        System.out.println("A2 balance is "+a2.getBalance());

        a1.transferMoney(100,a2);
        System.out.println("A1 balance is "+ a1.getBalance());
        System.out.println("A2 balance is "+a2.getBalance());

    }
}
