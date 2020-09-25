package me.les3disciple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * gere les entrées utilisateur
 */
public class InputManager {
    private final static AudioClip timeOutSound = new AudioClip("time-out");

    /**
     * La fonction permet au joueur d'entré des valeurs et de les vérifiées avec un systeme de temps limité
     * @param limitTime c'est le temps limite en milliseconde
     * @return les coordonées de l'utilisateur ou -1 - -1 pour une mauvaise reponse
     */
    public static Coord getCoord(long limitTime) {

        try{
            long startTime = System.currentTimeMillis();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                long currentTime = System.currentTimeMillis() - startTime;

                if(currentTime > limitTime) {
                    timeOutSound.play();
                    ColorConsole.println("Time out !", Color.YELLOW);
                    return new Coord(-1, -1);
                }


                if (reader.ready()) {
                    int x, y;
                    y = reader.read() - 48;
                    reader.read();
                    x = reader.read() - 48;

                    return new Coord(x, y);

                }
            }
        } catch (IOException e) {
            timeOutSound.play();
            System.out.println("Incorect input");
            return new Coord(-1, -1);
        }

    }
}
