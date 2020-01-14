package fr.exalow.main.entities.monster;

import fr.exalow.main.entities.Entity;
import fr.exalow.main.entities.Movable;
import fr.exalow.main.entities.Move;
import fr.exalow.main.world.Position;
import fr.exalow.main.world.World;

public class Monster implements Entity, Movable {

    private World world;
    private Position position;
    private double health;

    public Monster(World world, Position firstPos) {
        this.world = world;
        this.position = firstPos;
        this.health = 100;
    }

    public boolean isAlive() {
        return health < 0;
    }

    public void setHealth(double value) {
        this.health += value;
    }

    @Override
    public void move(Move move) {
        this.setPosition(Position.sumOf(position, move.getMove()));
    }

    @Override
    public void onInteract(Entity entity) {

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
