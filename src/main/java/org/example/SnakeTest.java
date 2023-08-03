package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnakeTest {
    private Snake snake;

    /**
     * set up before each test
     */
    @BeforeEach
    public void setUp() {
        snake = new Snake();
    }

    /**
     * test that the snake length is 3 when the game starts
     */
    @Test
    public void testInitialSnakeLength() {
        assertEquals(3, snake.getDots());
    }

    /**
     * test that the snake's position is accurate (center of the screen)
     */
    @Test
    public void testInitialSnakePosition() {
        int[] expectedX = {50, 40, 30};
        int[] expectedY = {50, 50, 50};
        int[] actualX = {snake.getX()[0], snake.getX()[1], snake.getX()[2]};
        int[] actualY = {snake.getY()[0], snake.getY()[1], snake.getY()[2]};

        // lengths of lists are equal
        assertEquals(expectedX.length, actualX.length);
        assertEquals(expectedY.length, actualY.length);

        // checking that positions are equal
        for (int i = 0; i < expectedX.length; i++) {
            assertEquals(expectedX[i], actualX[i]);
            assertEquals(expectedY[i], actualY[i]);
        }
    }
}