package DataAccesLayer;

import java.io.*;

import BusinessLogicLayer.BookingList;

public class FileHandeler {
    private BookingList booking;

    public FileHandeler(BookingList booking) {
        this.booking = booking;
    }

    public BookingList getBooking() {
        return this.booking;
    }

    public void setBooking(BookingList booking) {
        this.booking = booking;
    }

    public FileHandeler() {

    }

    public void serializationReadWrite(BookingList booking) {
       try {
            FileOutputStream fos = new FileOutputStream("Bookings.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(booking);
            oos.close();
            fos.close();
            System.out.println("Serialized Successful...");

       } catch (Exception e) {
           //TODO: handle exception
           System.out.println("Serialized Failed...");
       }
    }

    public BookingList serializationRead(){
        try {
            FileInputStream fos = new FileInputStream("Bookings.ser");
            ObjectInputStream ois = new ObjectInputStream(fos);
            BookingList bookSer = (BookingList) ois.readObject();
            ois.close();
            fos.close();
            System.out.println("Serialized Successful...");
            return bookSer;
       } catch (Exception e) {
           //TODO: handle exception
           System.out.println("De-Serialized Failed...");
           return null;
       }
    }
}
