package com.universe.milkway.solarsystem.earth.spaceship.readers;

import com.universe.milkway.solarsystem.earth.spaceship.Spaceship;
import com.universe.milkway.solarsystem.earth.spaceship.parsers.LandSizeParser;
import com.universe.milkway.solarsystem.earth.spaceship.parsers.Parser;
import com.universe.milkway.solarsystem.earth.spaceship.parsers.SpaceshipCommandParser;
import com.universe.milkway.solarsystem.earth.spaceship.parsers.SpaceshipParser;
import com.universe.milkway.solarsystem.earth.spaceship.parsers.SpaceshipPositionParser;
import com.universe.milkway.solarsystem.earth.spaceship.readers.Input;
import com.universe.milkway.solarsystem.earth.spaceship.readers.InputReader;
import com.universe.milkway.solarsystem.mars.Geolocation;
import com.universe.milkway.solarsystem.mars.Orientation;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class InputReaderTest {
    @Test
    public void shouldReadInputFile() throws URISyntaxException {
        final Parser<Iterator<String>, Collection<Spaceship>> spaceshipParser = new SpaceshipParser(new SpaceshipPositionParser(), new SpaceshipCommandParser());

        final InputReader parser = new InputReader(spaceshipParser, new LandSizeParser());
        final Path path = Paths.get(this.getClass().getClassLoader().getResource("input.txt").toURI());

        Input input = parser.read(path);
        Input expected = new Input(new Geolocation(5, 5), Arrays.asList(
                Spaceship.builder()
                        .geolocation(new Geolocation(1, 2))
                        .orientation( Orientation.N)
                        .commands(Arrays.asList(
                                Spaceship.Command.L,
                                Spaceship.Command.M,
                                Spaceship.Command.L,
                                Spaceship.Command.M,
                                Spaceship.Command.L,
                                Spaceship.Command.M,
                                Spaceship.Command.L,
                                Spaceship.Command.M,
                                Spaceship.Command.M))
                        .build(),
                Spaceship.builder()
                        .geolocation(new Geolocation(3, 3))
                        .orientation( Orientation.E)
                        .commands(Arrays.asList(
                                Spaceship.Command.M,
                                Spaceship.Command.M,
                                Spaceship.Command.R,
                                Spaceship.Command.M,
                                Spaceship.Command.M,
                                Spaceship.Command.R,
                                Spaceship.Command.M,
                                Spaceship.Command.R,
                                Spaceship.Command.R,
                                Spaceship.Command.M))
                        .build()
        ));

        assertEquals(expected, input);
    }

}
