package fr.exalow.main.entities.player;

import fr.exalow.main.entities.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Item> items = new ArrayList<>(5);

    public boolean isFull() {
        return items.size() == 4;
    }

    public void addItem(Item item) {
        if (!isFull()) {
            items.add(item);
        }
        System.out.println("[!] Your inventory is full !\n");
    }

    public void removeItem(int slot) {
        items.remove(slot);
        System.out.println("[!] " + items.get(slot) + " was Successfully removed from your inventory !\n");
    }

    public void clear() {
        items.clear();
    }

    @Override
    public String toString() {
        StringBuilder inventory = new StringBuilder();
        inventory.append("==========[Inventory]==========");
        for (int i = 0; i < items.size(); i++) {
            inventory.append("[" + i + "] " + items.get(i));
        }
        inventory.append("===============================");
        return inventory.toString();
    }
}
