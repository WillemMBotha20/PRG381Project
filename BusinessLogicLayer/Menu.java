package BusinessLogicLayer;

import java.io.FileNotFoundException;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
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

        System.out.printf("Please select an option:%n0. Add new client%n1. view clients%n2. Add event%n3. View all events%n4. View all bookings%n5. Edit bookings%n6. Exit%n");
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

// Choosing client method

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

// Adding an event, this initiates where the client is chosen the event is created, questions asked and then the booking made.

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

//Printing all the events

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

// If no option is chosen the user should be takem back to the main menu

    public void NoOption(){
        System.out.printf("You did not select an option!%nPlease select one!");
    }

// Adding a client

    public void AddClient(){
        Scanner ClientInput = new Scanner(System.in);
        
        System.out.println("Enter Client's name");
        String name =ClientInput.nextLine();
        ClientClass ClientInfo = new ClientClass();
        ClientInfo.setCname(name);
        System.out.println("Enter Client's Surname");
        String surname = ClientInput.nextLine();
        ClientInfo.setCsurname(surname);
        System.out.println("Enter Client's Telephone number");
        String cellnumber = ClientInput.nextLine();
        ClientInfo.setCnumber(cellnumber);
    }

// Test Method

    public void testMeth() throws FileNotFoundException{
        List<String> tester1 = new ArrayList<String>();
        List<String> tester2 = new ArrayList<String>();
        tester1.add("1");
        tester2.add("2");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse("2021-01-18 08:08", formatter);

        ClientClass cl = new ClientClass("Willem","Botha","000003213");
        Events ev = new Events("Birth Party",dateTime,"Black","Red","John",10,5,tester1,tester2);
                    
        BookingsCreated temp = new BookingsCreated(0,cl,ev);

        FileHandeler hand = new FileHandeler();

        hand.writeBooking(temp);        
    } 

// Displaying all clients

    public void showClients() throws FileNotFoundException{
        System.out.println("Showing all the clients:%n");
        for (ClientClass iterable_element : filehand.GetClients()) {
            System.out.printf("Name: %s%nSurname: s%%nCell Number: %s%n",iterable_element.getCname(),iterable_element.getCsurname(),iterable_element.getCnumber());
        }
    }   
}
