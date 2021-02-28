package DataAccesLayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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

    public void fileWriteBookings() {

    }

    public List<Events> fileReadBooking() throws FileNotFoundException {
        List<Events> returnBookings = new ArrayList<Events>();
        Scanner sc = new Scanner(fileLocal);

        while(sc.hasNextLine()){
            returnBookings.add(new Events());
        }

        sc.close();

        return returnBookings;
    }
}
