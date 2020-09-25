package me.les3disciple;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Représente le tableau des meilleurs scores
 */
public class LeaderBoard implements Serializable {
    private static final AudioClip newHighScoreSound = new AudioClip("new-record");

    private final int scoreToRecords = 5;

    private final HighScore[] highScores = new HighScore[scoreToRecords];

    public LeaderBoard(){
        Arrays.fill(highScores, HighScore.EMPTY);
    }

    private int closest(int score){
        for (int i = 0; i < highScores.length; i++){
            if (score > highScores[i].score)
                return i;
        }

        return -1;
    }

    /**
     * Vérifier si le score du joueur est suffisamment haut pour être dans le Leader board,
     * et le cas échéant lui demande son nom et l'ajoute
     * @param score Le nouveau score du joueur
     */
    public void recordScore(int score){
        int index = closest(score);

        if (index == -1)
            return;

        newHighScoreSound.play();
        ColorConsole.println("New record! Enter your name:", Color.PURPLE);
        String name = new Scanner(System.in).nextLine();

        insert(new HighScore(score, name), index);

    }

    /**
     * Insert le score d'un joueur dans le Leader board.
     * Est appelé automatiquement lors de l'appelle de recordScore()
     * @param highScore Le score à ajouter
     * @param index La position ou ajouter le score (0 = meilleur)
     */
    public void insert(HighScore highScore, int index){
        if (highScores.length - 1 - index >= 0)
            System.arraycopy(highScores, index, highScores, index + 1, highScores.length - 1 - index);

        highScores[index] = highScore;
    }

    /**
     * Affiche le Leader board dans la console
     */
    public void display(){
        StringBuilder sb = new StringBuilder();
        sb.append('|').append("-".repeat(20)).append("|\n");
        for (int i = 0; i < highScores.length; i++) {
            HighScore highScore = highScores[i];
            sb.append(String.format("|%s#%d %s%-13s  %s%02d%s|%n",
                    Color.CYAN.code, i + 1, Color.PURPLE.code, highScore.name, Color.YELLOW.code, highScore.score, Color.RESET.code));
            sb.append('|').append("-".repeat(20)).append("|\n");
        }


        System.out.println(sb.toString());
    }

}
