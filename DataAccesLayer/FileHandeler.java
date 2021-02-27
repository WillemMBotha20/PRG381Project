package DataAccesLayer;

import java.io.File;
import java.util.*;

import BusinessLogicLayer.Bookings;

public class FileHandeler {
    private File fileLocal;
    private Bookings dataStorage;   

    public FileHandeler(File fileLocal,Bookings dataStorage){
     this.fileLocal = fileLocal; 
     this.dataStorage = dataStorage;  
    }

    public FileHandeler(){

    }

    public void fileWriteBookings(){
        
    }

    public List<Bookings> fileReadBooking(){
        List<Bookings> returnBookings = new List<Bookings>();
        Scanner sc = new Scanner(fileLocal);

        while(sc.hasNextLine()){
            returnBookings.add(new Bookings());
        }

        return returnBookings;
    }
}
