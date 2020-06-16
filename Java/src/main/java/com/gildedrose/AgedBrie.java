package com.gildedrose;

public class AgedBrie extends Item implements CustomItem {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void handleCustomItemUpdate() {
        quality += sellIn <= 0 ? 2 : 1;

        if(quality >= 50){
            quality = 50;
        }

        sellIn -= 1;
    }
}
