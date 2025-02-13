package com.gildedrose;

import com.gildedrose.config.GildedRoseConfig;
import com.gildedrose.domain.Item;
import com.gildedrose.service.GildedRoseBookkeeperService;

import java.util.Scanner;

class GildedRose {
    private GildedRoseBookkeeperService gildedTrosBookkeeperService = new GildedRoseBookkeeperService();
    private final Scanner scanner = new Scanner(System.in);
    private int days = 2;

    public static void main(String[] args) {
        GildedRose gildedRose = new GildedRose();
        gildedRose.startJourney();
    }

    public void startJourney() {
        GildedRoseConfig.configDb();
        System.out.printf("Give a number of days, (default %d):", days);
        String input = scanner.nextLine();
        if (!input.equals("") && input.chars().allMatch(Character::isDigit)) {
            days = Integer.parseInt(input);
            showQualityOfItems();
        } else if (!input.equals("") && !input.chars().allMatch(Character::isDigit)) {
            System.out.println("\nPlease provide a numeric input");
        } else {
            showQualityOfItems();
        }

        System.out.print("Try again? (type y/n):");
        if (scanner.nextLine().equals("y")) {
            startJourney();
        }
    }

    private void showQualityOfItems() {
        for (int i = 0; i <= days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            gildedTrosBookkeeperService.getItems().forEach(System.out::println);
            System.out.println();
            gildedTrosBookkeeperService.updateQuality();
        }
    }

//    public void updateQuality() {
//        for (int i = 0; i < items.length; i++) {
//            if (!items[i].name.equals("Aged Brie")
//                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                if (items[i].quality > 0) {
//                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                        items[i].quality = items[i].quality - 1;
//                    }
//                }
//            } else {
//                if (items[i].quality < 50) {
//                    items[i].quality = items[i].quality + 1;
//
//                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].sellIn < 11) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//
//                        if (items[i].sellIn < 6) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                items[i].sellIn = items[i].sellIn - 1;
//            }
//
//            if (items[i].sellIn < 0) {
//                if (!items[i].name.equals("Aged Brie")) {
//                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].quality > 0) {
//                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                                items[i].quality = items[i].quality - 1;
//                            }
//                        }
//                    } else {
//                        items[i].quality = items[i].quality - items[i].quality;
//                    }
//                } else {
//                    if (items[i].quality < 50) {
//                        items[i].quality = items[i].quality + 1;
//                    }
//                }
//            }
//        }
//    }
}
