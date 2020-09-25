package me.les3disciple;

/**
 * représente la difficultée
 */
public enum Difficulty {
    EASY(1,5,4),
    MEDIUM(2,7,3.5f),
    HARD(3,10,3);
    final int pointsPerRound;
    final int boardLength;
    final float timePerRound;

    Difficulty(int pointsPerRound, int boardLength,float timePerRound) {
        this.pointsPerRound = pointsPerRound;
        this.boardLength = boardLength;
        this.timePerRound=timePerRound;
    }
}
