package org.example;

import java.util.Random;
public class AppleController {
    private Apple apple;
    private Snake snake;
    private int width;
    private int height;
    private Random random;

    /**
     * @param apple the game's apple object
     * @param snake the game's snake object
     * @param width the width of the screen
     * @param height the height of the screen
     */
    public AppleController(Apple apple, Snake snake, int width, int height) {
        this.apple = apple;
        this.snake = snake;
        this.width = width;
        this.height = height;
        this.random = new Random();
    }

    /**
     * Check if the apple is collided with
     */
    public void checkApple() {

        // finding coordinates
        int appleX = apple.getX();
        int appleY = apple.getY();
        int[] snakeX = snake.getX();
        int[] snakeY = snake.getY();

        // increasing the size of the snake, and randomizing the apple
        if (snakeX[0] == appleX && snakeY[0] == appleY) {
            snake.grow();
            randomizeApplePosition();
        }
    }

    /**
     * Randomize the position of the apple on collision
     */
    private void randomizeApplePosition() {
        int appleX = random.nextInt(width / Constants.DOT_SIZE) * Constants.DOT_SIZE;
        int appleY = random.nextInt(height / Constants.DOT_SIZE) * Constants.DOT_SIZE;

        apple.setX(appleX);
        apple.setY(appleY);
    }
}

