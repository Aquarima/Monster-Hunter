package fr.ehis.main.entities.monster;

import fr.ehis.main.entities.Entity;
import fr.ehis.main.entities.Movable;
import fr.ehis.main.entities.Move;
import fr.ehis.main.world.Position;
import fr.ehis.main.world.World;

public class Monster implements Entity, Movable {

    private World world;
    private Position position;
    private double health;

    public Monster(World world, Position firstPos) {
        this.world = world;
        this.position = firstPos;
        this.health = 100;
    }

    public void increaseHealth(double amount) {
        this.health += amount;
    }

    public void decreaseHealth(double amount) {
        this.health -= amount;
    }

    public boolean isAlive() {
        return health < 0;
    }

    @Override
    public void move(Move move) {

    }

    private boolean isEnemyAround() {
        final Move[] moves = Move.values();
        for (int i = 0; i < 4; i++) {

        }
        return false;
    }

    private Position getEnemyPosition() {
        final Move[] moves = Move.values();
        for (int i = 0; i < 4; i++) {

        }
        return null;
    }

    @Override
    public void setPosition(Position newPosition) {
        this.world.getCase(position).removeEntity(this);
        this.position = newPosition;
        this.world.getCase(position).addEntity(this);
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "M";
    }
}
