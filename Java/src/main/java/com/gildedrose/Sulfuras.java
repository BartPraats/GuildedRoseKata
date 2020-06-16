package com.gildedrose;

public class Sulfuras extends Item implements CustomItem {

    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void handleCustomItemUpdate() {
        //Do nothing
    }
}
