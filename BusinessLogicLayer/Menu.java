package BusinessLogicLayer;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import DataAccesLayer.FileHandeler;

public class Menu {
    
    /**
     *
     */
    private static final String ENTER_INFO_N = "Enter Info:%n";
    FileHandeler filehand = new FileHandeler();

    public void MainMenuDisplay(){

        System.out.printf("Please select an option:%n0. Add new client%n1. view clients%n2. Add event%n3. View all events%n4. View all bookings%n5. Edit bookings%n");
    }

// Displaying all the bookings info

    public void AllBookingsMenuDisplay() throws FileNotFoundException{
        System.out.printf("Displaying All Bookings: %n");        
        BookingList book = filehand.readBooking();
        for (BookingsCreated variable : book.getBookingList()){
            System.out.printf("%s %s %s %s %s\n",variable.getClient().getCname(),variable.getClient().getCsurname(),variable.getClient().getCnumber(),variable.getClientEvent().VenueName,variable.getClientEvent().getVenueAddress());
        }
    }

// Editing the client from a booking

    public void EditBookingsDisplay() throws FileNotFoundException{
        System.out.printf("Edit Bookings:%nWho is the client?%n");  
        Scanner sc = new Scanner(System.in);
        String cl = sc.nextLine();

        FileHandeler hand = new FileHandeler();
        BookingList book = new BookingList();
        BookingsCreated tempbook = new BookingsCreated();
        Boolean found = false;     
        String option2 = "";

        book = hand.readBooking();

        for (BookingsCreated iterable_element : book.getBookingList()) {
            if (iterable_element.getClient().getCname().equals(cl)) {
                tempbook = iterable_element;
                found = true;
                break;
            } 
        }

        String option;

        if (found.equals(false)) {
            System.out.println("Client not found!");
            option = "2";
        }else{
            System.out.printf("What do you want to change?%n1. Client%n");
            option = sc.nextLine();
        }     

        switch (Integer.parseInt(option)) {
            case 1:
                System.out.printf("What to change about the client?%n1. Name%n2. Surnamet%n3. Number%n4. Nothing%n");   
                option2 = sc.nextLine();
                switch (Integer.parseInt(option2)) {
                    case 1:
                        System.out.printf(ENTER_INFO_N);
                        tempbook.getClient().setCname(sc.nextLine());
                        break;

                    case 2:
                        System.out.printf(ENTER_INFO_N);
                        tempbook.getClient().setCname(sc.nextLine());
                        break;
                    case 3:
                        System.out.printf(ENTER_INFO_N);
                        tempbook.getClient().setCname(sc.nextLine());
                        break;
                    case 4:
                        System.out.println("Changed nothing!");
                        break;  
                }

                FileHandeler filehnd = new FileHandeler();
                filehnd.writeBooking(tempbook);
                break;        
            case 2:
                System.out.print("Changed Nothing!");
                break;
        }       
    }

    public void GoodbyeDisplay(){
        System.out.printf("Goodbye!");
    }

    public void AddEventPrint()
    {
        System.out.println("Please choose one of the following: ");
        System.out.println("1. Add Client");
        System.out.println("2. Choose existing Client ");
        System.out.println("3. Return");
        System.out.println("4. Exit ");

    }

    public void ChooseClientPrint()
    {
        System.out.println("Choose one of the following clients:");
    }

    public void ViewEventsPrint()
    {
        System.out.println("Display all Event:");
    }

// If no option is chosen the user should be takem back to the main menu

    public void NoOption(){
        System.out.printf("You did not select an option!%nPlease select one!");
    }


    
}
