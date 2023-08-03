package org.example;
import javax.swing.*;

// main class, puts all the components together and runs the game
public class Main {
    public static void main(String[] args) {
        // initializing everything needed to initially play the game
        Apple a = new Apple();
        GameController gameController = new GameController(Constants.WIDTH, Constants.HEIGHT);
        SnakeGamePanel gamePanel = new SnakeGamePanel(gameController);
        gameController.setPanel(gamePanel);
        gameController.setApple(a);
        gamePanel.setApple(a);

        // setting up the UI frame
        JFrame frame = new JFrame("Snake Game - Use Arrow Keys to Control | Points: " + gameController.getPoints());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        gamePanel.startGame();
    }
}
