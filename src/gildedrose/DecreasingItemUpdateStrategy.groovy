package gildedrose

/**
 * @author xbk
 */
class DecreasingItemUpdateStrategy
{
    def updateItem(Item item)
    {
        if (sellInDaysPassed(item))
        {
            item.decreaseQuality(2)
        }
        else
        {
            item.sellIn--
            item.decreaseQuality(1)
        }
    }

    def boolean sellInDaysPassed(def item)
    {
        item.sellIn == 0
    }

}