package chapter11;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private Customer _customer;
    private List<Product> _products;

    public String generateDescription() {
        PriceCalculator calc = new PriceCalculator();

        return "Customer name : " + _customer.name +
            "total number of products : " + _products.size() +
            "total price : " + calc.calculator(_customer, _products);
    }

//    public String generateDescription() {
//        return "Customer name : " + _customer.name +
//            "total number of products : " + _products.size() +
//            "total price : " + getPrice();
//    }

    private BigDecimal getPrice() {
        BigDecimal basePrice = BigDecimal.valueOf(1);
        BigDecimal discounts = BigDecimal.valueOf(1);
        BigDecimal taxes = BigDecimal.valueOf(1);

        return basePrice.subtract(discounts).add(taxes);
    }
}
