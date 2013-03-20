package gildedrose

/**
 * @author xbk
 */
class Item {
    int sellIn
    int quality
    def name

    def decreaseQuality(final int decreaseFactor)
    {
        quality = [0, quality - decreaseFactor].max()
    }

}
