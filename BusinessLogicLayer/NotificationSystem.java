package BusinessLogicLayer;

public class NotificationSystem {

    private BookinsgCreated booking;

    public NotificationSystem() {
    }

    public NotificationSystem(BookinsgCreated booking) {
        this.booking = booking;
    }
    
    public void SendNotification(){
        // This will be the method to send a notifaction to the correct users...
    }     
}
