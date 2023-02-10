package chapter11;

public class Customer {

    private CustomerStatus _status = CustomerStatus.REGULAR; // 비공개 상태

    public void promote() {
        _status = CustomerStatus.PREFERRED;
    }

    public double getDiscount() {
        return _status == CustomerStatus.PREFERRED ? 0.05 : 0;
    }

}
