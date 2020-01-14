package fr.ehis.main.entities.trader;

import fr.ehis.main.entities.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private List<Item> shopContent = new ArrayList<>();

    public void open() {

    }

    public Item getItem(int number) {
        return shopContent.get(number);
    }

    public int getPriceOf(int number, int amount) {
        return shopContent.get(number).getPrice() * amount;
    }
}
