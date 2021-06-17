package edu.alenasoft.gildedrose;

public class Conjured implements ICustomItem{
    private Item item;

    public Conjured(Item item) {
        this.item = item;
    }
    @Override
    public void updateQuality() {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 2);
        }
        item.setSellIn(item.getSellIn() - 1);
        if (item.getSellIn() < 0 && item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 2);
        }
        if (item.getQuality()<0)
            item.setQuality(0);
    }
}
