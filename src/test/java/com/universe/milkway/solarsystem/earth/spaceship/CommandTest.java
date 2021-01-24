package com.universe.milkway.solarsystem.earth.spaceship;

import com.universe.milkway.solarsystem.earth.spaceship.SpaceShip.Command;
import com.universe.milkway.solarsystem.mars.Geolocation;
import com.universe.milkway.solarsystem.mars.Orientation;
import com.universe.milkway.solarsystem.mars.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandTest {
    @Test
    public void shouldApplyMoveCommandToSpaceShip(){
        Position expected = new Position(new Geolocation(0, 1), Orientation.N);
        SpaceShip spaceShip = new SpaceShip(new Geolocation(0,0), new Geolocation(3, 3), Orientation.N);
        Position position = Command.M.execute(spaceShip);

        assertEquals(expected, position);
    }

    @Test
    public void shouldApplyTurnLeftCommandToSpaceShip(){
        Position expected = new Position(new Geolocation(0, 0), Orientation.W);
        SpaceShip spaceShip = new SpaceShip(new Geolocation(0,0), new Geolocation(3, 3), Orientation.N);
        Position position = Command.L.execute(spaceShip);

        assertEquals(expected, position);
    }
    @Test
    public void shouldApplyTurnRightCommandToSpaceShip(){
        Position expected = new Position(new Geolocation(0, 0), Orientation.E);
        SpaceShip spaceShip = new SpaceShip(new Geolocation(0,0), new Geolocation(3, 3), Orientation.N);
        Position position = Command.R.execute(spaceShip);

        assertEquals(expected, position);
    }
}
