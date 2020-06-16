package com.gildedrose;

public class StandardItem extends Item implements CustomItem {

    public StandardItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void handleCustomItemUpdate() {

        super.quality -= sellIn <= 0 ? 2 : 1;

        if(quality < 0) {
            quality = 0;
        }

        super.sellIn -= 1;
    }
}
