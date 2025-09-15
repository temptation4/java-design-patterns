package factory;

public class GooglePayPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Google Pay.");
    }
}
