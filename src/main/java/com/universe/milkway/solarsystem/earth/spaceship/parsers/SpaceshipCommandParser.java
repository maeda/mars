package com.universe.milkway.solarsystem.earth.spaceship.parsers;

import com.universe.milkway.solarsystem.earth.spaceship.Spaceship;
import com.universe.milkway.solarsystem.exceptions.ParserSpaceshipCommandsException;

import java.util.Collection;
import java.util.stream.Collectors;

public class SpaceshipCommandParser implements Parser<String, Collection<Spaceship.Command>> {

    public static final String SPACESHIP_COMMANDS = "[MLR]+";

    public Collection<Spaceship.Command> from(String line){
        if(!line.matches(SPACESHIP_COMMANDS))
            throw new ParserSpaceshipCommandsException(String.format("Spaceship commands is invalid. Expected format: %s Received: %s", SPACESHIP_COMMANDS, line));
        return line.codePoints()
                .mapToObj(c -> String.valueOf((char) c))
                .map(Spaceship.Command::valueOf)
                .collect(Collectors.toList());
    }
}
