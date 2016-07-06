import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PromotionCalculatorTest {

    @Test
    public void should_not_be_received_a_discount_when_asking_for_promotion_given_products_is_not_in_discount_list() throws Exception {
        PromotionCalculator promotionCalculator = new PromotionCalculator();
        Product apple = new Product();

        boolean offeredDiscount = promotionCalculator.checkIfProductIsInDiscountList(apple);

        assertThat(offeredDiscount, is(false));
    }
}
