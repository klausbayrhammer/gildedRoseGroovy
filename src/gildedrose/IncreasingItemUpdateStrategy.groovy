package gildedrose

/**
 * @author xbk
 */
class IncreasingItemUpdateStrategy
{
    def updateItem(Item item)
    {
        item.quality = [50, item.quality+ 1].min()
    }

}
