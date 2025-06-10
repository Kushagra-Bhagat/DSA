package org.basic.exceptionHandling.example;

public class Bank {
    public static void main(String[] args) throws LowBalanceException {
        WithdrawMoney user = new WithdrawMoney(100);
        user.withdraw(1000);
    }
}
