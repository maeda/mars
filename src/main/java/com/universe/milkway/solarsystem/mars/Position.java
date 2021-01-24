package com.universe.milkway.solarsystem.mars;

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
}