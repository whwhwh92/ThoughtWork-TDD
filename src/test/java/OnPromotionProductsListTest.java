import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class OnPromotionProductsListTest {

    private OnPromotionProductsList onPromotionProductsList;

    @Before
    public void setUp() throws Exception {
        onPromotionProductsList = new OnPromotionProductsList();
    }

    @Test
    public void should_return_true_when_product_is_apple_given_it_is_on_promotion_list() throws Exception {
        Product apple = new Product("apple");

        boolean onPromotionList = onPromotionProductsList.contains(apple);

        assertThat(onPromotionList, is(true));
    }

    @Test
    public void should_return_false_when_product_is_cokacola_given_it_is_not_on_promotion_list() throws Exception {
        Product cokacola = new Product("cokacola");

        boolean onPromotionList = onPromotionProductsList.contains(cokacola);

        assertThat(onPromotionList, is(false));
    }
}
