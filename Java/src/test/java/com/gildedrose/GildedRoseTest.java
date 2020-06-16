package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    /*
     * Standard Item test
     * */
    @Test
    void standardItemShouldNeverHaveNegativeQuality() {
        //Given
        Item[] items = new Item[] { new StandardItem("foo", 0, 0) };
        GildedRose app = new GildedRose(items);

        //When
        app.updateQuality();

        //Then
        assertTrue( 0 <= app.items[0].quality);
        assertEquals( -1, app.items[0].sellIn);
    }

    @Test
    void standardItemsShouldDegradeBy1() {
        //Given
        Item[] items = new Item[] { new StandardItem("foo", 10, 30) };
        GildedRose app = new GildedRose(items);

        //When
        app.updateQuality();

        //Then
        assertEquals( 29, app.items[0].quality);
        assertEquals( 9, app.items[0].sellIn);
    }

    @Test
    void standardItemsAfterSellDateShouldDegradeBy2() {
        //Given
        Item[] items = new Item[] { new StandardItem("foo", 0, 30) };
        GildedRose app = new GildedRose(items);

        //When
        app.updateQuality();

        //Then
        assertEquals( 28, app.items[0].quality);
        assertEquals( -1, app.items[0].sellIn);
    }

    /*
     * Aged Brie tests
     * */
    @Test
    void agedBrieShouldIncreaseInQuality() {
        //Given
        Item[] items = new Item[] { new AgedBrie( "Aged Brie", 10, 10) };
        GildedRose app = new GildedRose(items);

        //When
        app.updateQuality();

        //Then
        assertEquals( 11, app.items[0].quality);
        assertEquals( 9, app.items[0].sellIn);
    }

    @Test
    void agedBrieShouldNeverHaveQualityAbove50() {
        //Given
        Item[] items = new Item[] { new AgedBrie( "Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);

        //When
        app.updateQuality();

        //Then
        assertEquals( 50, app.items[0].quality);
        assertEquals( 9, app.items[0].sellIn);
    }

    @Test
    void agedBrieShouldIncreaseDoubleInQualityAfterSellDate() {
        //Given
        Item[] items = new Item[] { new AgedBrie("Aged Brie", 0, 10) };
        GildedRose app = new GildedRose(items);

        //When
        app.updateQuality();

        //Then
        assertEquals( 12, app.items[0].quality);
        assertEquals( -1, app.items[0].sellIn);
    }

    /*
     * Sulfuras tests
     * */
    @Test
    void sulfurasShouldNotChange() {
        //Given
        Item[] items = new Item[] { new Sulfuras("Sulfuras, Hand of Ragnaros", 10, 80) };
        GildedRose app = new GildedRose(items);

        //When
        app.updateQuality();

        //Then
        assertEquals( 80, app.items[0].quality);
        assertEquals( 10, app.items[0].sellIn);
    }

    /*
     * Backstage Passes tests
     * */
    @Test
    void backstagePassesShouldIncreaseQualityBy2When10OrLessDaysRemaining() {
        //Given
        Item[] items = new Item[] { new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 10, 12) };
        GildedRose app = new GildedRose(items);

        //When
        app.updateQuality();

        //Then
        assertEquals( 14, app.items[0].quality);
        assertEquals( 9, app.items[0].sellIn);
    }

    @Test
    void backstagePassesShouldIncreaseQualityBy3When5OrLessDaysRemaining() {
        //Given
        Item[] items = new Item[] { new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 5, 12) };
        GildedRose app = new GildedRose(items);

        //When
        app.updateQuality();

        //Then
        assertEquals( 15, app.items[0].quality);
        assertEquals( 4, app.items[0].sellIn);
    }

    @Test
    void backstagePassesShouldHaveQualityOf0WhenExpired() {
        //Given
        Item[] items = new Item[] { new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 0, 12) };
        GildedRose app = new GildedRose(items);

        //When
        app.updateQuality();

        //Then
        assertEquals( 0, app.items[0].quality);
        assertEquals( -1, app.items[0].sellIn);
    }

    @Test
    void backstagePassesShouldHaveQualityAbove50() {
        //Given
        Item[] items = new Item[] { new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 5, 50) };
        GildedRose app = new GildedRose(items);

        //When
        app.updateQuality();

        //Then
        assertEquals( 50, app.items[0].quality);
        assertEquals( 4, app.items[0].sellIn);
    }

    /*
    * Conjured tests
    * */
    @Test
    void conjuredItemShouldDegradeBy2() {
        //Given
        Item[] items = new Item[] { new Conjured("Conjured Mana Cake", 10, 12) };
        GildedRose app = new GildedRose(items);

        //When
        app.updateQuality();

        //Then
        assertEquals( 10, app.items[0].quality);
        assertEquals( 9, app.items[0].sellIn);
    }

    @Test
    void conjuredItemAfterSellDateShouldDegradeBy4() {
        //Given
        Item[] items = new Item[] { new Conjured("Conjured Mana Cake", 0, 12) };
        GildedRose app = new GildedRose(items);

        //When
        app.updateQuality();

        //Then
        assertEquals( 8, app.items[0].quality);
        assertEquals( -1, app.items[0].sellIn);
    }
}
