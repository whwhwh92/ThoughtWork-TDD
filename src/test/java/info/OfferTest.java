package info;

import org.junit.Test;
import util.TestDataBuilder;

import static org.junit.Assert.*;

/**
 * Created by Sora on 2016/7/11.
 */
public class OfferTest {

    @Test
    public void should_tell_whether_goods_in_offer()
            throws Exception {
        Offer offer = TestDataBuilder.getOffer();

        assertTrue(offer.check(
                TestDataBuilder.getOfferGoods()));
        assertFalse(offer.check(
                TestDataBuilder.getNonOfferGoods()));
    }

    @Test
    public void should_return_right_discount_for_items()
            throws Exception {
        Offer offer = TestDataBuilder.getOffer();

        Item offerItem = new Item(
                TestDataBuilder.getOfferGoods());
        Item normItem = new Item(
                TestDataBuilder.getNonOfferGoods());

        offerItem.add(2);
        assertEquals(0.00f,
                offer.calcDiscount(offerItem), 0.001f);

        offerItem.add(1);
        assertEquals(3.00f,
                offer.calcDiscount(offerItem), 0.001f);

        normItem.add(5);
        assertEquals(0.00f,
                offer.calcDiscount(normItem), 0.001f);
    }
}