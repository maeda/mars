package com.universe.milkway.solarsystem.mars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrientationTest {
    @Test
    public void shouldPointToWestWhenReceiveLeftCommand() {
        Orientation initial = Orientation.N;
        Orientation current = initial.change(Direction.LEFT);
        Orientation expected = Orientation.W;

        assertEquals(current, expected);
    }

    @Test
    public void shouldPointToSouthgWhenReceive2LeftCommands() {
        Orientation initial = Orientation.N;
        Orientation current = initial.change(Direction.LEFT);
        current = current.change(Direction.LEFT);

        Orientation expected = Orientation.S;

        assertEquals(current, expected);
    }
}
