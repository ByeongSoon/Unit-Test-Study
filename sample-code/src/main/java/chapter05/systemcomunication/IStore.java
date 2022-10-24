package chapter05.systemcomunication;

public interface IStore {
    boolean hasEnoughInventory(Product product, int quantity);
    void removeInventory(Product product, int quantity) throws Exception;
    void addInventory(Product product, int quantity);
    int getInventory(Product product);
}
