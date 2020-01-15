package fr.exalow.main.entities.player;

import fr.exalow.main.entities.Entity;
import fr.exalow.main.entities.Movable;
import fr.exalow.main.entities.Move;
import fr.exalow.main.entities.trader.Trader;
import fr.exalow.main.world.Position;
import fr.exalow.main.world.World;

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

	public void increaseMoney(int amount) {
        money += amount;
    }

    public void decreaseMoney(int amount) {
        money -= amount;
    }

	public void setMoney(double value) {
		this.money += value;
	}
	
	public int getMoney() {
        return money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public void move(Move move) {
        this.setPosition(Position.sumOf(position, move.getMove()));
    }

    public void onInteract(Entity entity) {
        if (entity instanceof Trader) {
            Trader trader = (Trader) entity;
            trader.tradeRequestTo(this);
        }
    }

    @Override
    public void setPosition(Position newPosition) {
        if (!newPosition.isOutOfWorld()) {
            if (position != null) this.world.getCase(position).removeEntity(this);
            this.position = newPosition;
            this.world.getCase(position).addEntity(this);
            return;
        }
        System.out.println("[!] You can't move this way !\n");
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
