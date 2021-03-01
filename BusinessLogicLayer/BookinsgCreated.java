package BusinessLogicLayer;

public class BookinsgCreated {
    
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
   

    public BookinsgCreated() {
    }


    public BookinsgCreated(Events clientEvent, ClientClass client) {
        this.clientEvent = clientEvent;
        this.client = client;
    }    
}
