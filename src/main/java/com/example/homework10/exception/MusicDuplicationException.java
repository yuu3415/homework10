package com.example.homework10.exception;

public class MusicDuplicationException extends RuntimeException {
    public MusicDuplicationException() {
        super();
    }

    public MusicDuplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public MusicDuplicationException(String message) {
        super(message);
    }

    public MusicDuplicationException(Throwable cause) {
        super(cause);
    }
}
