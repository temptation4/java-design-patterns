package observer;

class SmsSubscriber implements Observer {
    private String phone;

    public SmsSubscriber(String phone) {
        this.phone = phone;
    }

    @Override
    public void update(String message) {
        System.out.println("SMS sent to " + phone + ": " + message);
    }
}

