package chapter05.systemcomunication;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerController {

    private CustomerRepository customerRepository;
    private ProductRepository productRepository;
    private Store mainStore;
    private IEmailGateway emailGateway;

    public CustomerController(IEmailGateway emailGateway) {
        this.emailGateway = emailGateway;
        this.customerRepository = new CustomerRepository();
        this.productRepository = new ProductRepository();
        this.mainStore = new Store();
    }

    public boolean purchase(int customerId, int productId, int quantity) throws Exception {
        Customer customer = customerRepository.getById(customerId);
        Product product = productRepository.getById(productId);

        /*
        * 스토어가 비어있으므로 임시조치
        * customerEmail, ProductName 임시조치
         */
        mainStore.addInventory(product, 5);
        customer.setEmail("customer@email.com");
        product.setName("Shampoo");

        boolean isSuccess = customer.purchase(mainStore, product, quantity);

        if (isSuccess) {
            emailGateway.sendReceipt(customer.email, product.name, quantity);
        }

        return isSuccess;
    }

}
