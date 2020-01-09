package fr.exalow.main.world;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isOutOfWorld() {
        return x > 8 || x < 0 || y > 8 || y < 0;
    }

    public Position sumOf(Position pos1, Position pos2) {
        return new Position(pos1.x + pos2.x, pos1.y + pos2.y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
