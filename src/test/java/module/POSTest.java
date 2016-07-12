package module;

import info.Cart;
import info.Item;
import org.junit.Test;
import util.TestDataBuilder;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sora on 2016/7/11.
 */
public class POSTest {

    @Test
    public void should_calc_right_cost_for_item()
            throws Exception {
        POS pos = TestDataBuilder.getPOS();

        Item item = new Item(TestDataBuilder.getOfferGoods());
        item.add(2);
        assertEquals(6.00f, pos.calcCost(item), 0.001f);
        item.add(1);
        assertEquals(6.00f, pos.calcCost(item), 0.001f);

        item = new Item(TestDataBuilder.getNonOfferGoods());
        item.add(6);
        assertEquals(33.00f, pos.calcCost(item), 0.001f);
    }

    @Test
    public void should_calc_right_offer_for_item()
            throws Exception {
        POS pos = TestDataBuilder.getPOS();

        Item item = new Item(TestDataBuilder.getOfferGoods());
        item.add(2);
        assertEquals(0, pos.calcOffer(item));
        item.add(4);
        assertEquals(2, pos.calcOffer(item));

        item = new Item(TestDataBuilder.getNonOfferGoods());
        item.add(6);
        assertEquals(0, pos.calcOffer(item));
    }

    @Test
    public void should_calc_right_cost_for_cart()
            throws Exception {
        POS pos = TestDataBuilder.getPOS();

        Cart cart = TestDataBuilder.getCartWithOfferGoods();
        assertEquals(23.00f, pos.calcCost(cart), 0.001f);
        assertEquals(3.00f, pos.calcSave(cart), 0.001f);

        cart = TestDataBuilder.getCartWithoutOfferGoods();
        assertEquals(27.50f, pos.calcCost(cart), 0.001f);
        assertEquals(0.00f, pos.calcSave(cart), 0.001f);
    }

    @Test
    public void should_get_right_receipt_for_cart()
            throws Exception {
        POS pos = TestDataBuilder.getPOS();

        Cart cart = TestDataBuilder.getCartWithOfferGoods();
        assertEquals(
                "***<没钱赚商店>购物清单***\n" +
                "名称：可口可乐，数量：5瓶，单价：3.00(元)，小计：12.00(元)\n" +
                "名称：苹果，数量：2斤，单价：5.50(元)，小计：11.00(元)\n" +
                "----------------------\n" +
                "买三免一商品：\n" +
                "名称：可口可乐，数量：1瓶\n" +
                "----------------------\n" +
                "总计：23.00(元)\n" +
                "节省：3.00(元)\n" +
                "**********************\n",
                pos.getReceipt(cart).getText());

        cart = TestDataBuilder.getCartWithoutOfferGoods();
        assertEquals(
                "***<没钱赚商店>购物清单***\n" +
                "名称：苹果，数量：5斤，单价：5.50(元)，小计：27.50(元)\n" +
                "----------------------\n" +
                "总计：27.50(元)\n" +
                "**********************\n",
                pos.getReceipt(cart).getText());
    }
}