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

    public static Geolocation from(Geolocation geoLocation){
        return Geolocation.builder()
                .x(geoLocation.getX())
                .y(geoLocation.getY())
                .build();
    }
}
