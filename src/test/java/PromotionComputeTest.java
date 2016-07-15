/**
 * Created by Administrator on 2016/7/12 0012.
 */
public class PromotionComputeTest {

    @Test
    public  void should_discount_when_buy_beyond_three_in_promotion_produce() throws Exception{
        Product watermelon = new Product("watermelon");
        boolean shouldBeOfferedDiscount = PromotionCompute.checkIfProductCanBeOfferedADiscount(watermelon,3);
        assertThat(shouldBeOfferedDiscount,is(true));
    }
}
