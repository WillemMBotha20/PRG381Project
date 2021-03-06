package BusinessLogicLayer;

import java.io.FileNotFoundException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import DataAccesLayer.FileHandeler;

public class Menu {
    
    FileHandeler filehand = new FileHandeler();

    public void MainMenuDisplay(){

        System.out.printf("Please select an option:%n0. Add new client%n1. view clients%n2. Add event%n3. View all events%n4. View all bookings%n5. Edit bookings%n");
    }

    public void AllBookingsMenuDisplay() throws FileNotFoundException{
        System.out.printf("Displaying All Bookings: %n");        
        BookingList book = filehand.readBooking();
        for (BookingsCreated variable : book.getBookingList()){
            System.out.printf("%s %s %s %s %s\n",variable.getClient().getCname(),variable.getClient().getCsurname(),variable.getClient().getCnumber(),variable.getClientEvent().VenueName,variable.getClientEvent().getVenueAddress());
        }
    }

    public void EditBookingsDisplay(){
        System.out.printf("Edit Bookings:");
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

    public void ChooseClientPrint() throws FileNotFoundException
    {
        System.out.println("Choose one of the following clients: %n");
        Scanner sc = new Scanner(System.in);
        int option = 0;
        int i = 1;
        BookingList book = filehand.readBooking();
        for (BookingsCreated variable : book.getBookingList()){
            System.out.printf("%i. %s %s %s %s %s\n",i,variable.getClient().getCname(),variable.getClient().getCsurname(),variable.getClient().getCnumber());
            i++;
        }
        option = sc.nextInt();
        BookingsCreated Booking = book.getBookingList().get(option);
        ClientClass Client = Booking.getClient();
        sc.close();
        AddEvent(Client);
    }

    public void AddEvent(ClientClass client)
    {
        String input = "";
        int count;
        String Date;
        String Time;
        String Datetime;
        boolean exit = false;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        Scanner sc = new Scanner(System.in);
        Events Eventinfo = new Events();
        
        System.out.println("What type of event is it?");
        input = sc.nextLine();
        Eventinfo.setEventType(input);
        
        System.out.println("On what date will it take place?");
        Date = sc.nextLine();
        System.out.println("What time will it take place?");
        Time = sc.nextLine();
        Datetime = Date +" "+Time;
        Eventinfo.setEventDate(LocalDateTime.parse(Datetime, dtf));
        
        System.out.println("What is the name of the venue?");
        input = sc.nextLine();
        Eventinfo.setVenueName(input);

        System.out.println("What is the address of the venue?");
        input = sc.nextLine();
        Eventinfo.setVenueAddress(input);

        System.out.println("What is the contact number of the venue?");
        input = sc.nextLine();
        Eventinfo.setVenueContact(input);

        System.out.println("Will there be children at the event? Y OR N");
        input = sc.nextLine();

        if (input.toUpperCase() == "Y") 
        {

            System.out.println("How many adults will be attending?");
            count = sc.nextInt();
            Eventinfo.setAdultCount(count);

            System.out.println("How many children will be attending?");
            count = sc.nextInt();
            Eventinfo.setChildCount(count);
            
        } else 
        {
            System.out.println("How many people will be attending?");
            count = sc.nextInt();
            Eventinfo.setAdultCount(count);
            Eventinfo.setChildCount(0);
        }

        System.out.println("Please enter items on the food menu:");
        count = 1;
        List<String> food = new ArrayList<>();
        while (exit==false) 
        {
            System.out.printf("Item %i: %n",count);
            food.add(sc.nextLine());
            System.out.println("Would you like to add another item? Y OR N");
            if (sc.nextLine().toUpperCase() == "N") {
                exit = false;
            }
            count++;
        }
        Eventinfo.setFood(food);

        System.out.println("Any decorations? Y OR N");
        List<String> Deco = new ArrayList<>();
        if (sc.nextLine().toUpperCase() == "Y") {
            
            System.out.println("What is the theme season?");
            Deco.add(sc.nextLine());
            System.out.println("What is the theme color?");
            Deco.add(sc.nextLine());
            System.out.println("What props would you like?");
             while (exit==false) 
            {
                System.out.printf("Item %i: %n",count);
                Deco.add(sc.nextLine());
                System.out.println("Would you like to add another item? Y OR N");
                if (sc.nextLine().toUpperCase() == "N") {
                    exit = false;
                }
                count++;
            }       
        } 
        else 
        {
            Deco.add("No Decorations");
        }

        Eventinfo.setDecorations(Deco);
    }

    public void ViewEventsPrint() throws FileNotFoundException
    {
        System.out.println("Display all Event:");
        BookingList book = filehand.readBooking();
        for (BookingsCreated variable : book.getBookingList()) {
            System.out.printf("Type:%s %n Date:%s %n Venue:%s %n Address:%s %n Contact:%s %n Adults:%s %n Children:%s %n",variable.getClientEvent().getEventType(),variable.getClientEvent().getVenueName(),variable.getClientEvent().getVenueAddress(),variable.getClientEvent().getVenueContact(),variable.getClientEvent().getAdultCount(),variable.getClientEvent().getChildCount());
            System.out.println("Food Menu: \n");
            for (String item : variable.getClientEvent().getFood()) {
                System.out.println(item);
            }
            System.out.println("Food Menu: \n");
            for (String item : variable.getClientEvent().getDecorations()) {
                System.out.println(item);
            }
        }
    }
}
