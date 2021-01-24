package com.universe.milkway.solarsystem.earth.spaceship;

import com.universe.milkway.solarsystem.exceptions.SpaceshipException;
import com.universe.milkway.solarsystem.mars.Area;
import com.universe.milkway.solarsystem.mars.Position;
import com.universe.milkway.solarsystem.mars.Direction;
import com.universe.milkway.solarsystem.mars.Orientation;
import com.universe.milkway.solarsystem.mars.Geolocation;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class SpaceshipTest {

    private Spaceship spaceShip;

    @Before
    public void setUp() {
        this.spaceShip = Spaceship.builder().geolocation(new Geolocation(3, 3)).orientation(Orientation.N).build();
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
        Spaceship spaceShip = Spaceship.builder().geolocation(new Geolocation(3, 3)).orientation(Orientation.S).build();
        Position expected = new Position(new Geolocation(3, 2), Orientation.S);
        Position current = spaceShip.move();

        assertEquals(expected, current);
    }

    @Test
    public void shouldSpaceshipMoveTowardsEast() {
        Spaceship spaceShip = Spaceship.builder().geolocation(new Geolocation(3, 3)).orientation(Orientation.E).build();
        Position expected = new Position(new Geolocation(4, 3), Orientation.E);
        Position current = spaceShip.move();

        assertEquals(expected, current);
    }

    @Test
    public void shouldSpaceshipMoveTowardsWest() {
        Spaceship spaceShip = Spaceship.builder().geolocation(new Geolocation(3, 3)).orientation(Orientation.W).build();
        Position expected = new Position(new Geolocation(2, 3), Orientation.W);
        Position current = spaceShip.move();

        assertEquals(expected, current);
    }

    @Test(expected = SpaceshipException.class)
    public void shouldNotSpaceshipMoveTowardsNegativeSouth() {
        Spaceship spaceShip = Spaceship.builder().geolocation(new Geolocation(0, 0)).orientation(Orientation.S).build();
        spaceShip.move();
    }

    @Test(expected = SpaceshipException.class)
    public void shouldNotSpaceshipMoveTowardsNegativeWest() {
        Spaceship spaceShip = Spaceship.builder().geolocation(new Geolocation(0, 0)).orientation(Orientation.W).build();
        spaceShip.move();
    }

    @Test(expected = NullPointerException.class)
    public void shouldNotSpaceshipAcceptInvalidGeolocation() {
        Spaceship spaceShip = Spaceship.builder().orientation(Orientation.W).build();
        spaceShip.move();
    }

    @Test(expected = NullPointerException.class)
    public void shouldNotSpaceshipAcceptInvalidOrientation() {
        Spaceship spaceShip = Spaceship.builder().geolocation(new Geolocation(0, 0)).build();
        spaceShip.move();
    }

    @Test(expected = SpaceshipException.class)
    public void shouldNotMoveOutsideNorthGeolocationLimit() {
        Spaceship spaceShip = Spaceship.builder()
                .geolocation(new Geolocation(3, 3))
                .geolocationLimit(new Geolocation(3, 3))
                .orientation(Orientation.N).build();
        spaceShip.move();
    }

    @Test(expected = SpaceshipException.class)
    public void shouldNotMoveOutsideEastGeolocationLimit() {
        Spaceship spaceShip = Spaceship.builder()
                .geolocation(new Geolocation(3, 3))
                .geolocationLimit(new Geolocation(3, 3))
                .orientation(Orientation.E).build();
        spaceShip.move();
    }

    @Test(expected = SpaceshipException.class)
    public void shouldNotMoveOutsideWestGeolocationLimit() {
        Spaceship spaceShip = Spaceship.builder()
                .geolocation(new Geolocation(0, 3))
                .geolocationLimit(new Geolocation(3, 3))
                .orientation(Orientation.W).build();
        spaceShip.move();
    }

    @Test(expected = SpaceshipException.class)
    public void shouldNotMoveOutsideSouthGeolocationLimit() {
        Spaceship spaceShip = Spaceship.builder()
                .geolocation(new Geolocation(0, 0))
                .geolocationLimit(new Geolocation(3, 3))
                .orientation(Orientation.S).build();
        spaceShip.move();
    }

    @Test
    public void shouldExecuteExploration(){
        Collection<Spaceship.Command> commands = Arrays.asList(
                Spaceship.Command.L,
                Spaceship.Command.M,
                Spaceship.Command.L,
                Spaceship.Command.M,
                Spaceship.Command.L,
                Spaceship.Command.M,
                Spaceship.Command.L,
                Spaceship.Command.M,
                Spaceship.Command.M
        );
        Area area = new Area(new Geolocation(0,0), new Geolocation(5, 5));
        Spaceship spaceship = Spaceship.builder()
                .geolocation(new Geolocation(1, 2))
                .orientation(Orientation.N)
                .commands(commands)
                .build();

        area.land(spaceship);

        Position position = spaceship.run();

        Position expected = new Position(new Geolocation(1, 3), Orientation.N);

        assertEquals(expected, position);

    }

}
