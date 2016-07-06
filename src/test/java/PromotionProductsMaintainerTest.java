import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.MockitoAnnotations.initMocks;

public class PromotionProductsMaintainerTest {

    private PromotionProductsMaintainer promotionProductsMaintainer;
    private List<PromotionProduct> promotionProducts = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }
    @Test
    public void should_return_true_when_product_is_apple_and_cokacola_given_they_are_on_promotion_list() throws
            Exception {
        Product apple = new Product("apple");
        Product cokacola = new Product("cokacola");

        addProductsToPromotionList("apple", "cokacola");
        promotionProductsMaintainer = new PromotionProductsMaintainer(promotionProducts);

        boolean appleOnPromotion = promotionProductsMaintainer.contains(apple);
        boolean cokacolaOnPromotion = promotionProductsMaintainer.contains(cokacola);

        assertThat(appleOnPromotion, is(true));
        assertThat(cokacolaOnPromotion, is(true));
    }

    @Test
    public void should_return_false_when_product_is_hammer_given_it_is_not_on_promotion_list() throws Exception {
        Product hammer = new Product("hammer");

        addProductsToPromotionList("apple");
        promotionProductsMaintainer = new PromotionProductsMaintainer(promotionProducts);

        boolean onPromotionList = promotionProductsMaintainer.contains(hammer);

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
