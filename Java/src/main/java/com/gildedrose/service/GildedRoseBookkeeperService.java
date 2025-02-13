package com.gildedrose.service;

import com.gildedrose.domain.Item;
import com.gildedrose.repository.ItemRepository;

import java.util.List;

public class GildedRoseBookkeeperService {
    private ItemRepository itemRepository = ItemRepository.getInstance();
    public List<Item> getItems() {
        return itemRepository.getItems();
    }
    public void updateQuality() {
        itemRepository.getItems().forEach(Item::update);
    }
}
