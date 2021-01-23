import com.universe.milkway.solarsystem.earth.spaceship.SpaceShip;
import com.universe.milkway.solarsystem.earth.spaceship.Position;
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
        this.spaceShip = new SpaceShip(new Geolocation(3, 3), Orientation.N);
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

}
