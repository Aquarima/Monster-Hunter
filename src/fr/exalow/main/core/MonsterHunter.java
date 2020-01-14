package fr.exalow.main.core;

import fr.exalow.main.entities.Move;
import fr.exalow.main.entities.player.Player;
import fr.exalow.main.manager.EntityManager;
import fr.exalow.main.world.Position;
import fr.exalow.main.world.World;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MonsterHunter {

    private EntityManager manager = new EntityManager();
    private World world = new World();
    private Player player = new Player(world, new Position(0, 0));

    public void run() {
        while (player.isAlive()) {
            System.out.println("\n[INFO] Your position is : " + player.getPosition());

            System.out.println("\n[P] = Player - [M] = Monster - [!] = Combat");
            world.display();

            System.out.println("\nSelect a direction to move : ");
            System.out.println("[0] UP");
            System.out.println("[1] DOWN");
            System.out.println("[2] RIGHT");
            System.out.println("[3] LEFT");
            System.out.print("    -> ");

            try {
                player.move(Move.parseMove(new Scanner(System.in).nextInt()));
            } catch (InputMismatchException e) {
                System.err.println("[ERROR] An integer between 0-3 is required !\n");
            }

            manager.update();
        }
    }

    public void update() {

    }

    public void stop() {

    }
}
