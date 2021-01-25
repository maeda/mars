package com.universe.milkway.solarsystem.earth.spaceship.parsers;

import com.universe.milkway.solarsystem.exceptions.ParserSpaceshipPositionException;
import com.universe.milkway.solarsystem.mars.Position;
import org.junit.Test;

public class SpaceshipPositionParserTest {
    @Test(expected = ParserSpaceshipPositionException.class)
    public void shouldValidateSpaceshipPositionLine(){
        Parser<String, Position> parser = new SpaceshipPositionParser();
        parser.from("12N");
    }
}
