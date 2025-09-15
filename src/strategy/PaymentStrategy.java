package strategy;

public class PaymentStrategy {
    private  Payment payment;
     public void setPayment(Payment payment) {
    this.payment = payment;
    }

    public void payAmount(int amount) {
        if (payment == null) {
            throw new IllegalStateException("Payment strategy not set");
        }
        payment.pay(amount);
    }
}
