package util;

import info.Goods;
import info.Offer;

/**
 * Created by Sora on 2016/7/11.
 */
public class TestDataBuilder {

    public static Goods getGoods() {
        return getOfferGoods();
    }

    public static Goods getOfferGoods() {
        Goods goods = new Goods();
        goods.setBarcode("ITEM000001");
        goods.setName("可口可乐");
        goods.setCategory("食品");
        goods.setSubCategory("饮料");
        goods.setUnit("瓶");
        goods.setPrice(3.00f);
        return goods;
    }

    public static Goods getNonOfferGoods() {
        Goods goods = new Goods();
        goods.setBarcode("ITEM000003");
        goods.setName("苹果");
        goods.setCategory("食品");
        goods.setSubCategory("水果");
        goods.setUnit("斤");
        goods.setPrice(5.50f);
        return goods;
    }

    public static Offer getOffer() {
        Offer offer = new Offer();
        offer.add("ITEM000001");
        offer.add("ITEM000005");
        return offer;
    }
}
