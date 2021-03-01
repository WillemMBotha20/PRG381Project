package BusinessLogicLayer;

public class NotificationSystem {

    private BookingsCreated booking;

    public NotificationSystem() {
    }

    public NotificationSystem(BookingsCreated booking) {
        this.booking = booking;
    }
    
    public void SendNotification(){
        // This will be the method to send a notifaction to the correct users...
    }     
}
