package com.heinsohn.obl.exception;

import java.io.Serializable;

public class ApiRequestException extends RuntimeException implements Serializable {


    public ApiRequestException(String message){
        super(message);
    }

    public ApiRequestException(String message, Throwable throwable){
        super(message, throwable);
    }

}
