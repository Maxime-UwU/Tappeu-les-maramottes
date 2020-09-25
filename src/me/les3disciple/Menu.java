package me.les3disciple;

import java.util.Scanner;


/**
 * class d'affichage des menus
 */
public class  Menu {
    private final static AudioClip clickSound = new AudioClip("click");
    private final static AudioClip errorSound = new AudioClip("error");

    /**
     * affiche le menu démarrer
     * @return le choix de l'utilisateur sous forme d'index
     */
    static int choiceStart(){
        System.out.println("Press 1 to play ");
        System.out.println("Press 2 to view the highscore ");
        System.out.println("Press 3 to quit ");
        System.out.print("enter your choice : ");
        return askInput(3);
    }

    /**
     * affiche le menu de choix de difficulté
     * @return le niveau de difficulté sous forme d'index
     */
    static int choiceDifficulty() {
        System.out.println("1 : Easy (nb colonnes 5, nb lignes 5, 4 seconds par round)");
        System.out.println("2 : Medium (nb colonnes 7, nb lignes 7,  3,5 seconds par round)");
        System.out.println("3 : Hard nb colonnes 10, nb lignes 10, 3 seconds par round)");
        System.out.print("Choose your difficulty level : ");
        return askInput(3);


    }

    /**
     * sécurité pour ne pas faire crash le programme
     * @param max désigne le max d'input possible
     * @return une valeur valable
     */
    static int askInput(int max){
        Scanner scan=new Scanner(System.in);
        try {
            int nextInt = scan.nextInt();
            if(nextInt > max || nextInt <= 0){
                throw new Exception();
            }
            clickSound.play();
            return nextInt;
        }
        catch (Exception e){
            System.out.println("entrée incorrecte");
            errorSound.play();
            return askInput(max);
        }
    }
}
