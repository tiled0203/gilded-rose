package com.gildedrose.domain;

public class BackstagePass extends Item {
    public BackstagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.setAmountToDecrease(1);
    }

    @Override
    public void update() {
        super.update();
        if (this.getSellIn() > -1) {
            if (this.getSellIn() < 11 && this.getSellIn() > 5) {
                this.setAmountToDecrease(2);
            }else if (this.getSellIn() < 6) {
                this.setAmountToDecrease(3);
            }
        } else {
            this.setQuality(0);
        }
    }
}
