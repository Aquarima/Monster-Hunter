package fr.exalow.main.entities.trader;

import fr.exalow.main.entities.Entity;
import fr.exalow.main.entities.player.Player;
import fr.exalow.main.world.Position;
import fr.exalow.main.world.World;

import java.util.Scanner;

public class Trader implements Entity {

    private Scanner scanner = new Scanner(System.in);

    private World world;
    private Position position;
    private Shop shop;

    public Trader(World world, Position firstPos) {
        this.world = world;
        this.setPosition(firstPos);
        this.shop = new Shop();
    }

    public void tradeRequestTo(Player player) {
        if (!player.getInventory().isFull()) {
            System.out.println("\n[Trader] Welcome sir, Do you want to buy something ?");
            System.out.print("\nType (true/false) : ");
            if (scanner.nextBoolean()) tradeWith(player);
        }
    }

    private void tradeWith(Player player) {

        System.out.println("\n[Trader] Well, This is my shop choose something to buy...");
        System.out.println(shop);

        int input = 0;

        do {
            System.out.print("\nType item number : ");
            input = scanner.nextInt();
        } while (!shop.exist(input));

        System.out.print("\nAmount : ");

        int amount = scanner.nextInt();

        if (player.getMoney() < shop.getPriceOf(input, amount)) {
            System.err.println("\n[!] You can't afford this !");
            return;
        }

        player.decreaseMoney(shop.getPriceOf(input, amount));
        player.getInventory().addItem(shop.getItem(input));
    }

    @Override
    public void setPosition(Position newPosition) {
        if (!newPosition.isOutOfWorld()) {
            if (position != null) this.world.getCase(position).removeEntity(this);
            this.position = newPosition;
            this.world.getCase(position).addEntity(this);
        }
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
