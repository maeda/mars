package com.universe.milkway.solarsystem.mars;

import com.universe.milkway.solarsystem.exceptions.AreaException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AreaTest {
    @Test
    public void shouldCreateAnAreaWithMaxSize(){
        Area area = new Area(new Geolocation(0, 0), new Geolocation(5, 5));
        Geolocation expected = new Geolocation(5, 5);

        assertEquals(expected, area.getEnd());
    }

    @Test(expected = AreaException.class)
    public void shouldFailIfAddInvalidSpaceship(){
        Area area = new Area(new Geolocation(0, 0), new Geolocation(5, 5));

        area.add(null);
    }

}
