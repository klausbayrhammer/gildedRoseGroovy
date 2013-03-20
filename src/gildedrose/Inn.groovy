package gildedrose

/**
 * @author xbk
 */
class Inn
{
    Item[] items

    Inn(Item... items)
    {
        this.items = items
    }

    def nextDay()
    {
        items.each { item ->
            def strategy = new ItemUpdateStrategyFactory().create(item)
            strategy.updateItem(item)
        }
    }
}
