package chapter06.state;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Product> _products = new ArrayList<>();
    public final List<Product> products = _products;

    public void addProduct(Product product) {
        _products.add(product);
    }

}
