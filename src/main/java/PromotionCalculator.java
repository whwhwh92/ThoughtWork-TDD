public class PromotionCalculator {

    private PromotionProductsMaintainer promotionProductsMaintainer;

    public PromotionCalculator(PromotionProductsMaintainer promotionProductsMaintainer) {
        this.promotionProductsMaintainer = promotionProductsMaintainer;
    }

    public boolean checkIfProductCanBeOfferedADiscount(Product product, int quantity) {
        return promotionProductsMaintainer.contains(product) && quantity >= 3;
    }

    public double calculateDiscount(Product product, int quantity) {
        int numberOfProductsOfferedFreeDiscount = quantity / 3;

        return 2 * numberOfProductsOfferedFreeDiscount;
    }
}
