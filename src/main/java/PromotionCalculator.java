import domain.Product;
import exception.ProductNotApplicableForPromotionException;

public class PromotionCalculator {

    private PromotionProductsMaintainer promotionProductsMaintainer;

    public PromotionCalculator(PromotionProductsMaintainer promotionProductsMaintainer) {
        this.promotionProductsMaintainer = promotionProductsMaintainer;
    }

    public boolean checkIfProductCanBeOfferedADiscount(Product product, int quantity) {
        return promotionProductsMaintainer.contains(product) && quantity >= 3;
    }

    public double calculateDiscount(Product product, int quantity) throws ProductNotApplicableForPromotionException {
        if (!promotionProductsMaintainer.contains(product)) throw new ProductNotApplicableForPromotionException();
        if (quantity < 3) return 0.0;

        return product.getPrice() * getNumberOfProductsApplicableForPromotion(quantity);
    }

    private int getNumberOfProductsApplicableForPromotion(int quantity) {
        return quantity / 3;
    }
}
