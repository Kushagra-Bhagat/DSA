package org.basic.exceptionHandling.example;

public class LowBalanceException extends Exception{

    public LowBalanceException() {
        super("Not sufficient funds!");
    }
}
