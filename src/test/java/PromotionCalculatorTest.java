import com.sun.javafx.css.CalculatedValue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

public class PromotionCalculatorTest {

    private PromotionCalculator promotionCalculator;
    @Mock
    private PromotionProductsMaintainer promotionProductsMaintainer;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        promotionCalculator = new PromotionCalculator(promotionProductsMaintainer);
    }

    @Test
    public void should_not_be_received_a_discount_when_asking_for_promotion_given_products_is_on_discount_list_but_quantity_is_less_than_3() throws Exception {
        Product apple = new Product("apple");
        given(promotionProductsMaintainer.contains(apple)).willReturn(true);

        boolean shouldBeOfferedDiscount = promotionCalculator.checkIfProductCanBeOfferedADiscount(apple, 1);

        assertThat(shouldBeOfferedDiscount, is(false));
    }

    @Test
    public void should_be_received_a_discount_when_asking_for_promotion_given_products_is_on_discount_list_and_quantity_is_more_than_3() throws Exception {
        Product apple = new Product("apple");
        given(promotionProductsMaintainer.contains(apple)).willReturn(true);

        boolean shouldBeOfferedDiscount = promotionCalculator.checkIfProductCanBeOfferedADiscount(apple, 3);

        assertThat(shouldBeOfferedDiscount, is(true));
    }

    @Test
    public void should_not_be_received_a_discount_when_asking_for_promotion_given_product_is_not_on_discount_list() throws Exception {
        Product cokacola = new Product("cokacola");
        given(promotionProductsMaintainer.contains(cokacola)).willReturn(false);

        boolean shouldBeOfferedDiscount = promotionCalculator.checkIfProductCanBeOfferedADiscount(cokacola, 3);

        assertThat(shouldBeOfferedDiscount, is(false));
    }

    @Test
    public void should_return_4_when_buying_7_apples_each_with_price_2_and_two_get_offered_free_discount() throws Exception {
        Product apple = new Product("apple");
        apple.setPrice(2.00);

        double discount = promotionCalculator.calculateDiscount(apple, 7);

        assertThat(discount, is(4.00));
    }

    @Test
    public void should_return_10_when_buying_3_apples_each_with_price_10_and_three_get_offered_free_discount() throws Exception {
        Product apple = new Product("apple");
        apple.setPrice(10.00);

        double discount = promotionCalculator.calculateDiscount(apple, 3);

        assertThat(discount, is(10.00));
    }

    @Test
    public void should_return_0_when_buying_less_than_3_apples() throws Exception {
        Product apple = new Product("apple");

        double discount = promotionCalculator.calculateDiscount(apple, 2);

        assertThat(discount, is(0.0));
    }
}