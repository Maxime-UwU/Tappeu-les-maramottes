package me.les3disciple;

/**
 * gameplay principal
 */
public class Game {
    private final static AudioClip goodSound = new AudioClip("good");
    private final static AudioClip badSound = new AudioClip("bad");

    Difficulty difficulty;

    static int roundTotal = 10;

    private int score;
    private final LeaderBoard leaderBoard;

    public Game(LeaderBoard lb,Difficulty difficulty) {
        this.leaderBoard = lb;
        this.difficulty=difficulty;
    }

    /**
     * nombre de round et affichage du game over et du score
     */
    public void play() {
        for (int i = 0; i < roundTotal; i++) {
            Coord roundPlace = getRandomCoord();
            drawBoard(roundPlace);
            getPlayerInput(roundPlace);
        }

        System.out.println(Color.GREEN.code + "GAME OVER " + Color.RESET.code + "score:" + score + " points");
        leaderBoard.recordScore(score);
        leaderBoard.display();
    }

    /**
     * affiche une valeur aléatoire en 0 et 4 a une position x et une position y
     *
     * @return la position de la marmotte dans le tableau
     */
    Coord getRandomCoord() {
        int x = (int) (Math.random() * 5);
        int y = (int) (Math.random() * 5);

        return new Coord(x, y);
    }

    /**
     * affiche un tableau dans lequel la marmotte ce déplacera
     *
     * @param coord coordonés de la marmotte
     */
    void drawBoard(Coord coord) {


        for (int i = 0; i <= difficulty.boardLength; i++) {
            System.out.print(i);

            if (coord.y == i) {
                System.out.print(" ".repeat(coord.x * 2));
                ColorConsole.print("M", Color.CYAN);
            }
            System.out.println(" ");
        }


        for(int i =0; i <= difficulty.boardLength; i++){
            System.out.print( " "+i);
        }
        System.out.println();
    }

        private void getPlayerInput (Coord beaverSpot){
            Coord input = InputManager.getCoord((long) (difficulty.timePerRound * 1000));

            if (beaverSpot.equals(input)) {
                score+= difficulty.pointsPerRound;
                goodSound.play();
                ColorConsole.println("Good Answer !", Color.CYAN);
            }
            else if(!input.equals(new Coord(-1, -1))){
                badSound.play();
                ColorConsole.println("Bad Answer !", Color.YELLOW);
            }
            System.out.println("Score: " + Color.BLUE.code + score + Color.RESET.code + " points");
        }

}
