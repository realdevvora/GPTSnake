package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppleTest {
    private Apple apple;

    /**
     * setting up each test
     */
    @BeforeEach
    public void setUp() {
        apple = new Apple();
    }

    /**
     * ensure that the apple only places within the screen
     */
    @Test
    public void testApplePosition() {
        int x = apple.getX();
        int y = apple.getY();

        assertTrue(x >= 0 && x < Constants.WIDTH);
        assertTrue(y >= 0 && y < Constants.HEIGHT);
    }

    /**
     * test that the apple randomizes to a different position, not the same one
     */
    @Test
    public void testRandomizePosition() {
        int initialX = apple.getX();
        int initialY = apple.getY();

        apple.randomizePosition();

        int newX = apple.getX();
        int newY = apple.getY();

        assertTrue(initialX != newX || initialY != newY);
    }

}
