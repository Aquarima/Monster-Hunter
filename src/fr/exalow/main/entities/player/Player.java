package fr.ehis.main.entities.player;

import fr.ehis.main.entities.Entity;
import fr.ehis.main.entities.Movable;
import fr.ehis.main.entities.Move;
import fr.ehis.main.world.Position;
import fr.ehis.main.world.World;

public class Player implements Entity, Movable {

    private World world;
    private Position position;
    private Inventory inventory;
    private double health;
    private int money;

    public Player(World world, Position firstPos) {
        this.world = world;
        this.position = firstPos;
        this.inventory = new Inventory();
        this.health = 100;
        this.money = 0;
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
        this.setPosition(Position.sumOf(position, move.getMove()));
    }

    public int getMoney() {
        return money;
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
        return "P";
    }
}
