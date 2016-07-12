package info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sora on 2016/7/8.
 */
public class Cart {

    private HashMap<String, Item> itemMap = new HashMap<>();

    public void addItem(Goods goods, int count) {
        String barcode = goods.getBarcode();
        if (itemMap.containsKey(barcode)) {
            Item item = itemMap.get(barcode);
            item.add(count);
            itemMap.put(barcode, item);
        } else {
            Item item = new Item(goods);
            item.add(count);
            itemMap.put(barcode, item);
        }
    }

    public int getQuantity(String barcode) {
        int count = 0;
        if (itemMap.containsKey(barcode)) {
            count = itemMap.get(barcode).getQuantity();
        }
        return count;
    }

    public int getItemCount() {
        return itemMap.size();
    }

    public List<Item> getItems() {
        return new ArrayList<>(itemMap.values());
    }
}
