package factory;

public class PaymentDemo {

    public static void main(String[] args) {
        PaymentFactory factory = new PaymentFactory();

        Payment p1 = factory.getPaymentMethod("creditcard");
        p1.pay(2500);

        Payment p2 = factory.getPaymentMethod("paypal");
        p2.pay(1200);

        Payment p3 = factory.getPaymentMethod("googlepay");
        p3.pay(800);
    }
}
