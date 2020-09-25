package me.les3disciple;

/**
 * représente les coordonnées
 */
public class Coord {
    int x;
    int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(getClass() != obj.getClass())
            return false;
        Coord other = (Coord) obj;
        return other.x == x && other.y == y;
    }
}
