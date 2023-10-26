package com.example.homework10.Exception;

public class NotMusicFoundException extends RuntimeException {
    public NotMusicFoundException() {
        super();
    }

    public NotMusicFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotMusicFoundException(String message) {
        super(message);
    }

    public NotMusicFoundException(Throwable cause) {
        super(cause);
    }
}
