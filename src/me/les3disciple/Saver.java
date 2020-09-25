package me.les3disciple;

import java.io.*;

/**
 * Sauvegarder ou charger le tableau des scores
 */
public class Saver {

    static String saveFile = "save";

    /**
     * Sauvegarder le tableau des scores
     * @param lb Le tableau à sauvegarder
     */
    public static void save(LeaderBoard lb) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(saveFile));
        outputStream.writeObject(lb);
    }

    /**
     * Charger le tableau des scores
     * @return Le tableau présent dans le fichier de sauvegarde
     */
    public static LeaderBoard load() throws IOException, ClassNotFoundException {
        if(!new File(saveFile).exists())
            return new LeaderBoard();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(saveFile));
        return (LeaderBoard) inputStream.readObject();
    }

}
