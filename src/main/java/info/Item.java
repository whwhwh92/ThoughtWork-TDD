package info;

/**
 * Created by Sora on 2016/7/11.
 */
public class Item {

    private Goods goods = null;
    private int quantity = 0;

    public Item(Goods goods) {
        this.goods = goods;
    }

    public Goods getGoods() {
        return goods;
    }

    public int getQuantity() {
        return quantity;
    }

    public void add(int count) {
        quantity += count;
    }

    public float getOriginCost() {
        return goods.getPrice() * quantity;
    }
}
