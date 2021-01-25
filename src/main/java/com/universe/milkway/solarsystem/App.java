package com.universe.milkway.solarsystem;

import com.universe.milkway.solarsystem.earth.spaceship.Spaceship;
import com.universe.milkway.solarsystem.earth.spaceship.parsers.LandSizeParser;
import com.universe.milkway.solarsystem.earth.spaceship.parsers.Parser;
import com.universe.milkway.solarsystem.earth.spaceship.parsers.SpaceshipCommandParser;
import com.universe.milkway.solarsystem.earth.spaceship.parsers.SpaceshipParser;
import com.universe.milkway.solarsystem.earth.spaceship.parsers.SpaceshipPositionParser;
import com.universe.milkway.solarsystem.earth.spaceship.readers.Input;
import com.universe.milkway.solarsystem.earth.spaceship.readers.InputReader;
import com.universe.milkway.solarsystem.mars.Area;
import com.universe.milkway.solarsystem.mars.Geolocation;
import com.universe.milkway.solarsystem.mars.Position;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        final Parser<Iterator<String>, Collection<Spaceship>> spaceshipParser = new SpaceshipParser(new SpaceshipPositionParser(), new SpaceshipCommandParser());

        final InputReader parser = new InputReader(spaceshipParser, new LandSizeParser());

        final Path path = Paths.get(args[0]);

        Input input = parser.read(path);

        Area area = new Area(new Geolocation(0,0), input.getGeolocationMax());

        input.getSpaceShips().forEach(spaceship -> {
            spaceship.setGeolocationLimit(input.getGeolocationMax());
            Position position = spaceship.run(area);
            System.out.println(position);
        });
    }
}
