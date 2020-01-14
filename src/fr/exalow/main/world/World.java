package fr.ehis.main.world;

public class World {

    private Case[][] map = new Case[8][8];

    public World() {
        initialize();
    }

    public void initialize() {
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                map[x][y] = new Case();
            }
        }
    }

    public void display() {
        System.out.println("\n    0   1   2   3   4   5   6   7");
        for (int x = 0; x < map.length; x++) {
            System.out.print(x + "  ");
            for (int y = 0; y < map.length; y++) {
                System.out.print("[" + map[x][y] + "] ");
            }
            System.out.println();
        }
    }

    public void clear() {
        initialize();
    }

    public Case getCase(Position position) {
        return map[position.getX()][position.getY()];
    }
}
