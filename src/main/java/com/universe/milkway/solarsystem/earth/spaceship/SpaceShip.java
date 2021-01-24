package com.universe.milkway.solarsystem.earth.spaceship;

import com.universe.milkway.solarsystem.exceptions.SpaceShipException;
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
public class SpaceShip {
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
        Geolocation geolocation = this.orientation.move(this.geolocation);
        if(geolocation.isOutside(this.geolocationLimit))
            throw new SpaceShipException("Spaceship has tried to moved outside limits. Limit: " + this.geolocationLimit);
        this.geolocation = geolocation;
        return copy();
    }

    private Position copy() {
        return Position.builder()
                .geolocation(this.geolocation)
                .orientation(this.orientation)
                .build();
    }
}
