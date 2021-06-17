package edu.alenasoft.gildedrose;

public class GenericItem implements ICustomItem{
    private Item item;

    public GenericItem(Item item) {
        this.item = item;
    }
    @Override
    public void updateQuality() {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
        item.setSellIn(item.getSellIn() - 1);
        if (item.getSellIn() < 0 && item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
    }
}
