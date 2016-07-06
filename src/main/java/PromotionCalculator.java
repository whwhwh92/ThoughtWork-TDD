public class PromotionCalculator {

    private PromotionProductsMaintainer promotionProductsMaintainer;

    public PromotionCalculator(PromotionProductsMaintainer promotionProductsMaintainer) {
        this.promotionProductsMaintainer = promotionProductsMaintainer;
    }

    public boolean checkIfProductCanBeOfferedADiscount(Product product, int quantity) {
        return promotionProductsMaintainer.contains(product) && quantity >= 3;
    }
}
