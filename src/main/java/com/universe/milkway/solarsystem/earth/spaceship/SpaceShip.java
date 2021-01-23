package com.universe.milkway.solarsystem.earth.spaceship;

import com.universe.milkway.solarsystem.mars.Direction;
import com.universe.milkway.solarsystem.mars.Geolocation;
import com.universe.milkway.solarsystem.mars.Orientation;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SpaceShip {
    private Geolocation geolocation;
    private Orientation orientation;

    public Position position() {
        return Position.builder()
                .orientation(this.orientation)
                .geolocation(this.geolocation)
                .build();
    }

    public Position turn(Direction direction) {
        this.orientation = this.orientation.change(direction);
        return Position.builder()
                .geolocation(this.geolocation)
                .orientation(this.orientation)
                .build();
    }

}
