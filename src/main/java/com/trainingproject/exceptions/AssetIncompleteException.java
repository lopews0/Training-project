package com.trainingproject.exceptions;

public class AssetIncompleteException extends RuntimeException {

    private final String errorCode;

    public AssetIncompleteException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
