package me.les3disciple;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LeaderBoard lb;
        // Chargement de la sauvegarde
        try {
            lb = Saver.load();
        } catch (IOException | ClassNotFoundException e) {
            ColorConsole.println("Failed to laod save file", Color.RED);
            System.out.println(e.getLocalizedMessage());

            lb = new LeaderBoard();
        }

        new AudioClip("music").playIndefinitely();

       int number;
        do {
             number=Menu.choiceStart();
            if (number==1){
                int input = Menu.choiceDifficulty();
                Difficulty difficulty= switch(input){
                    case 2->Difficulty.MEDIUM;
                    case 3->Difficulty.HARD;
                    default ->Difficulty.EASY;
                };
                new Game(lb,difficulty).play();
            }
            else{
                lb.display();
            }
        } while (number < 3);

        // Sauvegarde
        try {
            Saver.save(lb);
        } catch (IOException e) {
            ColorConsole.println("Failed to save", Color.RED);
            System.out.println(e.getLocalizedMessage());
            new Scanner(System.in).next(); // Empêcher la fenêtre de se fermer instantanément
        }
    }
}

