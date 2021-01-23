import com.universe.milkway.solarsystem.earth.spaceship.SpaceShip;
import com.universe.milkway.solarsystem.earth.spaceship.Position;
import com.universe.milkway.solarsystem.mars.Orientation;
import com.universe.milkway.solarsystem.mars.Geolocation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpaceShipTest {

    private SpaceShip spaceShip;

    @Before
    public void setUp() {
        this.spaceShip = new SpaceShip(new Position(new Geolocation(3, 3), Orientation.N));
    }

    @Test
    public void shouldSpaceShipReturnItsPosition(){
        Position position = this.spaceShip.position();
        Position expected = new Position(new Geolocation(3, 3), Orientation.N);
        assertEquals(expected, position);
    }

}
