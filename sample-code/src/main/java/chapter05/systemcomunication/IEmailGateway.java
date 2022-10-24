package chapter05.systemcomunication;

public interface IEmailGateway {
    void sendReceipt(String email, String productName, int quantity);
}
