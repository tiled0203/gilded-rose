package com.gildedrose.domain;

public class Legendary extends Item{
    public Legendary(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        this.getLogger().fine(String.format("%s is a legendary item, it's not for sale and quality won't decrease", this.getName()));
    }
}
