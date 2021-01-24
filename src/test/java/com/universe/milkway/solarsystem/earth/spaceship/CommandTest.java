package com.universe.milkway.solarsystem.earth.spaceship;

import com.universe.milkway.solarsystem.earth.spaceship.Spaceship.Command;
import com.universe.milkway.solarsystem.mars.Geolocation;
import com.universe.milkway.solarsystem.mars.Orientation;
import com.universe.milkway.solarsystem.mars.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandTest {
    @Test
    public void shouldApplyMoveCommandToSpaceship(){
        Position expected = new Position(new Geolocation(0, 1), Orientation.N);
        Spaceship spaceShip = Spaceship.builder().geolocation(new Geolocation(0,0)).orientation(Orientation.N).build();
        Position position = Command.M.execute(spaceShip);

        assertEquals(expected, position);
    }

    @Test
    public void shouldApplyTurnLeftCommandToSpaceship(){
        Position expected = new Position(new Geolocation(0, 0), Orientation.W);
        Spaceship spaceShip = Spaceship.builder().geolocation(new Geolocation(0,0)).orientation(Orientation.N).build();
        Position position = Command.L.execute(spaceShip);

        assertEquals(expected, position);
    }
    @Test
    public void shouldApplyTurnRightCommandToSpaceship(){
        Position expected = new Position(new Geolocation(0, 0), Orientation.E);
        Spaceship spaceShip = Spaceship.builder().geolocation(new Geolocation(0,0)).orientation(Orientation.N).build();
        Position position = Command.R.execute(spaceShip);

        assertEquals(expected, position);
    }
}
