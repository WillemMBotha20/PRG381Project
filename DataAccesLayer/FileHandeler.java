package DataAccesLayer;

import java.io.*;
import java.util.*;

import BusinessLogicLayer.BookinsgCreated;
import BusinessLogicLayer.Events;

public class FileHandeler {
    private File fileLocal;
    private Events dataStorage;    

    public FileHandeler(File fileLocal, Events dataStorage) {
        this.fileLocal = fileLocal;
        this.dataStorage = dataStorage;
    }

    public FileHandeler() {

    }

    public void fileWriteBookings(BookinsgCreated booking) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocal, true));
        String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", booking.getClient().getCname(),booking.getClient().getCsurname(),booking.getClient().getCnumber(),booking.getClientEvent().getEventType(),booking.getClientEvent().getEventDate(),booking.getClientEvent().getVenueName(),booking.getClientEvent().getVenueAddress(),booking.getClientEvent().getVenueContact(),booking.getClientEvent().getAdultCount(),booking.getClientEvent().getChildCount());
        writer.append(line);
        writer.close();
    }

    public List<BookinsgCreated> fileReadBooking() throws FileNotFoundException {
        List<BookinsgCreated> returnBookings = new ArrayList<BookinsgCreated>();
        Scanner sc = new Scanner(fileLocal);

        while(sc.hasNextLine()){
            returnBookings.add(new BookinsgCreated());
        }

        sc.close();

        return returnBookings;
    }
}
