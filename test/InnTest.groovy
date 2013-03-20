import gildedrose.Inn
import gildedrose.Item
import spock.lang.Specification

/**
 * @author xbk
 */
class InnTest extends Specification
{
    def "At the end of each day our system lowers both values for every item"()
    {
        setup:
        def item = new Item(sellIn: 3, quality: 2)
        def inn = new Inn(item)

        when:
        inn.nextDay()

        then:
        item.sellIn == 2
        item.quality == 1
    }

    def "At the end of each day our system lowers both values for two existing itema"()
    {
        setup:
        def itemOne = new Item(sellIn: 3, quality: 2)
        def itemTwo = new Item(sellIn: 5, quality: 6)
        def inn = new Inn(itemOne, itemTwo)

        when:
        inn.nextDay()

        then:
        itemOne.sellIn == 2
        itemOne.quality == 1
        itemTwo.sellIn == 4
        itemTwo.quality == 5
    }

    def "Sell in days cannot be below zero"()
    {
        setup:
        def itemOne = new Item(sellIn: 0, quality: 4)
        def inn = new Inn(itemOne)

        when:
        inn.nextDay()

        then:
        itemOne.sellIn == 0
    }

    def "If sell in days is zero, decrease quality twice as fast"()
    {
        setup:
        def itemOne = new Item(sellIn: 0, quality: 4)
        def inn = new Inn(itemOne)

        when:
        inn.nextDay()

        then:
        itemOne.quality == 2
    }

    def "The Quality of an item with sell in days not passed is never negative"()
    {
        setup:
        def itemOne = new Item(sellIn: 1, quality: 0)
        def inn = new Inn(itemOne)

        when:
        inn.nextDay()

        then:
        itemOne.quality == 0
    }

    def "The Quality of an item with sell in days  passed is never negative"()
    {
        setup:
        def itemOne = new Item(sellIn: 0, quality: 1)
        def inn = new Inn(itemOne)

        when:
        inn.nextDay()

        then:
        itemOne.quality == 0
    }

    def "\"Aged Brie\" actually increases in Quality the older it gets"()
    {
        setup:
        def itemOne = new Item(sellIn: 0, quality: 4, name: "Aged Brie")
        def inn = new Inn(itemOne)

        when:
        inn.nextDay()

        then:
        itemOne.quality == 5
    }

    def "The Quality of an item is never more than 50"()
    {
        setup:
        def itemOne = new Item(sellIn: 0, quality: 50, name: "Aged Brie")
        def inn = new Inn(itemOne)

        when:
        inn.nextDay()

        then:
        itemOne.quality == 50
    }


    def "\"Sulfuras\", being a legendary item, never has to be sold or decreases in Quality"()
    {
        setup:
        def itemOne = new Item(sellIn: 10, quality: 42, name: "Sulfuras")
        def inn = new Inn(itemOne)

        when:
        inn.nextDay()

        then:
        itemOne.quality == 42
        itemOne.sellIn == 10
    }
}
