package fr.exalow.main.manager;

import fr.exalow.main.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {

    private List<Entity> entities = new ArrayList<>();

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
