package org.basic.exceptionHandling.example;

public class WithdrawMoney {
    private double balance;

    public WithdrawMoney(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws LowBalanceException{
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Money withdrawn and current balance is: " + balance);
        }
        else {
            throw new LowBalanceException();
        }
    }
}
