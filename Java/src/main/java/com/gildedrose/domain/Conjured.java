package com.gildedrose.domain;

public class Conjured extends Item {
    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.setAmountToDecrease(-1);
    }
}
