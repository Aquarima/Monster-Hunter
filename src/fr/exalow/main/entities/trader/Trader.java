package fr.exalow.main.entities.trader;

import fr.exalow.main.entities.Entity;
import fr.exalow.main.entities.player.Player;
import fr.exalow.main.world.Position;
import fr.exalow.main.world.World;

public class Trader implements Entity {

    private World world;
    private Position position;
    private Shop shop;

    public Trader(World world, Position firstPos) {
        this.world = world;
        this.setPosition(firstPos);
        this.shop = new Shop();
    }

    @Override
    public void onInteract(Entity entity) {

    }

    public void tradeRequestTo(Player player) {

    }

    public void tradeWith(Player player) {

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
        return "T";
    }
}
