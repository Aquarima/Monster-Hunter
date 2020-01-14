package fr.exalow.main.manager;

import fr.exalow.main.entities.Entity;
import fr.exalow.main.entities.monster.Monster;
import fr.exalow.main.entities.player.Player;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {

    private List<Entity> entities = new ArrayList<>();

    public void update() {
        for (Entity entity : entities) {
            if (entity instanceof Player) {
                if (!((Player) entity).isAlive()) entities.remove(entity);
            }
            if (entity instanceof Monster) {
                if (!((Monster) entity).isAlive()) entities.remove(entity);
            }
        }
    }

    public void addEntity(Entity entity) {
        this.entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        this.entities.remove(entity);
    }

    public List<Entity> getWorldEntities() {
        return entities;
    }
}
