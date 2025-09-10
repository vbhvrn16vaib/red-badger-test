package org.redbadger.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ORIENTATIONTest {
    @ParameterizedTest
    @MethodSource("turnLeftMethodSource")
    void testTurnLeft(ORIENTATION input, ORIENTATION expected) {
        ORIENTATION orientation = input;
        orientation = orientation.turnLeft();
        assertEquals(expected, orientation);
    }

    @ParameterizedTest
    @MethodSource("turnRightMethodSource")
    void testTurnRight(ORIENTATION input, ORIENTATION expected) {
        ORIENTATION orientation = input;
        orientation = orientation.turnRight();
        assertEquals(expected, orientation);
    }

    @Test
    void testMoveForward() {
        ORIENTATION orientation = ORIENTATION.N;
        orientation = orientation.turnRight();
        assertEquals(ORIENTATION.E, orientation);
    }

    static Stream<Arguments> turnRightMethodSource() {
        return Stream.of(
                Arguments.of(ORIENTATION.N, ORIENTATION.E),
                Arguments.of(ORIENTATION.E, ORIENTATION.S),
                Arguments.of(ORIENTATION.S, ORIENTATION.W),
                Arguments.of(ORIENTATION.W, ORIENTATION.N)
        );
    }

    static Stream<Arguments> turnLeftMethodSource() {
        return Stream.of(
                Arguments.of(ORIENTATION.N, ORIENTATION.W),
                Arguments.of(ORIENTATION.E, ORIENTATION.N),
                Arguments.of(ORIENTATION.S, ORIENTATION.E),
                Arguments.of(ORIENTATION.W, ORIENTATION.S)
        );
    }
}