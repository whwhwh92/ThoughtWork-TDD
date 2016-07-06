import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PromotionCalculatorTest {

    private PromotionCalculator promotionCalculator;

    @Before
    public void setUp() throws Exception {
        promotionCalculator = new PromotionCalculator();
    }

    @Test
    public void should_not_be_received_a_discount_when_asking_for_promotion_given_products_is_on_discount_list_but_quantity_is_less_than_3() throws Exception {
        Product apple = new Product("apple");

        boolean shouldBeOfferedDiscount = promotionCalculator.checkIfProductCanBeOfferedADiscount(apple, 1);

        assertThat(shouldBeOfferedDiscount, is(false));
    }

    @Test
    public void should_be_received_a_discount_when_asking_for_promotion_given_products_is_on_discount_list_and_quantity_is_more_than_3() throws Exception {
        Product apple = new Product("apple");

        boolean shouldBeOfferedDiscount = promotionCalculator.checkIfProductCanBeOfferedADiscount(apple, 3);

        assertThat(shouldBeOfferedDiscount, is(true));
    }

    @Test
    public void should_not_be_received_a_discount_when_asking_for_promotion_given_product_is_not_on_discount_list() throws Exception {
        Product cokacola = new Product("cokacola");

        boolean shouldBeOfferedDiscount = promotionCalculator.checkIfProductCanBeOfferedADiscount(cokacola, 3);

        assertThat(shouldBeOfferedDiscount, is(false));
    }
}
