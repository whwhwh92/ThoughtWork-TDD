package info;

import java.util.HashMap;

/**
 * Created by Sora on 2016/7/8.
 */
public class Cart {

    private HashMap<String, Integer> itemMap = new HashMap<>();

    public void addItem(String barcode, int count) {
        if (itemMap.containsKey(barcode)) {
            itemMap.put(barcode, itemMap.get(barcode) + count);
        } else {
            itemMap.put(barcode, count);
        }
    }

    public int getQuantity(String barcode) {
        int count = 0;
        if (itemMap.containsKey(barcode)) {
            count = itemMap.get(barcode);
        }
        return count;
    }

    public int getItemCount() {
        return itemMap.size();
    }
}
