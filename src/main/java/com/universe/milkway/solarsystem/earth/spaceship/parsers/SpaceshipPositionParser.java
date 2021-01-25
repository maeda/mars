package com.universe.milkway.solarsystem.earth.spaceship.parsers;

import com.universe.milkway.solarsystem.exceptions.ParserSpaceshipPositionException;
import com.universe.milkway.solarsystem.mars.Geolocation;
import com.universe.milkway.solarsystem.mars.Orientation;
import com.universe.milkway.solarsystem.mars.Position;

public class SpaceshipPositionParser implements Parser<String, Position> {

    public static final String SPACESHIP_POSITION = "[0-9] [0-9] [A-Z]";

    public Position from(String line) {
        if(!line.matches(SPACESHIP_POSITION))
            throw new ParserSpaceshipPositionException(String.format("Spaceship position is invalid. Expected format: %s Received: %s", SPACESHIP_POSITION, line));
        String[] lineParsed = line.trim().split(" ");
        return new Position(new Geolocation(Integer.parseInt(lineParsed[0]), Integer.parseInt(lineParsed[1])), Orientation.valueOf(lineParsed[2]));
    }
}
