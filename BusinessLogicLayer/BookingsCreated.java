package BusinessLogicLayer;

// This class merges the clients and events to creating one booking which makes it easier to store...

public class BookingsCreated {
    
    private int bookingId;    
    private Events clientEvent;
    private ClientClass client;    

    public int getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(int bookingId) {
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

    public BookingsCreated(int bookingId, ClientClass client, Events clientEvent) {
        this.clientEvent = clientEvent;
        this.client = client;
        this.bookingId = bookingId;
    }    
}
