package DataAccesLayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import BusinessLogicLayer.Bookings;

public class FileHandeler {
    private File fileLocal;
    private Bookings dataStorage;

    public FileHandeler(File fileLocal, Bookings dataStorage) {
        this.fileLocal = fileLocal;
        this.dataStorage = dataStorage;
    }

    public FileHandeler() {
    }

    public void fileWriteBookings() {

    }

    public List<Bookings> fileReadBooking() throws FileNotFoundException {
        List<Bookings> returnBookings = new ArrayList<Bookings>();
        Scanner sc = new Scanner(fileLocal);

        while(sc.hasNextLine()){
            returnBookings.add(new Bookings());
        }

        sc.close();

        return returnBookings;
    }
}
