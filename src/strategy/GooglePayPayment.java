package strategy;

public class GooglePayPayment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Google Pay.");
    }
}
