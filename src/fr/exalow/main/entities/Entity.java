package fr.exalow.main.entities;

import fr.exalow.main.world.Position;

public interface Entity {

    void setPosition(Position newPosition);

    Position getPosition();
}
