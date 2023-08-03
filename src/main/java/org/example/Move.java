package org.example;

public class Move {
    private Snake snake;

    /**
     * @param snake snake object that needs to move
     */
    public Move(Snake snake) {
        this.snake = snake;
    }

    /**
     * Reacting to the changes in direction of the snake.
     */
    public void move() {
        int[] x = snake.getX();
        int[] y = snake.getY();
        int dots = snake.getDots();
        Direction direction = snake.getDirection();

        for (int i = dots; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        if (direction == Direction.LEFT) {
            x[0] -= Constants.DOT_SIZE;
        } else if (direction == Direction.RIGHT) {
            x[0] += Constants.DOT_SIZE;
        } else if (direction == Direction.UP) {
            y[0] -= Constants.DOT_SIZE;
        } else if (direction == Direction.DOWN) {
            y[0] += Constants.DOT_SIZE;
        }
    }
}
