package com.gildedrose.domain;

public class Cheese extends Item {
    public Cheese(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.setAmountToDecrease(1);
    }
}

