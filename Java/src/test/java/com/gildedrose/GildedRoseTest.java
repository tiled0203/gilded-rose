package com.gildedrose;

import com.gildedrose.domain.*;
import com.gildedrose.repository.ItemRepository;
import com.gildedrose.service.GildedRoseBookkeeperService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    private GildedRoseBookkeeperService gildedRoseBookkeeperService = new GildedRoseBookkeeperService();

    @BeforeAll
    static void setUp() {
        List<Item> items = Arrays.asList(
            new Common("+5 Dexterity Vest", 10, 20),
            new Cheese("Aged Brie", 2, 0),
            new Common("Elixir of the Mongoose", 5, 7),
            new Legendary("Sulfuras, Hand of Ragnaros", 0, 80),
            new Legendary("Sulfuras, Hand of Ragnaros", -1, 80),
            new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new Conjured("Conjured Mana Cake", 3, 6));
        ItemRepository.getInstance().setItems(items);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1, delimiter = ';')
    void testGilderRoseCommonItems(int index, String name, int sellIn, int quality) {
        List<Item> items = gildedRoseBookkeeperService.getItems();
        assertAll(
            () -> assertEquals(name, items.get(index).getName()),
            () -> assertEquals(sellIn, items.get(index).getSellIn()),
            () -> assertEquals(quality, items.get(index).getQuality())
        );
        if (index >= items.size() -1) {
            gildedRoseBookkeeperService.updateQuality();
        }
    }
}
