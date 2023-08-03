package org.example;

import java.awt.*;

public class Snake {
    private int[] x;
    private int[] y;
    private int dots;
    private Direction direction;

    /**
     * initializing the snake's position, size, and direction
     */
    public Snake() {
        x = new int[Constants.ALL_DOTS];
        y = new int[Constants.ALL_DOTS];
        dots = 3; // Initial size of the snake
        direction = Direction.RIGHT;

        // Initialize the snake's body parts
        for (int i = 0; i < dots; i++) {
            x[i] = 50 - i * Constants.DOT_SIZE;
            y[i] = 50;
        }
    }

    /**
     * Returning the x positions of this object
     * @return int x
     */
    public int[] getX() {
        return x;
    }

    /**
     * Returning the y positions of this object
     * @return int y
     */
    public int[] getY() {
        return y;
    }

    /**
     * Returning the size of the snake
     * @return int dots (size measurement)
     */
    public int getDots() {
        return dots;
    }

    /**
     * returning the direction of the snake
     * @return Direction object (LEFT, RIGHT, UP, DOWN)
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * setting the direction of the snake
     * @param direction Direction object
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * increasing the size of the snake
     */
    public void grow() {
        dots ++;
    }
}
