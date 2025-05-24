package for_practice.polymorphism;

public class SMSNotification extends Notification {
    @Override
    public void send() {
        System.out.println("Sending SMS notification");
    }
}