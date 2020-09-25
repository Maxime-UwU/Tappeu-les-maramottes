package me.les3disciple;

/**
 * permet d'afficher du texte en couleur dans la console
 */
public class ColorConsole {

    public static void println(String message, Color color){
        System.out.println(color.code + message + Color.RESET.code);
    }

    public static void print(String message, Color color){
        System.out.print(color.code + message + Color.RESET.code);
    }

}
