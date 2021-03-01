package BusinessLogicLayer;

public class BookingsCreated {
    
    private Events clientEvent;
    private ClientClass client;

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


    public BookingsCreated(Events clientEvent, ClientClass client) {
        this.clientEvent = clientEvent;
        this.client = client;
    }    
}
