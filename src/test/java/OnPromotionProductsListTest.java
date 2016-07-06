import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.MockitoAnnotations.initMocks;

public class OnPromotionProductsListTest {

    private OnPromotionProductsList onPromotionProductsList;
    private List<PromotionProduct> promotionProducts = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }
    @Test
    public void should_return_true_when_product_is_apple_given_it_is_on_promotion_list() throws Exception {
        Product apple = new Product("apple");
        Product cokacola = new Product("cokacola");

        addProductsToPromotionList("apple", "cokacola");
        onPromotionProductsList = new OnPromotionProductsList(promotionProducts);

        boolean appleOnPromotion = onPromotionProductsList.contains(apple);
        boolean cokacolaOnPromotion = onPromotionProductsList.contains(cokacola);

        assertThat(appleOnPromotion, is(true));
        assertThat(cokacolaOnPromotion, is(true));
    }

    @Test
    public void should_return_false_when_product_is_cokacola_given_it_is_not_on_promotion_list() throws Exception {
        Product hammer = new Product("hammer");

        addProductsToPromotionList("apple");
        onPromotionProductsList = new OnPromotionProductsList(promotionProducts);

        boolean onPromotionList = onPromotionProductsList.contains(hammer);

        assertThat(onPromotionList, is(false));
    }

    private void addProductsToPromotionList(String... productNames) {
        for (String productName : productNames) {
            PromotionProduct product = new PromotionProduct();
            product.setProductName(productName);
            promotionProducts.add(product);
        }
    }

}
