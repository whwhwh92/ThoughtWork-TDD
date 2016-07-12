package module;

import info.Cart;
import info.Item;
import info.Offer;

import java.util.List;

/**
 * Created by Sora on 2016/7/11.
 */
public class POS {

    Offer offer = null;

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public float calcCost(Item item) {
        if (null != offer) {
            return item.getOriginCost() -
                    offer.calcDiscount(item);
        } else {
            return item.getOriginCost();
        }
    }

    public int calcOffer(Item item) {
        return offer.calcOfferQuantity(item);
    }

    public float calcCost(Cart cart) {
        float cost = 0.0f;

        List<Item> itemList = cart.getItems();
        for (Item item : itemList) {
            cost += calcCost(item);
        }

        return cost;
    }

    public float calcSave(Cart cart) {
        float save = 0.0f;

        List<Item> itemList = cart.getItems();
        for (Item item : itemList) {
            save += offer.calcDiscount(item);
        }

        return save;
    }

    public Receipt getReceipt(Cart cart) {
        Receipt receipt = new Receipt();

        List<Item> itemList = cart.getItems();
        for (Item item : itemList) {
            receipt.addItem(item, calcCost(item), calcOffer(item));
        }

        receipt.setTotal(calcCost(cart), calcSave(cart));

        return receipt;
    }
}
