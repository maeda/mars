package com.universe.milkway.solarsystem.earth.spaceship.readers;

import com.universe.milkway.solarsystem.earth.spaceship.Spaceship;
import com.universe.milkway.solarsystem.earth.spaceship.parsers.Parser;
import com.universe.milkway.solarsystem.exceptions.InputParserException;
import com.universe.milkway.solarsystem.mars.Geolocation;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Iterator;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class InputReader {

    private final Parser<Iterator<String>, Collection<Spaceship>> spaceshipParser;
    private final Parser<String, Geolocation> landSizeParser;

    public Input read(Path path) {
        try {
            Collection<String> lines = Files.readAllLines(path);
            Iterator<String> iterator = lines.stream().iterator();

            Geolocation landSize = landSizeParser.from(iterator.next());
            Collection<Spaceship> spaceships = spaceshipParser.from(iterator);
            return new Input(landSize, spaceships);
        } catch (IOException e) {
            throw new InputParserException(e);
        }
    }



}
