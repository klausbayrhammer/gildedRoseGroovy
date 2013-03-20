import gildedrose.Item
import spock.lang.Specification

/**
 * @author xbk
 */
class ItemTest extends Specification
{
    def "All items have a SellIn value which denotes the number of days we have to sell the item"()
    {
        expect:
            item.sellIn == 2
        where:
            item = new Item(sellIn: 2, quality: 1)
    }

    def "All items have a Quality value which denotes how valuable the item is"()
    {
        expect:
            item.quality == 42
        where:
            item = new Item(sellIn: 1, quality: 42)
    }

    def "All items have a name"()
    {
        expect:
            item.name == "Aged Brie"
        where:
            item = new Item(sellIn: 1, quality: 42, name: 'Aged Brie')
    }

}
