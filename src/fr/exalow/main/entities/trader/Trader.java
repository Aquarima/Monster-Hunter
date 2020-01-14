package fr.ehis.main.entities.trader;

import fr.ehis.main.entities.Entity;
import fr.ehis.main.world.Position;
import fr.ehis.main.world.World;

public class Trader implements Entity {

    private World world;
    private Position position;
    private Shop shop;

    public Trader(World world, Position firstPos) {
        this.world = world;
        this.position = firstPos;
        this.shop = new Shop();
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
        return "T";
    }
}
