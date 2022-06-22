package com.lisa.demo.exceptions;


public class TransactionNotExistException extends RuntimeException {
    public TransactionNotExistException(String message) {
        super(message);
    }
}
