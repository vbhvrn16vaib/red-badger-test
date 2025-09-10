package org.redbadger.app;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.redbadger.app.ORIENTATION.*;
import static org.redbadger.app.RobotExecutor.executeInstructions;

class RobotExecutorTest {
    @Test
    void testExecuteInstructions() {
        Robot robot = new Robot(1, 1, E);
        Robot robot2 = new Robot(0, 3, W);

        HashSet<String> scent = new HashSet<>();

        executeInstructions(robot, "RFRFRFRF", 5, 3, scent);
        executeInstructions(robot2, "LLFFFLFLFL", 5, 3, scent);

        assertEquals("1 1 E", robot.getStatus());
        assertEquals("3 3 N LOST", robot2.getStatus());
    }

    @Test
    void testExecuteInstructions2() {
        HashSet<String> scent = new HashSet<>();

        Robot robot = new Robot(1, 1, E);
        Robot robot2 = new Robot(3, 2, N);
        Robot robot3 = new Robot(0, 3, W);

        executeInstructions(robot, "RFRFRFRF", 5, 3, scent);
        executeInstructions(robot2, "FRRFLLFFRRFLL", 5, 3, scent);
        executeInstructions(robot3, "LLFFFLFLFL", 5, 3, scent);

        assertEquals("1 1 E", robot.getStatus());
        assertEquals("3 3 N LOST", robot2.getStatus());
        assertEquals("2 3 S", robot3.getStatus());
    }

}