package fr.exalow.main.entities.trader;

import fr.exalow.main.entities.items.Item;

import java.util.HashMap;
import java.util.Map;

public class Shop {

    private Map<Item, Integer> shop = new HashMap<>();

    public Item getItem(int number) {
        Object[] array = shop.keySet().toArray();
        return (Item) array[number];
    }

    public int getPriceOf(int number, int amount) {
        return shop.get(number) * amount;
    }

    public boolean exist(int number) {
        if (number > shop.size() || shop.isEmpty()) {
            System.err.println("[!] This item doesn't exist !");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder inventory = new StringBuilder();
        inventory.append("\n============[Shop]============");
        for (int i = 0; i < shop.size(); i++) {
            inventory.append("\n[" + i + "] " + shop.get(i));
        }
        inventory.append("\n==============================");
        return inventory.toString();
    }
}
