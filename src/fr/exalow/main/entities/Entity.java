package fr.ehis.main.entities;

import fr.ehis.main.world.Position;

public interface Entity {

    void setPosition(Position newPosition);

    Position getPosition();
}
