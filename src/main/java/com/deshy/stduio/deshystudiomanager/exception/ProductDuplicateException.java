package com.deshy.stduio.deshystudiomanager.exception;

import org.springframework.dao.DataAccessException;

public class ProductDuplicateException extends DataAccessException{
    public ProductDuplicateException(String message) {
        super(message);
    }

    public ProductDuplicateException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
