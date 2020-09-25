package me.les3disciple;

import java.io.Serializable;

/**
 * Représente un score avec un nom associé
 */
public class HighScore implements Serializable {
    public int score;
    public String name;

    /**
     * @param score Le score
     * @param name Le nom associé
     */
    public HighScore(int score, String name) {
        this.score = score;
        this.name = name;
    }

    /**
     * Représente un score vide
     */
    public static final HighScore EMPTY = new HighScore(0, "vide");
}
