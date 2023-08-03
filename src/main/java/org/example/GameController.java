package org.example;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameController {
    private Snake snake;
    private Apple apple;
    private Move move;
    private Collision collision;
    private AppleController appleController;
    private SnakeGamePanel panel;
    private int points;

    /**
     * @param width width of screen
     * @param height height of screen
     */
    public GameController(int width, int height) {
        snake = new Snake();
        points = 0;
        move = new Move(snake);
        collision = new Collision(snake, width, height);
        appleController = new AppleController(apple, snake, width, height);
    }

    /**
     * Setting the Apple object for this controller
     * @param a the Apple object
     */
    public void setApple(Apple a) {
        this.apple = a;
    }

    /**
     * Setting the UI panel for this controller (violation of CA)
     * @param panel the Panel passed in
     */
    public void setPanel (SnakeGamePanel panel) {
        this.panel = panel;
    }

    /**
     * Returning the snake associated with this object
     * @return The snake object
     */
    public Snake getSnake() {
        return snake;
    }

    /**
     * Moving and checking collisions, if there are any collisions, calling updateTitle method on panel which
     * increments points and changes colour of the background
     */
    public void updateGame() {
        move.move();
        if (collision.checkCollisionsWithApple(apple)) {
            points++;
            panel.updateTitle();
        }
    }

    /**
     * Returning the number of points the player has collected
     * @return an integer number of points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Handling keyboard input
     * @param key the key that is pressed
     */
    public void handleInput(int key) {
        if (key == KeyEvent.VK_LEFT && snake.getDirection() != Direction.RIGHT) {
            snake.setDirection(Direction.LEFT);
        } else if (key == KeyEvent.VK_RIGHT && snake.getDirection() != Direction.LEFT) {
            snake.setDirection(Direction.RIGHT);
        } else if (key == KeyEvent.VK_UP && snake.getDirection() != Direction.DOWN) {
            snake.setDirection(Direction.UP);
        } else if (key == KeyEvent.VK_DOWN && snake.getDirection() != Direction.UP) {
            snake.setDirection(Direction.DOWN);
        }
    }

    /**
     * initial positioning and colouring of the objects to be displayed on the UI (violation of SRP)
     * @param g graphics object
     */
    public void draw(Graphics g) {
        int[] snakeX = snake.getX();
        int[] snakeY = snake.getY();
        int dots = snake.getDots();

        // setting the snake colour in UI
        for (int i = 0; i < dots; i++) {
            g.setColor(Color.WHITE);
            g.fillRect(snakeX[i], snakeY[i], Constants.DOT_SIZE, Constants.DOT_SIZE);
        }

        // setting the apple color in UI
        g.setColor(Color.GREEN);
        g.fillOval(apple.getX(), apple.getY(), Constants.DOT_SIZE, Constants.DOT_SIZE);
    }

    /**
     * Checks if the game is over, whether the player collides with the wall or themselves
     * @return boolean associated with the condition to end the game
     */
    public boolean isGameOver() {
        return collision.collidesWithBounds() || collision.collidesWithItself();
    }
}
