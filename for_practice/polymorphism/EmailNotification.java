package for_practice.polymorphism;

public class EmailNotification extends Notification {
    @Override
    public void send() {
        System.out.println("Sending email notification");
    }
}