package strategy;

public class StrategyDemo {
    public static void main(String[] args) {
        PaymentStrategy paymentStrategy = new PaymentStrategy();
        // Pay with Credit Card
        paymentStrategy.setPayment(new CreditCardPayment());
        paymentStrategy.payAmount(2000);

        // Switch to PayPal
        paymentStrategy.setPayment(new PayPalPayment());
        paymentStrategy.payAmount(1500);

        // Switch to Google Pay
        paymentStrategy.setPayment(new GooglePayPayment());
        paymentStrategy.payAmount(1000);
    }
}
