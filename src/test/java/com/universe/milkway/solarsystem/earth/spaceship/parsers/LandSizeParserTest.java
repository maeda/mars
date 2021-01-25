package com.universe.milkway.solarsystem.earth.spaceship.parsers;

import com.universe.milkway.solarsystem.exceptions.ParserLandSizeException;
import com.universe.milkway.solarsystem.mars.Geolocation;
import org.junit.Test;

public class LandSizeParserTest {
    @Test(expected = ParserLandSizeException.class)
    public void shouldValidateLandSizeLine(){
        Parser<String, Geolocation> parser = new LandSizeParser();
        parser.from("5a");
    }
}
