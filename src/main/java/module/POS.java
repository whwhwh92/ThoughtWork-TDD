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

    public String getItemInfo(Item item) {
        return String.format(
                "名称：%s，数量：%d%s，单价：%.2f(元)，小计：%.2f(元)",
                item.getGoods().getName(),
                item.getQuantity(), item.getGoods().getUnit(),
                item.getGoods().getPrice(),
                calcCost(item));
    }

    public String getItemOfferInfo(Item item) {
        if (offer.check(item.getGoods())) {
            return String.format(
                    "名称：%s，数量：%d%s",
                    item.getGoods().getName(),
                    offer.calcOfferQuantity(item),
                    item.getGoods().getUnit());
        } else {
            return "";
        }
    }

    public String getTotalCostInfo(Cart cart) {
        return String.format("总计：%.2f(元)",
                calcCost(cart));
    }

    public String getTotalSaveInfo(Cart cart) {
        if (calcSave(cart) > 0.0f) {
            return String.format("节省：%.2f(元)",
                    calcSave(cart));
        } else {
            return "";
        }
    }

    public Receipt getReceipt(Cart cart) {
        Receipt receipt = new Receipt();

        List<Item> itemList = cart.getItems();
        for (Item item : itemList) {
            receipt.addItemCostInfo(getItemInfo(item));
            receipt.addItemOfferInfo(getItemOfferInfo(item));
        }

        receipt.setTotalCostInfo(getTotalCostInfo(cart));
        receipt.setTotalSaveInfo(getTotalSaveInfo(cart));

        return receipt;
    }
}
