package factory;

class PaymentFactory {
    public Payment getPaymentMethod(String type) {
        switch (type.toLowerCase()) {
            case "creditcard":
                return new CreditCardPayment();
            case "paypal":
                return new PayPalPayment();
            case "googlepay":
                return new GooglePayPayment();
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }
}
