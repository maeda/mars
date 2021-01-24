package com.universe.milkway.solarsystem.earth.spaceship;

import com.universe.milkway.solarsystem.exceptions.AreaException;
import com.universe.milkway.solarsystem.exceptions.GeolocationNegativeException;
import com.universe.milkway.solarsystem.exceptions.SpaceshipException;
import com.universe.milkway.solarsystem.mars.Area;
import com.universe.milkway.solarsystem.mars.Direction;
import com.universe.milkway.solarsystem.mars.Geolocation;
import com.universe.milkway.solarsystem.mars.Orientation;
import com.universe.milkway.solarsystem.mars.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;
import java.util.LinkedList;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Spaceship {
    @NonNull
    private Geolocation geolocation;
    @Builder.Default
    @Setter
    private Geolocation geolocationLimit = new Geolocation(Integer.MAX_VALUE, Integer.MAX_VALUE);
    @NonNull
    private Orientation orientation;
    @NonNull
    @Builder.Default
    private final Collection<Command> commands = new LinkedList<>();

    public Position position() {
        return copy();
    }

    public Position run(Area area){
        if(area == null)
            throw new AreaException("Area should not be null");

        this.setGeolocationLimit(area.getEnd());

        return this.commands.stream()
                .map(command -> command.execute(this))
                .reduce((first, second) -> second)
                .orElse(this.position());
    }

    public Position turn(Direction direction) {
        this.orientation = this.orientation.change(direction);
        return copy();
    }

    public Position move() {
        try {
            Geolocation geolocation = this.orientation.move(this.geolocation);
            if(geolocation.isOutside(this.geolocationLimit))
                throw new SpaceshipException("Spaceship has tried to moved outside limits. Limit: " + this.geolocationLimit);
            this.geolocation = geolocation;
            return copy();
        } catch (GeolocationNegativeException e){
            throw new SpaceshipException("Spaceship has tried to moved to negative limits.", e);
        }

    }

    private Position copy() {
        return Position.builder()
                .geolocation(Geolocation.from(this.geolocation))
                .orientation(this.orientation)
                .build();
    }

    public enum Command {
        L{
            @Override
            public Position execute(Spaceship spaceShip) {
                return spaceShip.turn(Direction.LEFT);
            }
        },
        R{
            @Override
            public Position execute(Spaceship spaceShip) {
                return spaceShip.turn(Direction.RIGHT);
            }
        },
        M{
            @Override
            public Position execute(Spaceship spaceShip) {
                return spaceShip.move();
            }
        };

        public abstract Position execute(Spaceship spaceShip);
    }
}
