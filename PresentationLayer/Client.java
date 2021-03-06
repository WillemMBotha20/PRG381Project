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

            if (option.isEmpty()) {
                option = "8";
            }

            switch (Integer.parseInt(option)) {
                case 0:
                    System.out.print(clear);  
                    System.out.flush();
                    menu.AddClient();
                    break;
                case 1:
                    System.out.print(clear);  
                    System.out.flush();
                    menu.showClients();
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
                    scan.nextLine();                      
                    break;  
                case 6:
                    System.out.print(clear);  
                    System.out.flush();
                    menu.GoodbyeDisplay(); 
                    loopcontroll = false;
                    scan.close();  
                    break; 
                case 7:                    
                    // Testing the writer
                    menu.testMeth();
                    scan.nextLine();                
                    break;           
                case 8:
                    System.out.print(clear);  
                    System.out.flush();
                    menu.NoOption();     
                    scan.nextLine();                                                   
                break;
            }
        } 
           
    }
    
    
}