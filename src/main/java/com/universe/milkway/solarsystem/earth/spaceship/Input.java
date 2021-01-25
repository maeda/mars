package com.universe.milkway.solarsystem.earth.spaceship;


import com.universe.milkway.solarsystem.mars.Geolocation;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Collection;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
public class Input {
    private final Geolocation geolocationMax;
    private final Collection<Spaceship> spaceShips;
}
