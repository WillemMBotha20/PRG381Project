package BusinessLogicLayer;

// This class merges the clients and events to creating one booking which makes it easier to store...

public class BookingsCreated {
    
    private String bookingId;    
    private Events clientEvent;
    private ClientClass client;    

    public String getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Events getClientEvent() {
        return this.clientEvent;
    }

    public void setClientEvent(Events clientEvent) {
        this.clientEvent = clientEvent;
    }

    public ClientClass getClient() {
        return this.client;
    }

    public void setClient(ClientClass client) {
        this.client = client;
    }
   
    public BookingsCreated() {

    }

    public BookingsCreated(Events clientEvent, ClientClass client, String bookingId) {
        this.clientEvent = clientEvent;
        this.client = client;
        this.bookingId = bookingId;
    }    
}
