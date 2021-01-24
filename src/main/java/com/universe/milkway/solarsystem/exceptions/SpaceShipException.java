package com.universe.milkway.solarsystem.exceptions;

public class SpaceShipException extends RuntimeException {
    public SpaceShipException(String message) {
        super(message);
    }
    public SpaceShipException(String message, Throwable exception) {
        super(message, exception);
    }
}
