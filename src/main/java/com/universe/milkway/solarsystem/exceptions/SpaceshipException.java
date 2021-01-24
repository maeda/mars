package com.universe.milkway.solarsystem.exceptions;

public class SpaceshipException extends RuntimeException {
    public SpaceshipException(String message) {
        super(message);
    }
    public SpaceshipException(String message, Throwable exception) {
        super(message, exception);
    }
}
