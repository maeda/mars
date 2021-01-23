package com.universe.milkway.solarsystem.earth.spaceship;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class SpaceShip {
    private Position position;
    public Position position() {
        return Position.from(position);
    }
}
