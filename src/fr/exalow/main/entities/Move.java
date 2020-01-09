package fr.exalow.main.entities;

import fr.exalow.main.world.Position;

public enum Move {

    UP(new Position(-1, 0)),

    DOWN(new Position(1, 0)),

    RIGHT(new Position(0, 1)),

    LEFT(new Position(0, -1)),

    NONE(new Position(0, 0));

    private Position position;

    Move(Position position) {
        this.position = position;
    }

    public Position getMove() {
        return position;
    }
}
