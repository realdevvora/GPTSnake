package org.example;
public class Collision {
    private Snake snake;
    private int width;
    private int height;

    /**
     * @param snake snake object
     * @param width width of the screen
     * @param height height of the screen
     */
    public Collision(Snake snake, int width, int height) {
        this.snake = snake;
        this.width = width;
        this.height = height;
    }

    /**
     * Checking whether the snake collides with the apple, if so, growing the snake, randomizing position, and returning
     * true for other events to take place
     *
     * @param apple apple object passed in
     * @return boolean on whether it happens or not
     */
    public boolean checkCollisionsWithApple(Apple apple) {
        int appleX = apple.getX();
        int appleY = apple.getY();
        int[] snakeX = snake.getX();
        int[] snakeY = snake.getY();

        if (snakeX[0] == appleX && snakeY[0] == appleY) {
            snake.grow();
            apple.randomizePosition();
            return true;
        }
        return false;
    }

    /**
     * Checking whether the snake collides with itself, and returning a boolean associated with this condition
     * @return boolean on whether the snake collides with itself or not
     */
    public boolean collidesWithItself() {
        int[] x = snake.getX();
        int[] y = snake.getY();
        int dots = snake.getDots();
        int headX = x[0];
        int headY = y[0];

        // if the snake head collides with its body then return true
        for (int i = 1; i < dots; i++) {
            if (x[i] == headX && y[i] == headY) {
                return true;
            }
        }
        return false;
    }


    /**
     * Checking whether the snake collides with the bounds of the screen
     * @return boolean condition on whether the snake collides with the bounds or not
     */
    public boolean collidesWithBounds() {
        int[] x = snake.getX();
        int[] y = snake.getY();
        int headX = x[0];
        int headY = y[0];

        return (headX < 0 || headX >= width || headY < 0 || headY >= height);
    }
}
