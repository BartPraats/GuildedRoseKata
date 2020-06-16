package com.gildedrose;

public class Conjured extends Item implements CustomItem {

    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void handleCustomItemUpdate() {

        quality -= sellIn <= 0 ? 4 : 2;

        if(quality < 0) {
            quality = 0;
        }

        sellIn -= 1;
    }
}
