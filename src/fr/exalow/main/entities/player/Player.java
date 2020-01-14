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
        this.setPosition(firstPos);
        this.inventory = new Inventory();
        this.health = 100;
        this.money = 0;
    }
	
	public boolean isAlive() {
        return health > 0;
    }
	
	public void setHealth(double value) {
		this.health += value;
	}
	
	public void setMoney(double value) {
		this.money += value;
	}
	
	public int getMoney() {
        return money;
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
        if (position != null) {
            this.world.getCase(position).removeEntity(this);
        }
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
