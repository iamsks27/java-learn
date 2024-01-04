package com.shivam.learn.reflection.dynamicconfigloader;

/**
 * @author sksingh created on 12/12/23
 */
public class GameConfig {

    private int releaseYear;
    private String gameName;
    private double price;

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getGameName() {
        return gameName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "GameConfig{" +
                "releaseYear=" + releaseYear +
                ", gameName='" + gameName + '\'' +
                ", price=" + price +
                '}';
    }
}
