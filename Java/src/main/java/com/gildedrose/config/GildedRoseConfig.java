package com.gildedrose.config;

import com.gildedrose.domain.*;
import com.gildedrose.repository.ItemRepository;

import java.util.Arrays;
import java.util.List;

public class GildedRoseConfig {
   public static void configDb(){
        List<Item> items = Arrays.asList(
            new Common("+5 Dexterity Vest", 10, 20),
            new Cheese("Aged Brie", 2, 0),
            new Common("Elixir of the Mongoose", 5, 7),
            new Legendary("Sulfuras, Hand of Ragnaros", 0, 80),
            new Legendary("Sulfuras, Hand of Ragnaros", -1, 80),
            new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Conjured("Conjured Mana Cake", 3, 6));
        ItemRepository.getInstance().setItems(items);
    }
}
