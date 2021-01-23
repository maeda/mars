package com.universe.milkway.solarsystem.earth.spaceship;

import com.universe.milkway.solarsystem.mars.Direction;
import com.universe.milkway.solarsystem.mars.Geolocation;
import lombok.*;

@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Builder
public class Position {
    private final Geolocation geolocation;
    private final Direction direction;

    public static Position from(Position position) {
        return Position.builder()
                .geolocation(Geolocation.from(position.geolocation))
                .direction(position.direction)
                .build();
    }
}
