package fr.exalow.main.world;

import fr.exalow.main.entities.Entity;
import fr.exalow.main.entities.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Case {

    private List<Entity> cellContent = new ArrayList<>();

    public void addEntity(Entity entity) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            cellContent.forEach(player::onInteract);
        }
        this.cellContent.add(entity);
    }

    public void removeEntity(Entity entity) {
        this.cellContent.remove(entity);
    }

    @Override
    public String toString() {
        if (!cellContent.isEmpty()) {
            return cellContent.get(0).toString();
        }
        return " ";
    }
}
