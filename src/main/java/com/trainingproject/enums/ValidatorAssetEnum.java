package com.trainingproject.enums;

public enum ValidatorAssetEnum {
    NO_AMOUNT("no amount");

    private String message;

    ValidatorAssetEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
