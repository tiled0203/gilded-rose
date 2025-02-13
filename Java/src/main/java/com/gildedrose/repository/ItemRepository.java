package com.gildedrose.repository;

import java.util.ArrayList;
import java.util.List;
import com.gildedrose.domain.Item;

public class ItemRepository {
    private static ItemRepository instance;
    private List<Item> items = new ArrayList<>();

    private ItemRepository() {
    }

    public static ItemRepository getInstance() {
        if (instance == null) {
            instance = new ItemRepository();
        }
        return instance;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
