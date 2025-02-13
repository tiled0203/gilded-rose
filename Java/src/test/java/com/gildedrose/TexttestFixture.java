package com.gildedrose;

import com.gildedrose.domain.*;
import com.gildedrose.repository.ItemRepository;
import com.gildedrose.service.GildedRoseBookkeeperService;

import java.util.Arrays;
import java.util.List;

public class TexttestFixture {
    public static void main(String[] args) {
        GildedRoseBookkeeperService gildedRoseBookkeeperService = new GildedRoseBookkeeperService();

        System.out.println("OMGHAI!");

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

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            gildedRoseBookkeeperService.updateQuality();
        }
    }

}
