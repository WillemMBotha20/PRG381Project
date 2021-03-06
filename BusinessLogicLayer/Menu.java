package BusinessLogicLayer;

import java.util.ArrayList;

import DataAccesLayer.FileHandeler;

public class Menu {
    
    FileHandeler filehand = new FileHandeler();

    public void MainMenuDisplay(){

        System.out.printf("Please select an option:%n0. Add new client%n1. view clients%n2. Add event%n3. View all events%n4. View all bookings%n5. Edit bookings%n");
    }

    public void AllBookingsMenuDisplay(){
        System.out.printf("Displaying All Bookings: %n");
        BookingList book = filehand.serializationRead();
        for (BookingsCreated variable : book.getBookingList()){
            System.out.printf("%s %s %s",variable.getClient().getCname(),variable.getClient().getCsurname(),variable.getClient().getCnumber());
        }
    }

    public void EditBookingsDisplay(){
        System.out.printf("Edit Bookings:");
    }

    public void GoodbyeDisplay(){
        System.out.printf("Goodbye!");
    }

    public static void AddEventPrint()
    {
        System.out.println("Please choose one of the following: ");
        System.out.println("1. Add Client");
        System.out.println("2. Choose existing Client ");
        System.out.println("3. Return ");
        System.out.println("3. Exit ");  

    }
}
