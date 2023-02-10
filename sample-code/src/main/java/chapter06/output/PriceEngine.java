package chapter06.output;

public class PriceEngine {

    public double calculateDiscount(Product[] product) {
        double discount = product.length * 0.01;
        return Math.min(discount, 0.2);
    }

}
