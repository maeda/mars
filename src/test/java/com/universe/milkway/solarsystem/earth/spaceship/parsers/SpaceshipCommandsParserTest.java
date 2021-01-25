package com.universe.milkway.solarsystem.earth.spaceship.parsers;

import com.universe.milkway.solarsystem.earth.spaceship.Spaceship;
import com.universe.milkway.solarsystem.exceptions.ParserSpaceshipCommandsException;
import org.junit.Test;

import java.util.Collection;

public class SpaceshipCommandsParserTest {
    @Test(expected = ParserSpaceshipCommandsException.class)
    public void shouldValidateSpaceshipCommandsLine(){
        Parser<String, Collection<Spaceship.Command>> parser = new SpaceshipCommandParser();
        parser.from("MLR B");
    }
}
