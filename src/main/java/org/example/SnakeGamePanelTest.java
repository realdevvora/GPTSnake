package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SnakeGamePanelTest {
    private GameController gameController;
    private SnakeGamePanel gamePanel;

    @BeforeEach
    public void setUp() {
        gameController = new GameController(Constants.WIDTH, Constants.HEIGHT);
        Apple apple = new Apple();
        gamePanel = new SnakeGamePanel(gameController);
        gameController.setApple(apple);
        gamePanel.setApple(apple);
    }

    @Test
    public void testSnakeCollisionWithWall() {
        Snake snake = gameController.getSnake();
        snake.setDirection(Direction.RIGHT); // Assuming the initial direction is RIGHT

        // Move the snake to collide with the wall
        for (int i = 0; i < 90; i++) {
            gameController.updateGame();
        }

        assertFalse(gamePanel.isRunning(), "Game should stop after collision with the wall");
    }
}
