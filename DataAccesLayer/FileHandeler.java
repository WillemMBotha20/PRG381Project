package DataAccesLayer;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BusinessLogicLayer.*;
import PresentationLayer.Client;

// This class is going to be for serialization...

public class FileHandeler {
   
    private BookingList readingData;
    private BookingsCreated writingData;
    File tempfile = new File("bookings.txt");
    File clientfile = new File("Clients.txt");
    private Scanner scan;
    int id = 1;

    public FileHandeler() {
        
    }

//  Writing the object to a textfile.

    public void writeBooking(BookingsCreated booking) throws FileNotFoundException{  
        
        String line = booking.getClient().getCname() + "," + booking.getClient().getCsurname() + "," + booking.getClient().getCnumber() + "," + booking.getClientEvent().getVenueName() + "," + booking.getClientEvent().getEventDate().toString() + "," + booking.getClientEvent().getEventType() + "," + booking.getClientEvent().getVenueAddress() + "," + booking.getClientEvent().getVenueContact() + "," + booking.getClientEvent().AdultCount + "," + booking.getClientEvent().ChildCount + ",";
    
        for (String iterable_element : booking.getClientEvent().FoodSelection) {
            line += "#" +iterable_element;
        }

        for (String iterable_element : booking.getClientEvent().Decorations) {
            line += "&" +iterable_element;
        }

        try {
            FileWriter myWriter = new FileWriter(tempfile,true);
            myWriter.write(line + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }              
    }

// Reading from the textfile into an object.

    public BookingList readBooking() throws FileNotFoundException{

        scan = new Scanner(tempfile);
        String line = "";
        List<BookingsCreated> temporaryList = new ArrayList<BookingsCreated>();    
        while (scan.hasNextLine()) {
            line = scan.nextLine();
            List<String> food = new ArrayList<String>();
            List<String> decor = new ArrayList<String>();

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
            
            for (String ln : line.split("#")) {
                food.add(ln);
            }

            for (String ln : line.split("&")) {
                decor.add(ln);
            }

            Events event = new Events(line.split(",")[3],now,line.split(",")[5],line.split(",")[6],line.split(",")[7],Integer.parseInt(line.split(",")[8]),Integer.parseInt(line.split(",")[9]),food,decor);
            
            // public Events(String event,LocalDateTime date,String VenueName,String VenueAddress,String VenueContact,int Adults,int Children,List<String> food,List<String> decorations)
            
            temporaryList.add(new BookingsCreated(id,new ClientClass(line.split(",")[0],line.split(",")[1],line.split(",")[2]),event));

            id++;
        }

        BookingList book = new BookingList(temporaryList);

        return book;
    }

// Writing the clients to a textfile

    public void WriteClient(ClientClass clientC) throws IOException{
        String Client = clientC.getCname()+","+clientC.getCsurname()+","+clientC.getCnumber();
        FileWriter myFileWriter = new FileWriter(clientfile,true);
       try{
        myFileWriter.write(Client + "\n");
        myFileWriter.close();
        System.out.println("Successfully wrote to the file.");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }

// Reading from the client textfile

    public List<ClientClass> GetClients() throws FileNotFoundException{

        List<ClientClass> clientlist = new ArrayList<ClientClass>();	
		Scanner clientreader = new Scanner(clientfile);		
		while(clientreader.hasNextLine())
		{
			String[] line = clientreader.nextLine().split(",");
			
			clientlist.add(new ClientClass(line[0], line[1], line[2]));
		}

        return clientlist;        
    }
}
