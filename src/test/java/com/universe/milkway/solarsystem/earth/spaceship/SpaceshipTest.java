package com.universe.milkway.solarsystem.earth.spaceship;

import com.universe.milkway.solarsystem.exceptions.SpaceshipException;
import com.universe.milkway.solarsystem.mars.Position;
import com.universe.milkway.solarsystem.mars.Direction;
import com.universe.milkway.solarsystem.mars.Orientation;
import com.universe.milkway.solarsystem.mars.Geolocation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpaceshipTest {

    private Spaceship spaceShip;

    @Before
    public void setUp() {
        this.spaceShip = new Spaceship(new Geolocation(3, 3), new Geolocation(4, 4), Orientation.N);
    }

    @Test
    public void shouldSpaceshipReturnItsPosition(){
        Position position = this.spaceShip.position();
        Position expected = new Position(new Geolocation(3, 3), Orientation.N);
        assertEquals(expected, position);
    }

    @Test
    public void shouldTurnSpaceShipToRight(){
        Position expected = new Position(new Geolocation(3, 3), Orientation.E);
        Position current = this.spaceShip.turn(Direction.RIGHT);
        assertEquals(expected, current);
    }

    @Test
    public void shouldTurnSpaceshipToLeft(){
        Position expected = new Position(new Geolocation(3, 3), Orientation.W);
        Position current = this.spaceShip.turn(Direction.LEFT);
        assertEquals(expected, current);
    }

    @Test
    public void shouldTurnSpaceshipToLeftIn180Degrees(){
        Position expected = new Position(new Geolocation(3, 3), Orientation.S);
        this.spaceShip.turn(Direction.LEFT);
        Position current = this.spaceShip.turn(Direction.LEFT);
        assertEquals(expected, current);
    }

    @Test
    public void shouldTurnSpaceshipToRightIn180Degrees(){
        Position expected = new Position(new Geolocation(3, 3), Orientation.S);
        this.spaceShip.turn(Direction.RIGHT);
        Position current = this.spaceShip.turn(Direction.RIGHT);
        assertEquals(expected, current);
    }

    @Test
    public void shouldTurnSpaceshipToRightIn360Degrees(){
        Position expected = new Position(new Geolocation(3, 3), Orientation.N);
        this.spaceShip.turn(Direction.RIGHT);
        this.spaceShip.turn(Direction.RIGHT);
        this.spaceShip.turn(Direction.RIGHT);
        this.spaceShip.turn(Direction.RIGHT);

        Position current = this.spaceShip.position();
        assertEquals(expected, current);
    }

    @Test
    public void shouldSpaceshipMoveTowardsNorth() {
        Position expected = new Position(new Geolocation(3, 4), Orientation.N);
        Position current = this.spaceShip.move();

        assertEquals(expected, current);
    }

    @Test
    public void shouldSpaceshipMoveTowardsSouth() {
        Spaceship spaceShip = new Spaceship(new Geolocation(3, 3), new Geolocation(4, 4), Orientation.S);
        Position expected = new Position(new Geolocation(3, 2), Orientation.S);
        Position current = spaceShip.move();

        assertEquals(expected, current);
    }

    @Test
    public void shouldSpaceshipMoveTowardsEast() {
        Spaceship spaceShip = new Spaceship(new Geolocation(3, 3), new Geolocation(4, 4), Orientation.E);
        Position expected = new Position(new Geolocation(4, 3), Orientation.E);
        Position current = spaceShip.move();

        assertEquals(expected, current);
    }

    @Test
    public void shouldSpaceshipMoveTowardsWest() {
        Spaceship spaceShip = new Spaceship(new Geolocation(3, 3), new Geolocation(4, 4), Orientation.W);
        Position expected = new Position(new Geolocation(2, 3), Orientation.W);
        Position current = spaceShip.move();

        assertEquals(expected, current);
    }

    @Test(expected = SpaceshipException.class)
    public void shouldNotSpaceshipMoveTowardsNegativeSouth() {
        Spaceship spaceShip = new Spaceship(new Geolocation(0, 0), new Geolocation(4, 4), Orientation.S);
        spaceShip.move();
    }

    @Test(expected = SpaceshipException.class)
    public void shouldNotSpaceshipMoveTowardsNegativeWest() {
        Spaceship spaceShip = new Spaceship(new Geolocation(0, 0), new Geolocation(4, 4), Orientation.W);
        spaceShip.move();
    }

    @Test(expected = NullPointerException.class)
    public void shouldNotSpaceshipAcceptInvalidGeolocation() {
        Spaceship spaceShip = new Spaceship(null,null, Orientation.W);
        spaceShip.move();
    }

    @Test(expected = NullPointerException.class)
    public void shouldNotSpaceshipAcceptInvalidOrientation() {
        Spaceship spaceShip = new Spaceship(new Geolocation(0, 0), null, null);
        spaceShip.move();
    }

    @Test(expected = NullPointerException.class)
    public void shouldNotSetInvalidSpaceShipGeolocationLimit() {
        Spaceship spaceShip = new Spaceship(new Geolocation(0, 0), new Geolocation(Integer.MAX_VALUE, Integer.MAX_VALUE), Orientation.N);
        spaceShip.setGeolocationLimit(null);
    }

    @Test(expected = SpaceshipException.class)
    public void shouldNotMoveOutsideNorthGeolocationLimit() {
        Spaceship spaceShip = new Spaceship(new Geolocation(3, 3), new Geolocation(3, 3), Orientation.N);
        spaceShip.move();
    }

    @Test(expected = SpaceshipException.class)
    public void shouldNotMoveOutsideEastGeolocationLimit() {
        Spaceship spaceShip = new Spaceship(new Geolocation(3, 3), new Geolocation(3, 3), Orientation.E);
        spaceShip.move();
    }

    @Test(expected = SpaceshipException.class)
    public void shouldNotMoveOutsideWestGeolocationLimit() {
        Spaceship spaceShip = new Spaceship(new Geolocation(0, 3), new Geolocation(3, 3), Orientation.W);
        spaceShip.move();
    }

    @Test(expected = SpaceshipException.class)
    public void shouldNotMoveOutsideSouthGeolocationLimit() {
        Spaceship spaceShip = new Spaceship(new Geolocation(0, 0), new Geolocation(3, 3), Orientation.S);
        spaceShip.move();
    }

}
