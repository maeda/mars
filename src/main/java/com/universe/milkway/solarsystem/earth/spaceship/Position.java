package com.universe.milkway.solarsystem.earth.spaceship;

import com.universe.milkway.solarsystem.mars.Orientation;
import com.universe.milkway.solarsystem.mars.Geolocation;
import lombok.*;

@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Builder
public class Position {
    private final Geolocation geolocation;
    private final Orientation orientation;

    public static Position from(Position position) {
        return Position.builder()
                .geolocation(Geolocation.from(position.geolocation))
                .orientation(position.orientation)
                .build();
    }
}
