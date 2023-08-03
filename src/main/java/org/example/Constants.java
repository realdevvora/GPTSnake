package org.example;

// all constants needed throughout this program
public class Constants {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;
    public static final int DOT_SIZE = 10;
    public static final int ALL_DOTS = (Constants.WIDTH * Constants.HEIGHT) / (Constants.DOT_SIZE * Constants.DOT_SIZE);
    public static final int DELAY = 100;

    private Constants() {
        // Private constructor to prevent instantiation
    }
}