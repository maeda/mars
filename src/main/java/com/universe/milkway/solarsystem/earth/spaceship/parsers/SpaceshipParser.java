package com.universe.milkway.solarsystem.earth.spaceship.parsers;

import com.universe.milkway.solarsystem.earth.spaceship.Spaceship;
import com.universe.milkway.solarsystem.mars.Position;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class SpaceshipParser implements Parser<Iterator<String>, Collection<Spaceship>> {
    private final Parser<String, Position> spaceshipPositionParser;
    private final Parser<String, Collection<Spaceship.Command>> commandParser;

    public Collection<Spaceship> from(Iterator<String> iterator){
        final Collection<Spaceship> spaceships = new LinkedList<>();

        while(iterator.hasNext()) {
            final Position position = spaceshipPositionParser.from(iterator.next());
            final Spaceship spaceship = Spaceship.builder()
                    .geolocation(position.getGeolocation())
                    .orientation(position.getOrientation())
                    .commands(commandParser.from(iterator.next()))
                    .build();
            spaceships.add(spaceship);
        }

        return spaceships;
    }
}
