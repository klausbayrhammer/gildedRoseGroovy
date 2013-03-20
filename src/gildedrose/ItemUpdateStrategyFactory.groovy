package gildedrose

/**
 * @author xbk
 */
class ItemUpdateStrategyFactory
{
    def configuration = [
            {itemIsLegendary(it)} : new LegendaryItemUpdateStrategy(),
            {itemDoesIncreaseInQuality(it)} : new IncreasingItemUpdateStrategy(),
            {true} : new DecreasingItemUpdateStrategy()
    ]

    def create(final Item item)
    {
        return configuration.find {it.key(item)}.value
    }

    private boolean itemIsLegendary(Item it)
    {
        it.name == "Sulfuras"
    }

    private boolean itemDoesIncreaseInQuality(Item it)
    {
        it.name == 'Aged Brie'
    }
}
