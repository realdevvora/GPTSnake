package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// UI class
public class SnakeGamePanel extends JPanel implements ActionListener, KeyListener {
    private static final int WIDTH = Constants.WIDTH;
    private static final int HEIGHT = Constants.HEIGHT;
    private static final int DELAY = Constants.DELAY;
    private boolean run;

    private Apple apple;

    private GameController gameController;
    private Timer timer;
    private final ArrayList<Color> possibleBackgroundColors; // List of possible background colors

    private boolean gameOver;

    /**
     * @param gameController the controller object
     */
    public SnakeGamePanel(GameController gameController) {
        this.gameController = gameController;

        possibleBackgroundColors = new ArrayList<>();
        possibleBackgroundColors.add(Color.BLACK);
        possibleBackgroundColors.add(Color.BLUE);
        possibleBackgroundColors.add(Color.GREEN);
        possibleBackgroundColors.add(Color.RED);
        possibleBackgroundColors.add(Color.YELLOW);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);

        addKeyListener(this);

        timer = new Timer(DELAY, this);

        gameOver = false;
    }

    /**
     * Starting the timer and setting the game to running
     */
    public void startGame() {
        this.run = true;
        timer.start();
    }

    /**
     * Return if this game is running or not
     *
     * @return boolean run
     */
    public boolean isRunning() {
        return run;
    }

    /**
     * draw the objects onto the screen
     *
     * @param g Graphics object
     */
    private void draw(Graphics g) {

        if (!gameOver) {
            gameController.draw(g);
            Toolkit.getDefaultToolkit().sync();

            if (gameController.isGameOver()) {
                gameOver = true;
            }
        }

        if (gameOver) {
            run = false;
            drawGameOver(g);
            timer.stop();
        }
    }

    /**
     * assign an apple to this
     * @param a
     */
    public void setApple(Apple a) {
        this.apple = a;
    }

    /**
     * update the title of the window whenever a point is scored, and randomize colour
     */
    public void updateTitle() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        setBackground(apple.getRandomColor());
        frame.setTitle("Snake Game - Points: " + gameController.getPoints()); // Update the title with points
    }

    /**
     * display the game over screen
     *
     * @param g Graphics object
     */
    private void drawGameOver(Graphics g) {
        String message = "Game Over";
        Font font = new Font("Helvetica", Font.BOLD, 16);
        FontMetrics metrics = g.getFontMetrics(font);

        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(message, (WIDTH - metrics.stringWidth(message)) / 2, HEIGHT / 2);
    }

    /**
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    /**
     * keep updating and repainting the game until it is over
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            gameController.updateGame();
        }
        repaint();
    }

    /**
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * handle key input
     *
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        gameController.handleInput(key);
    }

    /**
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
