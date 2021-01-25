package com.universe.milkway.solarsystem.earth.spaceship.parsers;

public interface Parser<I, O> {
    O from(I input);
}
