package com.gildedrose.domain;


import java.util.logging.Logger;

public abstract class Item {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private String name;
    private int sellIn;
    private int quality;
    private int amountToDecrease = -1;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    private void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    protected void setQuality(int quality) {
        this.quality = Math.max(Math.min(quality, 50), 0);
    }

    protected void setAmountToDecrease(int amountToDecrease) {
        this.amountToDecrease = amountToDecrease;
    }

    public void update() {
        logger.fine(String.format("A day has passed, quality of %s is updated", name));
        this.setSellIn(this.getSellIn() - 1);
        if (getSellIn() < 0) {
            this.setQuality(this.getQuality() + (2 * amountToDecrease));
        } else {
            this.setQuality(this.getQuality() + (amountToDecrease));
        }
    }

    public Logger getLogger() {
        return logger;
    }

    @Override
    public String toString() {
        return this.getName() + ", " + this.getSellIn() + ", " + this.getQuality();
    }
}
