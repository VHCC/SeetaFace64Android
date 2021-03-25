package com.seetatech.seetaverify.mvp.exceptions;

public class CameraUnavailableException extends RuntimeException {
    public CameraUnavailableException() {
    }

    public CameraUnavailableException(String message) {
        super(message);
    }

    public CameraUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public CameraUnavailableException(Throwable cause) {
        super(cause);
    }

    public CameraUnavailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
