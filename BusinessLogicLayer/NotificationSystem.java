package BusinessLogicLayer;

// The idea is for this class is to be able to send notifactions to the correct users...
// This include emails or message via a phone number...

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
