import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class OnPromotionProductsListTest {
    @Test
    public void should_return_true_when_product_is_apple_given_it_is_on_promotion_list() throws Exception {
        OnPromotionProductsList promotionProductsList = new OnPromotionProductsList();
        Product apple = new Product("apple");

        boolean onPromotionList = promotionProductsList.contains(apple);

        assertThat(onPromotionList, is(true));
    }
}
