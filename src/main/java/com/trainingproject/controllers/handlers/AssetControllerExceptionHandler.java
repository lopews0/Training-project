package com.trainingproject.controllers.handlers;

import com.trainingproject.controllers.handlers.dtos.ErrorMessage;
import com.trainingproject.exceptions.AssetIncompleteException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AssetControllerExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ErrorMessage assetIncompleteExceptionHandler(AssetIncompleteException exception) {
        return ErrorMessage.ErrorMessageBuilder.anErrorMessage()
                .withErrorCode(exception.getErrorCode())
                .withErrorDescription(exception.getMessage())
                .build();
    }
}
