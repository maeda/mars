package com.universe.milkway.solarsystem.mars;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Builder
public class Position {
    private final Geolocation geolocation;
    private final Orientation orientation;
}
