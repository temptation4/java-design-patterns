package observer;

public class ObserverDemo {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        // Observers (subscribers)
        Observer emailUser = new EmailSubscriber("john@example.com");
        Observer smsUser = new SmsSubscriber("9876543210");

        // Attach observers
        service.addObserver(emailUser);
        service.addObserver(smsUser);

        // Notify all subscribers
        service.notifyObservers("New product launched!");

        // Remove one subscriber
        service.removeObserver(emailUser);

        // Notify again
        service.notifyObservers("Discount sale starting tomorrow!");
    }
}


