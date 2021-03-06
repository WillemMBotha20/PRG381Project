package PresentationLayer;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BusinessLogicLayer.BookingsCreated;
import BusinessLogicLayer.ClientClass;
import BusinessLogicLayer.Events;
import BusinessLogicLayer.Menu;
import DataAccesLayer.FileHandeler;

/**
 * Client This Is Just Temporary
 */
public class Client {
    
    /**
     *
     */
    private static final String clear = "\033[H\033[2J";

    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner scan = new Scanner(System.in);        
        boolean loopcontroll = true;    
        Menu menu = new Menu();

        // Creating the loop that 

        while(loopcontroll == true) {           
            menu.MainMenuDisplay();
            String option = scan.nextLine();
            switch (Integer.parseInt(option)) {
                case 0:
                    System.out.print(clear);  
                    System.out.flush();

                    break;
                case 1:
                    System.out.print(clear);  
                    System.out.flush();

                    break;
                case 2:
                    System.out.print(clear);  
                    System.out.flush();
                    menu.AddEventPrint();
                    break;
                case 3:
                    System.out.print(clear);  
                    System.out.flush();
                    menu.ViewEventsPrint();
                    break;
                case 4:
                    System.out.print(clear);  
                    System.out.flush();  
                    menu.AllBookingsMenuDisplay();  
                    scan.nextLine();                     
                    break;
                case 5:
                    System.out.print(clear);  
                    System.out.flush();  
                    menu.EditBookingsDisplay();
                    
                    break;  
                case 6:

                // Testing the writer

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

                    scan.nextLine(); 
                    break; 
                case 7:
                    System.out.print(clear);  
                    System.out.flush();
                    menu.GoodbyeDisplay(); 
                    loopcontroll = false;                 
                    break;            
            }
        }    
    }    
}