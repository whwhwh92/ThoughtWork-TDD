import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.MockitoAnnotations.initMocks;

public class OnPromotionProductsListTest {

    private OnPromotionProductsList onPromotionProductsList;
    private List<PromotionProduct> promotionProducts;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        promotionProducts = new ArrayList<>();
        PromotionProduct apple = new PromotionProduct();
        apple.setProductName("apple");
        promotionProducts.add(apple);
        onPromotionProductsList = new OnPromotionProductsList(promotionProducts);
    }

    @Test
    public void should_return_true_when_product_is_apple_given_it_is_on_promotion_list() throws Exception {
        Product apple = new Product("apple");

        boolean onPromotionList = onPromotionProductsList.contains(apple);

        assertThat(onPromotionList, is(true));
    }

    @Test
    public void should_return_false_when_product_is_cokacola_given_it_is_not_on_promotion_list() throws Exception {
        Product hammer = new Product("hammer");

        boolean onPromotionList = onPromotionProductsList.contains(hammer);

        assertThat(onPromotionList, is(false));
    }
}
