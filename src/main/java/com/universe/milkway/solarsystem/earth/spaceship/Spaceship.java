package com.universe.milkway.solarsystem.earth.spaceship;

import com.universe.milkway.solarsystem.exceptions.GeolocationNegativeException;
import com.universe.milkway.solarsystem.exceptions.SpaceshipException;
import com.universe.milkway.solarsystem.mars.Direction;
import com.universe.milkway.solarsystem.mars.Geolocation;
import com.universe.milkway.solarsystem.mars.Orientation;
import com.universe.milkway.solarsystem.mars.Position;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Spaceship {
    @NonNull
    private Geolocation geolocation;
    @NonNull
    @Setter
    private Geolocation geolocationLimit;
    @NonNull
    private Orientation orientation;

    public Position position() {
        return Position.builder()
                .orientation(this.orientation)
                .geolocation(this.geolocation)
                .build();
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
                .geolocation(this.geolocation)
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
