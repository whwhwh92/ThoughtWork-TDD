public class PromotionCalculator {
    public boolean checkIfProductCanBeOfferedADiscount(Product product, int quantity) {
        return quantity >= 3 ? true : false;
    }
}
