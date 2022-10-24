package chapter05.systemcomunication;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class Store implements IStore{

    private final Map<Product, Integer> _inventory = new HashMap<>();
    public int id;

    @Override
    public boolean hasEnoughInventory(Product product, int quantity) {
        return getInventory(product) >= quantity;
    }

    @Override
    public void removeInventory(Product product, int quantity) throws Exception {
        if (!hasEnoughInventory(product, quantity)) {
            throw new Exception("Not enough inventory");
        }

        int afterQuantity = _inventory.get(product) - quantity;
        _inventory.put(product,afterQuantity);
    }

    @Override
    public void addInventory(Product product, int quantity) {
        if (_inventory.containsKey(product)) {
            int afterQuantity = _inventory.get(product) + quantity;
            _inventory.put(product,afterQuantity);
        } else {
            _inventory.put(product, quantity);
        }
    }

    @Override
    public int getInventory(Product product) {
        boolean productExists = _inventory.isEmpty();
        return productExists ? 0 : _inventory.get(product);
    }

}
