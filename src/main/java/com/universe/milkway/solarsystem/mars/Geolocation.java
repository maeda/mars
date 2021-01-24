package com.universe.milkway.solarsystem.mars;

import com.universe.milkway.solarsystem.exceptions.GeolocationException;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@Builder
public class Geolocation {
    private final int x;
    private final int y;

    public Geolocation(final int x, final int y){
        if(isNegative(x))
            throw new GeolocationException("Negative x is not allowed");
        if(isNegative(y))
            throw new GeolocationException("Negative y is not allowed");
        this.x = x;
        this.y = y;
    }

    private boolean isNegative(int number) {
        return Integer.signum(number) == -1;
    }

}
