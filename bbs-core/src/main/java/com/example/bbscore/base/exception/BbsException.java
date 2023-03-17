package com.example.bbscore.base.exception;

public class BbsException extends RuntimeException {

    private final String code;


    public BbsException(String code) {
        super(code);
        this.code = code;
    }
}
