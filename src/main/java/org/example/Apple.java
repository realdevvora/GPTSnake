package org.example;

import java.awt.*;
import java.util.Random;

public class Apple {

    private Random random = new Random();
    private int x;
    private int y;

    /**
     * Return the x position of this apple
     *
     * @return int current x position
     */
    public int getX() {
        return x;
    }

    /**
     * Set the x position of this apple
     *
     * @param x the new x position
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Return the y position of this apple
     *
     * @return int the new y position
     */
    public int getY() {
        return y;
    }

    /**
     * Set the y position of this apple
     * @param y the new y position
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Randomize the position of this apple to somewhere else on the screen. This will typically only run when
     * the snake collides with this object
     */
    public void randomizePosition() {

        // setting random x and y coordinates for the apple
        int appleX = random.nextInt(Constants.WIDTH / Constants.DOT_SIZE) * Constants.DOT_SIZE;
        int appleY = random.nextInt(Constants.HEIGHT / Constants.DOT_SIZE) * Constants.DOT_SIZE;

        setX(appleX);
        setY(appleY);
    }

    /**
     * Choose a random color
     *
     * @return Color object for the new background
     */
    public Color getRandomColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}
