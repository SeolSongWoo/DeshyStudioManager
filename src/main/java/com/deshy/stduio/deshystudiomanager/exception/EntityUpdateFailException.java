package com.deshy.stduio.deshystudiomanager.exception;


public class EntityUpdateFailException extends RuntimeException {

    public EntityUpdateFailException(String message) {
        super(message);
    }

    public EntityUpdateFailException(String message, Throwable cause) {
        super(message, cause);
    }
}
