public class PromotionCalculator {
    public boolean checkIfProductCanBeOfferedADiscount(Product product, int quantity) {
        if (product.getName().equals("cokacola")) return false;
        return quantity >= 3;
    }
}
