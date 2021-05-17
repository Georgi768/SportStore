package com.SportStore.Exceptions;

public class CustomerIsNotInCashRegisterExceptions extends Exception{
    public CustomerIsNotInCashRegisterExceptions() {
        super("This customer is not in the cashRegister list");
    }
}
