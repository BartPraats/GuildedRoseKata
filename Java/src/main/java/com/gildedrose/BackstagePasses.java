package com.gildedrose;

public class BackstagePasses extends Item implements CustomItem {

    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void handleCustomItemUpdate() {

        if (sellIn <= 0){
            quality = 0;
        } else if (sellIn <= 5) {
            quality += 3;
        } else if(sellIn <= 10){
            quality += 2;
        }

        if(quality >= 50){
            quality = 50;
        }

        sellIn -= 1;
    }
}
