import com.universe.milkway.solarsystem.earth.spaceship.SpaceShip;
import com.universe.milkway.solarsystem.earth.spaceship.Position;
import com.universe.milkway.solarsystem.mars.Direction;
import com.universe.milkway.solarsystem.mars.Geolocation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpaceShipTest {

    @Test
    public void shouldSpaceShipReturnItsPosition(){
        SpaceShip spaceShip = new SpaceShip(new Position(new Geolocation(3, 3), Direction.N));
        Position position = spaceShip.position();
        Position expected = new Position(new Geolocation(3, 3), Direction.N);
        assertEquals(expected, position);
    }

}
