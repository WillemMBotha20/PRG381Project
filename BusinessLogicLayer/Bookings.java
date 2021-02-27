package BusinessLogicLayer;

<<<<<<< HEAD
import java.time.LocalDate;
import java.util.List;

/**
 * Bookings
 */
=======
>>>>>>> e6d7a7cbef5f375e39574227a4d30d56290c9dbc
public class Bookings {
    
    public Bookings(){
        
    }

<<<<<<< HEAD
    public String EventType;
    public LocalDate EventDate;
    public String[][] EventVenue = new String[1][2];    //To capture address and contact number
    public int[][] PeopleCount = new int[1][2];         //To capture adults and children counts
    public String[][] Food = new String[1][4];          //To capture adult and kids meals and drinks
    public List<String> Decorations;
    

    public String getEventType()
    {
        return EventType;
    };

    public void setEventType(String EventType)
    {
        this.EventType = EventType;
    };

    public LocalDate getEventDate()
    {
        return EventDate;
    };

    public void setEventDate(LocalDate EventDate)
    {
        this.EventDate = EventDate;
    };

    public String[][] getEventVenue()
    {
        return EventVenue;
    };

    public void setEventVenue(String[][] EventVenue)
    {
        this.EventVenue = EventVenue;
    };

    public int[][] getPeopleCount()
    {
        return PeopleCount;
    };

    public void setPeopleCount(int[][] PeopleCount)
    {
        this.PeopleCount = PeopleCount;
    };

    public String[][] getFood()
    {
        return Food;
    };

    public void setFood(String[][] Food)
    {
        this.Food = Food;
    };

    public List<String> getDecorations()
    {
        return Decorations;
    };

    public void setDecorations(List<String> deco)
    {
        this.Decorations = deco;
    };

    public Bookings(String event,LocalDate date,String[][]venue,int[][] people,String[][] food,List<String> decorations)
    {
        this.EventType = event;
        this.EventDate = date;
        this.EventVenue = venue;
        this.PeopleCount = people;
        this.Food = food;
        this.Decorations = decorations;
    };
    

=======
>>>>>>> e6d7a7cbef5f375e39574227a4d30d56290c9dbc
}