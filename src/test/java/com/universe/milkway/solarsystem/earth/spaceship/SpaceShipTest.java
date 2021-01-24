package com.universe.milkway.solarsystem.earth.spaceship;

import com.universe.milkway.solarsystem.exceptions.SpaceShipException;
import com.universe.milkway.solarsystem.mars.Position;
import com.universe.milkway.solarsystem.mars.Direction;
import com.universe.milkway.solarsystem.mars.Orientation;
import com.universe.milkway.solarsystem.mars.Geolocation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpaceShipTest {

    private SpaceShip spaceShip;

    @Before
    public void setUp() {
        this.spaceShip = new SpaceShip(new Geolocation(3, 3), new Geolocation(4, 4), Orientation.N);
    }

    @Test
    public void shouldSpaceShipReturnItsPosition(){
        Position position = this.spaceShip.position();
        Position expected = new Position(new Geolocation(3, 3), Orientation.N);
        assertEquals(expected, position);
    }

    @Test
    public void shouldTurnSpaceShipToRight(){
        Position expected = new Position(new Geolocation(3, 3), Orientation.E);
        Position current = this.spaceShip.turn(Direction.R);
        assertEquals(expected, current);
    }

    @Test
    public void shouldTurnSpaceShipToLeft(){
        Position expected = new Position(new Geolocation(3, 3), Orientation.W);
        Position current = this.spaceShip.turn(Direction.L);
        assertEquals(expected, current);
    }

    @Test
    public void shouldTurnSpaceShipToLeftIn180Degrees(){
        Position expected = new Position(new Geolocation(3, 3), Orientation.S);
        this.spaceShip.turn(Direction.L);
        Position current = this.spaceShip.turn(Direction.L);
        assertEquals(expected, current);
    }

    @Test
    public void shouldTurnSpaceShipToRightIn180Degrees(){
        Position expected = new Position(new Geolocation(3, 3), Orientation.S);
        this.spaceShip.turn(Direction.R);
        Position current = this.spaceShip.turn(Direction.R);
        assertEquals(expected, current);
    }

    @Test
    public void shouldTurnSpaceShipToRightIn360Degrees(){
        Position expected = new Position(new Geolocation(3, 3), Orientation.N);
        this.spaceShip.turn(Direction.R);
        this.spaceShip.turn(Direction.R);
        this.spaceShip.turn(Direction.R);
        this.spaceShip.turn(Direction.R);

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
        SpaceShip spaceShip = new SpaceShip(new Geolocation(3, 3), new Geolocation(4, 4), Orientation.S);
        Position expected = new Position(new Geolocation(3, 2), Orientation.S);
        Position current = spaceShip.move();

        assertEquals(expected, current);
    }

    @Test
    public void shouldSpaceshipMoveTowardsEast() {
        SpaceShip spaceShip = new SpaceShip(new Geolocation(3, 3), new Geolocation(4, 4), Orientation.E);
        Position expected = new Position(new Geolocation(4, 3), Orientation.E);
        Position current = spaceShip.move();

        assertEquals(expected, current);
    }

    @Test
    public void shouldSpaceshipMoveTowardsWest() {
        SpaceShip spaceShip = new SpaceShip(new Geolocation(3, 3), new Geolocation(4, 4), Orientation.W);
        Position expected = new Position(new Geolocation(2, 3), Orientation.W);
        Position current = spaceShip.move();

        assertEquals(expected, current);
    }

    @Test(expected = SpaceShipException.class)
    public void shouldNotSpaceshipMoveTowardsNegativeSouth() {
        SpaceShip spaceShip = new SpaceShip(new Geolocation(0, 0), new Geolocation(4, 4), Orientation.S);
        spaceShip.move();
    }

    @Test(expected = SpaceShipException.class)
    public void shouldNotSpaceshipMoveTowardsNegativeWest() {
        SpaceShip spaceShip = new SpaceShip(new Geolocation(0, 0), new Geolocation(4, 4), Orientation.W);
        spaceShip.move();
    }

    @Test(expected = NullPointerException.class)
    public void shouldNotSpaceshipAcceptInvalidGeolocation() {
        SpaceShip spaceShip = new SpaceShip(null,null, Orientation.W);
        spaceShip.move();
    }

    @Test(expected = NullPointerException.class)
    public void shouldNotSpaceshipAcceptInvalidOrientation() {
        SpaceShip spaceShip = new SpaceShip(new Geolocation(0, 0), null, null);
        spaceShip.move();
    }

    @Test(expected = NullPointerException.class)
    public void shouldNotSetInvalidSpaceShipGeolocationLimit() {
        SpaceShip spaceShip = new SpaceShip(new Geolocation(0, 0), new Geolocation(Integer.MAX_VALUE, Integer.MAX_VALUE), Orientation.N);
        spaceShip.setGeolocationLimit(null);
    }

    @Test(expected = SpaceShipException.class)
    public void shouldNotMoveOutsideNorthGeolocationLimit() {
        SpaceShip spaceShip = new SpaceShip(new Geolocation(3, 3), new Geolocation(3, 3), Orientation.N);
        spaceShip.move();
    }

    @Test(expected = SpaceShipException.class)
    public void shouldNotMoveOutsideEastGeolocationLimit() {
        SpaceShip spaceShip = new SpaceShip(new Geolocation(3, 3), new Geolocation(3, 3), Orientation.E);
        spaceShip.move();
    }

    @Test(expected = SpaceShipException.class)
    public void shouldNotMoveOutsideWestGeolocationLimit() {
        SpaceShip spaceShip = new SpaceShip(new Geolocation(0, 3), new Geolocation(3, 3), Orientation.W);
        spaceShip.move();
    }

    @Test(expected = SpaceShipException.class)
    public void shouldNotMoveOutsideSouthGeolocationLimit() {
        SpaceShip spaceShip = new SpaceShip(new Geolocation(0, 0), new Geolocation(3, 3), Orientation.S);
        spaceShip.move();
    }

}
