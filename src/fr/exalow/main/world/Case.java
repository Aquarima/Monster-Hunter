package fr.ehis.main.world;

import fr.ehis.main.entities.Entity;
import fr.ehis.main.entities.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Case {

    private List<Entity> cellContent = new ArrayList<>();

    public boolean containPlayer() {
        for (Entity entity : cellContent) {
            if (entity instanceof Player) {
                return true;
            }
        }
        return false;
    }

    public void addEntity(Entity entity) {
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
