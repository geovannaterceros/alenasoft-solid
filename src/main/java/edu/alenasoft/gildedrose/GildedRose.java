package edu.alenasoft.gildedrose;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GildedRose {

  public static List<Item> items = new ArrayList<>();

  public static void main(String[] args) {

    System.out.println("OMGHAI!");

    items.add(new Item("+5 Dexterity Vest", 10, 20));
    items.add(new Item("Aged Brie", 2, 0));
    items.add(new Item("Elixir of the Mongoose", 5, 7));
    items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
    items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
    items.add(new Item("Conjured Mana Cake", 3, 6));

    updateQuality();

    System.out.println(items);
  }

  public static void updateQuality()
  {
    HashMap<String, ICustomItem> ItemTypes = new HashMap<String, ICustomItem>();
    for (Item item : items) {
      methodItem(ItemTypes, item).updateQuality();
    }
  }

  public static ICustomItem methodItem(HashMap<String, ICustomItem> ItemTypes,Item item){
    String SULFURAS = "Sulfuras, Hand of Ragnaros";
    String AGED_BRIE = "Aged Brie";
    String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    String CONJURED = "Conjured Mana Cake";

    ItemTypes.put(SULFURAS, new Sulfuras());
    ItemTypes.put(AGED_BRIE, new AgedBrie(item));
    ItemTypes.put(BACKSTAGE_PASSES,new BackstagePasses(item));
     ItemTypes.put(CONJURED, new Conjured(item));
    return ItemTypes.keySet().contains(item.name)? ItemTypes.get(item.name): new GenericItem(item);
  }
}
