package info;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sora on 2016/7/8.
 */
public class Offer {

    private Set<String> barcodeSet = new HashSet<>();

    public void add(String barcode) {
        barcodeSet.add(barcode);
    }

    public boolean check(Goods goods) {
        return barcodeSet.contains(goods.getBarcode());
    }
}
