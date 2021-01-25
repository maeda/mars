package com.universe.milkway.solarsystem.earth.spaceship.parsers;

import com.universe.milkway.solarsystem.exceptions.ParserLandSizeException;
import com.universe.milkway.solarsystem.mars.Geolocation;

public class LandSizeParser implements Parser<String, Geolocation>{

    public static final String LAND_SIZE = "[0-9] [0-9]";

    public Geolocation from(String landSize) {
        if(!landSize.matches(LAND_SIZE))
            throw new ParserLandSizeException(String.format("Land line is invalid. Expected format: %s Received: %s", LAND_SIZE, landSize));

        String[] lanSizeSplit = landSize.trim().split(" ");
        return new Geolocation(Integer.parseInt(lanSizeSplit[0]), Integer.parseInt(lanSizeSplit[1]));
    }
}
