package org.redbadger.app;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {
    @Test
    void testMoveForward() {
        Robot robot = new Robot(1, 0, ORIENTATION.N);
        robot.moveForward(5, 5, new HashSet<>());
        assertEquals(1, robot.getX());
        assertEquals(1, robot.getY());
    }

    @Test
    void testTurnLeft() {
        Robot robot = new Robot(1, 0, ORIENTATION.N);
        robot.turnLeft();
        assertEquals(ORIENTATION.W, robot.getOrientation());
        assertEquals("1 0 W", robot.getStatus());
    }

    @Test
    void testTurnRight() {
        Robot robot = new Robot(1, 0, ORIENTATION.N);
        robot.turnRight();
        assertEquals(ORIENTATION.E, robot.getOrientation());
    }

    @Test
    void testMoveForwardLost() {
        Robot robot = new Robot(0, 5, ORIENTATION.N);
        robot.moveForward(5, 5, new HashSet<>());
        assertTrue(robot.isLost());
        assertEquals("0 5 N LOST", robot.getStatus());
    }

    @Test
    void shouldNotMoveIfInScent(){
        Robot robot = new Robot(0, 5, ORIENTATION.N);
        Set<String> scent = new HashSet<>();
        scent.add("0,5");
        robot.moveForward(5, 5, scent);
        assertFalse(robot.isLost());
    }
}