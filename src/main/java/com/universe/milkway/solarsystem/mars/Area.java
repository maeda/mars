package com.universe.milkway.solarsystem.mars;

import com.universe.milkway.solarsystem.earth.spaceship.Spaceship;
import com.universe.milkway.solarsystem.exceptions.AreaException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Builder
public class Area {
    @NonNull
    private final Geolocation start;
    @NonNull
    private final Geolocation end;

    private Spaceship spaceShip;

    public Geolocation getEnd(){
        return Geolocation.builder()
                .x(this.end.getX())
                .y(this.end.getY())
                .build();
    }
}
