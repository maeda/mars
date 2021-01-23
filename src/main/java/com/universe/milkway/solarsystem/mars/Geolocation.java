package com.universe.milkway.solarsystem.mars;

import lombok.*;

@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Builder
public class Geolocation {
    private final int x;
    private final int y;
}
